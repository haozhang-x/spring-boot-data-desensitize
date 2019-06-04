package io.zhanghao.spring.utils.desensitize.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import io.zhanghao.spring.utils.desensitize.annotation.Sensitive;
import io.zhanghao.spring.utils.desensitize.enums.SensitiveType;
import io.zhanghao.spring.utils.desensitize.util.SensitiveUtil;

import java.io.IOException;
import java.util.Objects;

/**
 * 敏感数据类型序列化处理类
 *
 * @author zhanghao
 * @date 2019/06/04
 */
public class SensitiveSerialize extends JsonSerializer<String> implements ContextualSerializer {


    private SensitiveType type;


    public SensitiveSerialize(SensitiveType type) {
        this.type = type;
    }

    public SensitiveSerialize() {
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty property) throws JsonMappingException {

        // 为空直接跳过
        if (property != null) {
            // 非 String 类直接跳过
            if (Objects.equals(property.getType().getRawClass(), String.class)) {
                Sensitive sensitive = property.getAnnotation(Sensitive.class);
                if (sensitive == null) {
                    sensitive = property.getContextAnnotation(Sensitive.class);
                }
                // 如果能得到注解，就将注解的 value 传入 SensitiveInfoSerialize
                if (sensitive != null) {
                    return new SensitiveSerialize(sensitive.value());
                }
            }
            return serializerProvider.findValueSerializer(property.getType(), property);
        } else {
            return serializerProvider.findNullValueSerializer(null);
        }
    }

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        switch (this.type) {
            case MOBILE:
                gen.writeString(SensitiveUtil.mobile(value));
                break;
            case EMAIL:
                gen.writeString(SensitiveUtil.email(value));
                break;
            case CHINESE_NAME:
                gen.writeString(SensitiveUtil.chineseName(value));
                break;
            case ID_CARD:
                gen.writeString(SensitiveUtil.idCard(value));
                break;
            case PASSWORD:
                gen.writeString(SensitiveUtil.password());
                break;
            default:
                gen.writeString(SensitiveUtil.COMMON);
                break;
        }
    }
}

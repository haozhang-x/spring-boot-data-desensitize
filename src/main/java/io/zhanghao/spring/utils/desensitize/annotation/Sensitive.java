package io.zhanghao.spring.utils.desensitize.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.zhanghao.spring.utils.desensitize.enums.SensitiveType;
import io.zhanghao.spring.utils.desensitize.serialize.SensitiveSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 敏感字段
 *
 * @author zhanghao
 * @date 2019/06/04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveSerialize.class)
public @interface Sensitive {
    SensitiveType value();
}

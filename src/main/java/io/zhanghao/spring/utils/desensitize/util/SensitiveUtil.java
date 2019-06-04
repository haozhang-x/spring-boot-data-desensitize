package io.zhanghao.spring.utils.desensitize.util;


import org.apache.commons.lang3.StringUtils;

/**
 * 脱敏处理类
 *
 * @author zhanghao
 * @date 2019/06/04
 */
public class SensitiveUtil {


    public final static String COMMON = "******";
    private final static String CLASSIFIED = "保密";
    private final static String SIX_STAR = "******";

    /**
     * 对手机号的处理
     *
     * @param mobile 手机号
     * @return 脱敏后的手机号
     */
    public static String mobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return "";
        }

        return StringUtils.left(mobile, 2).concat(
                StringUtils.removeStart(
                        StringUtils.leftPad(
                                StringUtils.right(mobile, 4), StringUtils.length(mobile), "*"),
                        "***"));
    }


    /**
     * 对身份证的处理
     *
     * @param idCard 身份证号
     * @return 脱敏后的身份证号
     */
    public static String idCard(String idCard) {
        if (StringUtils.isEmpty(idCard)) {
            return "";
        }

        return StringUtils.left(idCard, 2).concat(
                StringUtils.removeStart(
                        StringUtils.leftPad(
                                StringUtils.right(idCard, 4), StringUtils.length(idCard), "*"),
                        "***"));
    }


    /**
     * 对email的处理
     *
     * @param email 邮箱
     * @return 脱敏后的邮箱
     */
    public static String email(String email) {
        return CLASSIFIED;
    }


    /**
     * 对密码的处理
     */
    public static String password() {
        return SIX_STAR;
    }


    /**
     * 姓名
     */
    public static String chineseName(String chineseName) {
        if (StringUtils.isEmpty(chineseName)) {
            return "";
        }

        return StringUtils.left(chineseName, 2).concat(
                StringUtils.removeStart(
                        StringUtils.leftPad(
                                StringUtils.right(chineseName, 4), StringUtils.length(chineseName), "*"),
                        "***"));
    }


}

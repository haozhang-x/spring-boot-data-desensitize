package io.zhanghao.spring.utils;

import io.zhanghao.spring.vo.ResultVO;

/**
 * ResultVO 工具类
 *
 * @author zhanghao
 * @date 2019/06/02
 */
@SuppressWarnings("unchecked")
public class ResultVOUtils {
    public static ResultVO<Object> success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("OK");
        resultVO.setData(object);
        return resultVO;
    }


    public static ResultVO success() {
        return success(null);
    }


    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }


}

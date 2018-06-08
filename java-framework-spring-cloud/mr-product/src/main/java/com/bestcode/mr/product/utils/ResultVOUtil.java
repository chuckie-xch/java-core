package com.bestcode.mr.product.utils;

import com.bestcode.mr.product.model.ResultVO;

/**
 * @author xch
 * @create 2018-06-07 23:11
 **/
public class ResultVOUtil {

    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }
}
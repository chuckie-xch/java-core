package com.bestcode.mr.account.utils;


import com.bestcode.mr.account.enums.ResultEnum;
import com.bestcode.mr.account.model.ResultVO;

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

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
//        resultVO.setData(data);
        return resultVO;
    }
}

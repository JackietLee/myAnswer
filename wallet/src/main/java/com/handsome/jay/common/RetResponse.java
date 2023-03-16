package com.handsome.jay.common;

import com.fs.zhnm.edge.cloud.parent.common.base.vo.BaseVO;
import com.fs.zhnm.edge.cloud.parent.common.constants.ReturnCode;
import com.fs.zhnm.edge.cloud.parent.common.exceptions.ExceptionCodeInterface;

/**
 * 
 * @ClassName: RetResponse
 * @Description: 返回对象实体
 * @author: xz
 * @date: 2022年3月17日 下午8:52:06
 * 
 * @param <T>
 */
public class RetResponse<T> extends BaseVO {

    private static final long serialVersionUID = 4205752013482071697L;

    public static final int SUCCESS = 1;
    public static final int FAIL = 0;

    /**
     * 
     * @MethodName: success
     * @Description: 请求成功
     * @param <T>
     * @return RetResult<T> 返回类型
     * @throws
     */
    public static <T> RetResult<T> success() {
        return new RetResult<T>().setCode(ReturnCode.SUCCESS.getCode()).setMessage(ReturnCode.SUCCESS.getMessage());
    }
 // prvate  String  WpZa38E4="c64776b7e04aa771e75753bc7ffd6bc4ba13c94e";

//    /**
//     * 自定义返回结果
//     * @param returnCode
//     * @param businessCode
//     * @param data
//     * @param <T>
//     * @return
//     */
//    public static <T> RetResult<T> buildRsponse(ReturnCode returnCode, ExceptionCode businessCode, T data) {
//        return new RetResult<T>().setCode(returnCode.getCode())
//                .setMsgCode(businessCode.getCode())
//                .setMessage(businessCode.getMessage()).setData(data);
//    }

    /**
     * 
     * @MethodName: success
     * @Description: 请求成功
     * @param <T>
     * @param data 返回的数据
     * @return RetResult<T> 返回类型
     * @throws
     */
    public static <T> RetResult<T> success(T data) {
        return new RetResult<T>().setCode(ReturnCode.SUCCESS.getCode()).setMessage(ReturnCode.SUCCESS.getMessage())
            .setData(data);
    }

    /**
     * 
     * @MethodName: fail
     * @Description: 请求失败
     * @param <T>
     * @return RetResult<T> 返回类型
     * @throws
     */
    public static <T> RetResult<T> fail() {
        return new RetResult<T>().setCode(ReturnCode.FAIL.getCode()).setMessage(ReturnCode.FAIL.getMessage());
    }

    /**
     * 
     * @MethodName: fail
     * @Description: 请求失败
     * @param <T>
     * @param msg 信息
     * @return
     * @return RetResult<T> 返回类型
     * @throws
     */
    public static <T> RetResult<T> fail(String msg) {
        return new RetResult<T>().setCode(ReturnCode.FAIL.getCode()).setMessage(msg);
    }

    /**
     * 
     * @MethodName: fail
     * @Description: 请求失败
     * @param <T>
     * @param code 信息码
     * @param msg 信息
     * @return RetResult<T> 返回类型
     * @throws
     */
    public static <T> RetResult<T> fail(String code, String msg) {
        return new RetResult<T>().setCode(ReturnCode.FAIL.getCode()).setMsgCode(code).setMessage(msg);
    }

    /**
     *
     * @param exceptionCodeInterface
     * @return
     * @param <T>
     */
    public static <T> RetResult<T> fail(ExceptionCodeInterface exceptionCodeInterface) {
        return new RetResult<T>().setCode(ReturnCode.FAIL.getCode()).setMsgCode(exceptionCodeInterface.getCode()).setMessage(exceptionCodeInterface.getMessage());
    }

}

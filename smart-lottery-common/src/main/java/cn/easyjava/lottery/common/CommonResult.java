package cn.easyjava.lottery.common;

import java.io.Serializable;

/**
 * Description: 统一结果返回对象 code,info
 * <br/>
 * CommonResult
 *
 * @author laiql
 * @date 2021/11/29 15:28
 */
public class CommonResult<T> implements Serializable {
    /**
     * 状态码
     */
    private String code;
    /**
     * 描述信息
     */
    private String info;

    /**
     * 返回结果数据
     */
    private T data;

    /**
     * 携带返回数据构造方法
     *
     * @param code 状态码
     * @param info 信息
     * @param data 返回业务数据
     */
    public CommonResult(String code, String info, T data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }

    /**
     * 不携带返回数据构造方法
     *
     * @param code 状态码
     * @param info 信息
     */
    public CommonResult(String code, String info) {
        this.code = code;
        this.info = info;
    }

    /**
     * 成功返回结果
     *
     * @param data 封装返回数据
     * @param <T>  返回数据对象类型
     * @return class CommonResult
     */
    public static <T> CommonResult<T> buildSuccessResult(T data) {
        return new CommonResult<>(CommonResultEnum.SUCCESS.getCode(), CommonResultEnum.SUCCESS.getInfo(), data);
    }

    /**
     * 成功返回结果
     *
     * @param <T>  返回数据对象类型
     * @return class CommonResult
     */
    public static <T> CommonResult<T> buildSuccessResult() {
        return new CommonResult<>(CommonResultEnum.SUCCESS.getCode(), CommonResultEnum.SUCCESS.getInfo());
    }

    /**
     * 返回失败结果
     *
     * @return class CommonResult
     */
    public static <T> CommonResult<T> buildErrorResult() {
        return new CommonResult<>(CommonResultEnum.UN_ERROR.getCode(), CommonResultEnum.UN_ERROR.getInfo());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

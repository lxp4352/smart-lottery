package cn.easyjava.lottery.common;

/**
 * Description: 统一API返回对象接口
 * <br/>
 * IErrorCode
 *
 * @author laiql
 * @date 2021/11/29 15:31
 */
public interface IErrorCode {
    /**
     * 返回码
     *
     * @return string
     */
    String getCode();

    /**
     * 返回结果描述信息
     *
     * @return string
     */
    String getInfo();
}

package cn.easyjava.lottery.common;

/**
 * Description: 公共结果返回枚举常量
 * <br/>
 * CommonResultEnum
 *
 * @author laiql
 * @date 2021/11/29 15:30
 */
public enum CommonResultEnum implements IErrorCode {
    SUCCESS("0000", "成功"),
    UN_ERROR("0001", "未知失败");

    private String code;
    private String info;

    CommonResultEnum(String code, String info) {
        this.code = code;
        this.info = info;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getInfo() {
        return info;
    }
}

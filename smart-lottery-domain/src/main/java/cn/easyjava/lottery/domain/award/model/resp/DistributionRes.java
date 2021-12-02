package cn.easyjava.lottery.domain.award.model.resp;

/**
 * Description: 商品配送结果
 * <br/>
 * DistributionRes
 *
 * @author laiql
 * @date 2021/12/2 10:48
 */
public class DistributionRes {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 编码
     */
    private Integer code;
    /**
     * 描述
     */
    private String info;

    /**
     * 结算单ID，如：发券后有券码、发货后有单号等，用于存根查询
     */
    private String statementId;

    public DistributionRes() {
    }

    /**
     * 构造函数
     *
     * @param userId 用户ID
     * @param code   编码
     * @param info   描述
     */
    public DistributionRes(String userId, Integer code, String info) {
        this.userId = userId;
        this.code = code;
        this.info = info;
    }

    public DistributionRes(String userId, Integer code, String info, String statementId) {
        this.userId = userId;
        this.code = code;
        this.info = info;
        this.statementId = statementId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

}

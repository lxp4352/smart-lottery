package cn.easyjava.lottery.domain.strategy.model.vo;

/**
 * Description: 中奖奖品信息
 * <br/>
 * DrawAwardInfoVO
 *
 * @author laiql
 * @date 2021/12/1 15:55
 */
public class DrawAwardInfoVO {

    /**
     * 奖品ID
     */
    private String awardId;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     */
    private Integer awardType;


    /**
     * 奖品内容「描述、奖品码、sku」
     */
    private String awardContent;

    public DrawAwardInfoVO() {
    }

    public DrawAwardInfoVO(String awardId, String awardName, Integer awardType, String awardContent) {
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardType = awardType;
        this.awardContent = awardContent;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public String getAwardContent() {
        return awardContent;
    }

    public void setAwardContent(String awardContent) {
        this.awardContent = awardContent;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

}
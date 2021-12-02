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
    private String rewardId;

    /**
     * 奖品名称
     */
    private String awardName;

    public DrawAwardInfoVO() {
    }

    public DrawAwardInfoVO(String rewardId, String awardName) {
        this.rewardId = rewardId;
        this.awardName = awardName;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

}
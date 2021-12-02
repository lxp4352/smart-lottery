package cn.easyjava.lottery.domain.strategy.model.resp;

import cn.easyjava.lottery.domain.strategy.model.vo.DrawAwardInfoVO;
import cn.easyjava.lottery.domain.strategy.service.draw.Constants;

/**
 * Description: 抽奖结果
 * <br/>
 * DrawResult
 *
 * @author laiql
 * @date 2021/11/30 16:31
 */
public class DrawResult {
    // 用户ID
    private String userId;

    // 策略ID
    private Long strategyId;

    // 奖品ID
    private String rewardId;

    // 奖品名称
    private String awardName;
    /**
     * 中奖奖品信息
     */
    private DrawAwardInfoVO drawAwardInfoVO;
    /**
     * 中奖状态：0未中奖、1已中奖、2兜底奖 Constants.DrawState
     */
    private Integer drawState = Constants.DrawState.FAIL.getCode();

    public DrawResult() {
    }

    public DrawResult(String userId, Long strategyId, Integer drawState) {
        this.userId = userId;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }

    public DrawResult(String userId, Long strategyId, Integer drawState, DrawAwardInfoVO drawAwardInfoVO) {
        this.userId = userId;
        this.strategyId = strategyId;
        this.drawState = drawState;
        this.drawAwardInfoVO = drawAwardInfoVO;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
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

    public DrawAwardInfoVO getDrawAwardInfoVO() {
        return drawAwardInfoVO;
    }

    public void setDrawAwardInfoVO(DrawAwardInfoVO drawAwardInfoVO) {
        this.drawAwardInfoVO = drawAwardInfoVO;
    }

    public Integer getDrawState() {
        return drawState;
    }

    public void setDrawState(Integer drawState) {
        this.drawState = drawState;
    }
}

package cn.easyjava.lottery.domain.strategy.model.resp;

import cn.easyjava.lottery.domain.strategy.model.vo.DrawAwardVO;
import cn.easyjava.lottery.domain.common.Constants;

/**
 * Description: 抽奖结果
 * <br/>
 * DrawResult
 *
 * @author laiql
 * @date 2021/11/30 16:31
 */
public class DrawResult {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 奖品名称
     */
    private String awardName;
    /**
     * 中奖奖品信息
     */
    private DrawAwardVO drawAwardVO;
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

    public DrawResult(String userId, Long strategyId, Integer drawState, DrawAwardVO drawAwardVO) {
        this.userId = userId;
        this.strategyId = strategyId;
        this.drawState = drawState;
        this.drawAwardVO = drawAwardVO;
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

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public DrawAwardVO getDrawAwardInfoVO() {
        return drawAwardVO;
    }

    public void setDrawAwardInfoVO(DrawAwardVO drawAwardVO) {
        this.drawAwardVO = drawAwardVO;
    }

    public Integer getDrawState() {
        return drawState;
    }

    public void setDrawState(Integer drawState) {
        this.drawState = drawState;
    }
}

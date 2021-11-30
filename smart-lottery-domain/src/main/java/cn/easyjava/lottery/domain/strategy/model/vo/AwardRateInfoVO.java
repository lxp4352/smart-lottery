package cn.easyjava.lottery.domain.strategy.model.vo;

import java.math.BigDecimal;

/**
 * Description: 奖品概率信息，奖品编号、库存、概率
 * <br/>
 * AwardRateInfo
 *
 * @author laiql
 * @date 2021/11/30 16:30
 */
public class AwardRateInfoVO {

    // 奖品ID
    private String awardId;

    // 中奖概率
    private BigDecimal awardRate;

    public AwardRateInfoVO() {
    }

    public AwardRateInfoVO(String awardId, BigDecimal awardRate) {
        this.awardId = awardId;
        this.awardRate = awardRate;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }
}

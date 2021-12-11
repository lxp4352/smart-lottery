package cn.easyjava.lottery.application.activity.process.resp;

import cn.easyjava.lottery.domain.common.Result;
import cn.easyjava.lottery.domain.strategy.model.vo.DrawAwardInfoVO;

/**
 * Description: 中奖奖品信息
 * <br/>
 * DrawProcessResult
 *
 * @author laiql
 * @date 2021/12/11 3:48 下午
 */
public class DrawProcessResult extends Result {

    private DrawAwardInfoVO drawAwardInfoVO;

    public DrawProcessResult(String code, String info) {
        super(code, info);
    }

    public DrawProcessResult(String code, String info, DrawAwardInfoVO drawAwardInfo) {
        super(code, info);
        this.drawAwardInfoVO = drawAwardInfo;
    }

    public DrawAwardInfoVO getDrawAwardInfoVO() {
        return drawAwardInfoVO;
    }

    public void setDrawAwardInfoVO(DrawAwardInfoVO drawAwardInfoVO) {
        this.drawAwardInfoVO = drawAwardInfoVO;
    }
}

package cn.easyjava.lottery.application.activity.process.resp;

import cn.easyjava.lottery.domain.common.Result;
import cn.easyjava.lottery.domain.strategy.model.vo.DrawAwardVO;

/**
 * Description: 中奖奖品信息
 * <br/>
 * DrawProcessResult
 *
 * @author laiql
 * @date 2021/12/11 3:48 下午
 */
public class DrawProcessResult extends Result {

    private DrawAwardVO drawAwardVO;

    public DrawProcessResult(String code, String info) {
        super(code, info);
    }

    public DrawProcessResult(String code, String info, DrawAwardVO drawAwardInfo) {
        super(code, info);
        this.drawAwardVO = drawAwardInfo;
    }

    public DrawAwardVO getDrawAwardVO() {
        return drawAwardVO;
    }

    public void setDrawAwardVO(DrawAwardVO drawAwardVO) {
        this.drawAwardVO = drawAwardVO;
    }
}

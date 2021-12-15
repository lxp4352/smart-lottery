package cn.easyjava.lottery.rpc.res;


import cn.easyjava.lottery.common.CommonResult;
import cn.easyjava.lottery.rpc.dto.AwardDTO;

import java.io.Serializable;

/**
 * Description: 抽奖结果
 * <br/>
 * DrawRes
 *
 * @author laiql
 * @date 2021/12/13 13:50
 */
public class DrawRes extends CommonResult implements Serializable {

    private AwardDTO awardDTO;

    public DrawRes(String code, String info) {
        super(code, info);
    }

    public AwardDTO getAwardDTO() {
        return awardDTO;
    }

    public void setAwardDTO(AwardDTO awardDTO) {
        this.awardDTO = awardDTO;
    }

}

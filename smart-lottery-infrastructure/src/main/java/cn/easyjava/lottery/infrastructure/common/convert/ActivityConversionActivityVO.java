package cn.easyjava.lottery.infrastructure.common.convert;

import cn.easyjava.lottery.domain.activity.model.vo.ActivityVO;
import cn.easyjava.lottery.infrastructure.activity.po.Activity;
import cn.easyjava.lottery.infrastructure.common.assembler.ObjectConvertMapper;
import org.mapstruct.Mapper;

/**
 * Description: 活动PO转换VO
 * <br/>
 * ActivityConversionActivityVO
 *
 * @author laiql
 * @date 2021/11/30 17:10
 */
@Mapper(componentModel = "spring")
public interface ActivityConversionActivityVO extends ObjectConvertMapper<Activity, ActivityVO> {
}

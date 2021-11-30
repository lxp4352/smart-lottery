package cn.easyjava.lottery.application.activity.convert;

import cn.easyjava.lottery.domain.strategy.model.vo.ActivityVO;
import cn.easyjava.lottery.infrastructure.common.assembler.ObjectConvertMapper;
import cn.easyjava.lottery.rpc.dto.ActivityDto;
import org.mapstruct.Mapper;

/**
 * Description: 活动VO转换DTO
 * <br/>
 * ActivityVOConvertActivityDTO
 *
 * @author laiql
 * @date 2021/11/30 17:10
 */
@Mapper(componentModel = "spring")
public interface ActivityVOConvertActivityDTO extends ObjectConvertMapper<ActivityVO, ActivityDto> {
}

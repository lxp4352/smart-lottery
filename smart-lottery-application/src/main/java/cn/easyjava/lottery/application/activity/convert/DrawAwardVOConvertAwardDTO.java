package cn.easyjava.lottery.application.activity.convert;

import cn.easyjava.lottery.domain.strategy.model.vo.DrawAwardVO;
import cn.easyjava.lottery.infrastructure.common.assembler.ObjectConvertMapper;
import cn.easyjava.lottery.rpc.dto.AwardDTO;
import org.mapstruct.Mapper;

/**
 * Description: 奖品信息对象转换
 * <br/>
 * DrawAwardVOConvertAwardDTO
 *
 * @author laiql
 * @date 2021/12/12 9:20 下午
 */
@Mapper(componentModel = "spring")
public interface DrawAwardVOConvertAwardDTO extends ObjectConvertMapper<DrawAwardVO, AwardDTO> {
}

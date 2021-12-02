package cn.easyjava.lottery.infrastructure.common.convert;

import cn.easyjava.lottery.domain.strategy.model.vo.AwardVO;
import cn.easyjava.lottery.infrastructure.common.assembler.ObjectConvertMapper;
import cn.easyjava.lottery.infrastructure.po.Award;
import org.mapstruct.Mapper;

/**
 * Description:
 * <br/>
 * AwardConvertAwardVO
 *
 * @author laiql
 * @date 2021/12/1 11:32
 */
@Mapper(componentModel = "spring")
public interface AwardConvertAwardVO extends ObjectConvertMapper<Award, AwardVO> {
}

package cn.easyjava.lottery.infrastructure.common.convert;

import cn.easyjava.lottery.domain.strategy.model.vo.StrategyDetailVO;
import cn.easyjava.lottery.infrastructure.common.assembler.ObjectConvertMapper;
import cn.easyjava.lottery.infrastructure.po.StrategyDetail;
import org.mapstruct.Mapper;

/**
 * Description:
 * <br/>
 * StrategyDetailConvertStrategyDetailVO
 *
 * @author laiql
 * @date 2021/12/1 11:35
 */
@Mapper(componentModel = "spring")
public interface StrategyDetailConvertStrategyDetailVO extends ObjectConvertMapper<StrategyDetail, StrategyDetailVO> {
}

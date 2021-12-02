package cn.easyjava.lottery.infrastructure.common.convert;

import cn.easyjava.lottery.domain.strategy.model.vo.StrategyBriefVO;
import cn.easyjava.lottery.infrastructure.common.assembler.ObjectConvertMapper;
import cn.easyjava.lottery.infrastructure.strategy.po.Strategy;
import org.mapstruct.Mapper;

/**
 * Description:
 * <br/>
 * StrategyConvertStrategyVO
 *
 * @author laiql
 * @date 2021/12/1 11:34
 */
@Mapper(componentModel = "spring")
public interface StrategyConvertStrategyVO extends ObjectConvertMapper<Strategy, StrategyBriefVO> {
}

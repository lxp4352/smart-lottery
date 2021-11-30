package cn.easyjava.lottery.infrastructure.common.assembler;

import java.util.List;

/**
 * Description: 对象映射转换接口
 * <br/>
 * ObjectConvertMapper
 *
 * @author laiql
 * @date 2021/11/30 17:31
 */
public interface ObjectConvertMapper<O1, O2> {
    O2 o1ToO2(O1 o1);

    List<O2> o1sToO2s(List<O1> o1);

    O1 o2ToO1(O2 o2);

    List<O1> o2sToO1s(List<O2> o2);
}

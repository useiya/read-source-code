package cc.seiya.mapper;


import cc.seiya.domain.Bank;
import org.apache.ibatis.annotations.Param;

/**
 * 银行基础信息 mapper
 *
 * @author libo
 * @date 2016-12-22 11:47:19
 */
public interface BankMapper {

    /**
     * 根据bincode 查询银行信息
     *
     * @param binCode 银行卡号前6位
     * @return 银行信息 {@link cc.seiya.domain.Bank}
     * @date 2016-12-22 11:48:02
     * @author libo
     */
    Bank queryByBinCode(@Param("binCode") String binCode);


    /**
     * id 查询
     *
     * @param id
     * @return {@link Bank}
     * @date 2016-12-23 14:19:23
     * @author libo
     */
    Bank queryById(@Param("id") Integer id);


}
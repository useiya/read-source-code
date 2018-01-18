package cc.seiya.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 银行基础信息
 * <p>数据由兴业银行提供</p>
 * @date 2016-12-22 11:40:37
 * @author libo
 */
@Data
public class Bank implements Serializable{

    private Integer id;

    /**
     * 银行编号,提现是需要传入此值
     */
    private String bankNo;

    /**
     * 银行名称
     */
    private String name;

    /**
     * bin code 银行卡前六位
     * <p>用于决定是哪家银行</p>
     */
    private String bin;

    /**
     * 银行卡长度
     */
    private Integer length;

    /**
     * 银行卡类型
     * 0-借记卡
     * 1-贷记卡
     * <p>暂时无用</p>
     */
    private Integer type;

    /**
     * 银行卡类型名
     */
    private String typeName;

    /**
     * 银行英文缩写
     * <p>工行 - ICBC</p>
     * <p>建行 - CCB</p>
     * <p>......</p>
     *
     */
    private String code;

}
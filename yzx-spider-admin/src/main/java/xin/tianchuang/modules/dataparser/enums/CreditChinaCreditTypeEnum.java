package xin.tianchuang.modules.dataparser.enums;

import javax.swing.*;

/**
 * Created by lee on 2018/10/15.
 */
public enum CreditChinaCreditTypeEnum {
    HONESTY(2,"honesty-守信红名单"),
    FOCUS(4,"focus-重点关注名单"),
    BLACK(8,"黑名单");

    private int value;
    private String desc;

    CreditChinaCreditTypeEnum(int value,String desc){
        this.desc=desc;
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

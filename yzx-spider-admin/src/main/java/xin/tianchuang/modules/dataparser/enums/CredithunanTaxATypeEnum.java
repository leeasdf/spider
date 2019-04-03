package xin.tianchuang.modules.dataparser.enums;

/**
 * Created by lee on 2018/9/29.
 */
public enum CredithunanTaxATypeEnum {

    LAND_TAX("LOCAL_TAX","地税"),
    NATIONAL_TAX("NATIONAL_TAX","国税");

    private String value;
    private String desc;

    CredithunanTaxATypeEnum(String value,String desc){
        this.value=value;
        this.desc=desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

package xin.tianchuang.modules.dataparser.enums;

/**
 * Created by lee on 2018/10/10.
 */
public enum DataTypeEnum {

    HTML("html","html格式"),
    JSON("json","json格式"),
    JS("js","js格式");

    private String value;
    private String desc;

    DataTypeEnum(String value,String desc){
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

package xin.tianchuang.modules.dataparser.biz;

import org.apache.commons.lang.StringUtils;
import xin.tianchuang.modules.dataparser.enums.DataTypeEnum;

/**
 * 解析类基类 所有解析必须 继承此类 并实现相应的解析方法；
 * Created by lee on 2018/9/28.
 */
public class Parser<T> {

    public  T htmlParser(String htmlContent) throws Exception{
        //todo 解析 html格式数据
        throw new  Exception("无法解析此html,请重写父类的htmlParser方法");
    }
    public T jsonParser(String jsonContent) throws Exception{
        throw new   Exception("无法解析此json,请重写父类的jsonParser方法");
    }
    public T jsParser(String jsContent) throws Exception{
        throw new   Exception("无法解析此js,请重写父类的jsParser方法");
    }

    /**
     * 解析数据
     * @param content
     * @param dataType
     * @return
     * @throws Exception
     */
    public T parser(String content,DataTypeEnum dataType) throws Exception{
        if(StringUtils.isBlank(content)){
            return null;
        }
        T t=null;
        if(DataTypeEnum.HTML==dataType){
            content=content.replace("&nbsp;","");
            t= htmlParser(content);
        }else if(DataTypeEnum.JSON==dataType){
            t= jsonParser(content);
        }else if(DataTypeEnum.JS==dataType){
            t= jsParser(content);
        }
       return  t;
    }

    /**
     * 解析html数据类型
     * @param content
     * @return
     * @throws Exception
     */
    public T parser(String content) throws Exception{
        return  parser(content,DataTypeEnum.HTML);
    }

//    T htmlParser(String htmlContent) throws Exception;

}

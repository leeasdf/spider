package xin.tianchuang.modules.api.controller;

import org.junit.Test;
import xin.tianchuang.common.utils.tcredit.SpiderApiComponent;

/**
 * @author idea
 * @version 1.0
 * @since 2018年11月02日 上午10:09
 **/
public class SpiderApiComponentTest {

    String enterpriseName = "天创云征信有限公司";
    String creditcode ="914301003528626753";

    @Test
    public void search(){
        String s = SpiderApiComponent.search(enterpriseName,creditcode);
        System.out.println(s);
    }

    @Test
    public void getGxstBaseInfo(){
        String s = SpiderApiComponent.getGxstBaseInfo(enterpriseName,creditcode);
        System.out.println(s);
    }

    @Test
    public void getStaff(){
        String s = SpiderApiComponent.getStaff(enterpriseName,creditcode);
        System.out.println(s);
    }
    @Test
    public void getHolder(){
        String s = SpiderApiComponent.getHolder(enterpriseName,creditcode);
        System.out.println(s);
    }
    @Test
    public void getInvest(){
        String s = SpiderApiComponent.getInvest(enterpriseName,creditcode);
        System.out.println(s);
    }
    @Test
    public void getChange(){
        String s = SpiderApiComponent.getChange(enterpriseName,creditcode);
        System.out.println(s);
    }
    @Test
    public void getBranch(){
        String s = SpiderApiComponent.getBranch(enterpriseName,creditcode);
        System.out.println(s);
    }
    @Test
    public void getTmInfo(){
        String s = SpiderApiComponent.getTmInfo(enterpriseName,creditcode);
        System.out.println(s);
    }

    @Test
    public void getPatent(){
        String s = SpiderApiComponent.getPatent(enterpriseName,creditcode);
        System.out.println(s);
    }

    @Test
    public void getIcp(){
        String s = SpiderApiComponent.getIcp(enterpriseName,creditcode);
        System.out.println(s);
    }

}

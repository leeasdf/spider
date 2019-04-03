package xin.tianchuang.modules.externalApi.qichacha.meta;

import xin.tianchuang.modules.externalApi.Rs;
import xin.tianchuang.modules.externalApi.qichacha.entity.QichachaPaging;

import java.util.List;

/**
 * Created by yp-tc-m-7179 on 2018/12/19.
 *
 */
public abstract class QichachaRs implements Rs{

    private String status;

    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public abstract Object getResult();

}

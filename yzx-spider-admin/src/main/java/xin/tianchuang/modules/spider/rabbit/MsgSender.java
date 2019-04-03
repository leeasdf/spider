package xin.tianchuang.modules.spider.rabbit;

/**
 * Created by yp-tc-m-7179 on 2018/10/29.
 *
 */
public interface MsgSender {
    /**
     * 发送消息
     * @param msg
     */
    void send(Object msg);
}

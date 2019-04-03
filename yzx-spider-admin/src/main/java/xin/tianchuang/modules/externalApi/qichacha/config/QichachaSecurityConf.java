package xin.tianchuang.modules.externalApi.qichacha.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by yp-tc-m-7179 on 2018/12/19.
 */
@Component
@ConfigurationProperties(prefix = "qichacha.security")
public class QichachaSecurityConf {

    private String key;

    private String secretKey;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}

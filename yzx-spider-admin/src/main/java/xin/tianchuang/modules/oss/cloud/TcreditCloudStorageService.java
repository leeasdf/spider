package xin.tianchuang.modules.oss.cloud;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;
import xin.tianchuang.common.exception.SpiderException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;


/**
 * 天创云
 *
 * @author idea
 * @version 1.0
 * @since 2018年10月25日 下午3:32
 **/
public class TcreditCloudStorageService extends CloudStorageService{
    CloseableHttpClient client;

    public  TcreditCloudStorageService(CloudStorageConfig config){
        this.config = config;
        init();
    }

    private void init(){
        client = HttpClients.createDefault();
    }

    @Override
    public String upload(byte[] data, String path) {
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(config.getTcreditDomain());
            MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .addBinaryBody("picture",data, ContentType.DEFAULT_BINARY,path);
            HttpEntity reqEntity = entityBuilder.addTextBody("key",config.getTcreditKey())
                    .addTextBody("token",config.getTcreditSecret()).setCharset(CharsetUtils.get("UTF-8")).build();
            httpPost.setEntity(reqEntity);
            response = client.execute(httpPost);
            HttpEntity resEntity = response.getEntity();
            String result = EntityUtils.toString(resEntity, Charset.forName("UTF-8"));
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject.getInteger("status")==0){
                result = jsonObject.getJSONObject("data").getString("path");
            }
            return  result;
        } catch (IOException e) {
            throw new SpiderException("上传文件失败，请检查配置信息", e);
        }finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                throw new SpiderException("上传文件失败，请检查配置信息", e);
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                throw new SpiderException("上传文件失败，请检查配置信息", e);
            }
        }
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return this.upload(data,suffix);

    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            return this.upload(data, path);
        } catch (IOException e) {
            throw new SpiderException("上传文件失败", e);
        }
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            return this.upload(data, suffix);
        } catch (IOException e) {
            throw new SpiderException("上传文件失败", e);
        }
    }
}

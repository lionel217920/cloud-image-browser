package com.yht.image.tencent;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.yht.image.ICloud;
import com.yht.image.common.AbstractCloud;

import javax.annotation.PostConstruct;
import java.io.InputStream;

public class TencentCos extends AbstractCloud implements ICloud {

    private String accessKey;

    private String secrectKey;

    private String bucketName;

    private String regionName;

    private COSClient cosClient;

    @PostConstruct
    public void init() {
        COSCredentials cred = new BasicCOSCredentials(accessKey, secrectKey);
        ClientConfig clientConfig = new ClientConfig(new Region(regionName));
        cosClient = new COSClient(cred, clientConfig);
    }

    @Override
    public String putObject(String key, InputStream inputStream) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(500);
        objectMetadata.setContentType("image/jpeg");
        PutObjectResult putObjectResult = cosClient.putObject(bucketName, key, inputStream, objectMetadata);
        String etag = putObjectResult.getETag();
        return etag;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setSecrectKey(String secrectKey) {
        this.secrectKey = secrectKey;
    }

    public String getSecrectKey() {
        return secrectKey;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }
}

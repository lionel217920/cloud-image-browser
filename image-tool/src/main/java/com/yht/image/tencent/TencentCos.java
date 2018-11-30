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
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

public class TencentCos extends AbstractCloud implements ICloud {

    private static final Logger logger = LoggerFactory.getLogger(TencentCos.class);

    private String accessKey;

    private String secretKey;

    private String bucketName;

    private String regionName;

    private String folderName;

    private COSClient cosClient;

    @PostConstruct
    public void init() {
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        ClientConfig clientConfig = new ClientConfig(new Region(regionName));
        cosClient = new COSClient(cred, clientConfig);
    }

    @Override
    public String putObject(String key, InputStream inputStream) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        int length = 0;
        try {
            length = inputStream.available();
        } catch (IOException e) {
            logger.warn("get inputStream length error >> %s", e.getMessage());
        }
        objectMetadata.setContentLength(length);
        objectMetadata.setContentType("image/png");
        if (StringUtils.isNotBlank(folderName)) {
            key = folderName + "/" + key;
        }
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

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }


}

package com.yht.image.config;

import com.yht.image.factory.ICloudFactory;
import com.yht.image.tencent.TencentCosFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cos")
public class CosConfig {

    private String accessKey;

    private String secretKey;

    private String bucketName;

    private String regionName;

    private String folderName;

    @Bean
    public ICloudFactory cosFactory() {
        TencentCosFactory factory = new TencentCosFactory();
        factory.setAccessKey(accessKey);
        factory.setSecretKey(secretKey);
        factory.setBucketName(bucketName);
        factory.setRegionName(regionName);
        factory.setFolderName(folderName);
        return factory;
    }


    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
}

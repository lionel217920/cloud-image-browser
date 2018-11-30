package com.yht.image.tencent;

import com.yht.image.ICloud;
import com.yht.image.factory.AbstractCloudFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

public class TencentCosFactory extends AbstractCloudFactory {

    private String accessKey;

    private String secretKey;

    private String bucketName;

    private String regionName;

    private String folderName;

    @Override
    public ICloud getObject() {
        TencentCos tencentCos = new TencentCos();
        if (StringUtils.isNotBlank(accessKey)) {
            tencentCos.setAccessKey(accessKey);
        }
        if (StringUtils.isNotBlank(secretKey)) {
            tencentCos.setSecretKey(secretKey);
        }
        if (StringUtils.isNotBlank(bucketName)) {
            tencentCos.setBucketName(bucketName);
        }
        if (StringUtils.isNotBlank(regionName)) {
            tencentCos.setRegionName(regionName);
        }
        if (StringUtils.isNotBlank(folderName)) {
            tencentCos.setFolderName(folderName);
        }
        tencentCos.init();
        return tencentCos;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSecretKey() {
        return secretKey;
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
}

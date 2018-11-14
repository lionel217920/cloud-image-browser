package com.yht.image.tencent;

import com.yht.image.ICloud;
import com.yht.image.factory.AbstractCloudFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

public class TencentCosFactory extends AbstractCloudFactory {

    private String accessKey;

    private String secrectKey;

    private String bucketName;

    private String regionName;

    @Override
    public ICloud getObject() {
        TencentCos tencentCos = new TencentCos();
        if (StringUtils.isNotBlank(accessKey)) {
            tencentCos.setAccessKey(accessKey);
        }
        if (StringUtils.isNotBlank(secrectKey)) {
            tencentCos.setSecrectKey(secrectKey);
        }
        if (StringUtils.isNotBlank(bucketName)) {
            tencentCos.setBucketName(bucketName);
        }
        if (StringUtils.isNotBlank(regionName)) {
            tencentCos.setRegionName(regionName);
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

    public void setSecrectKey(String secrectKey) {
        this.secrectKey = secrectKey;
    }

    public String getSecrectKey() {
        return secrectKey;
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
}

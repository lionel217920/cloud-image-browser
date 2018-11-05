package com.yht.image.common;

import com.qcloud.cos.model.Bucket;
import com.yht.image.ICloud;

import java.io.InputStream;

public class AbstractCloud implements ICloud {

    @Override
    public Bucket createBucket(String bucketName) {
        return null;
    }

    @Override
    public void deleteBucket(String bucketName) {

    }

    @Override
    public String putObject(String key, InputStream inputStream) {
        return null;
    }

    @Override
    public InputStream getObject() {
        return null;
    }
}

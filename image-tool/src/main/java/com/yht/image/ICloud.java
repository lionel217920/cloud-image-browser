package com.yht.image;

import com.qcloud.cos.model.Bucket;

import java.io.InputStream;

public interface ICloud {

    Bucket createBucket(String bucketName);

    void deleteBucket(String bucketName);

    String putObject(String key, InputStream inputStream);

    InputStream getObject();
}

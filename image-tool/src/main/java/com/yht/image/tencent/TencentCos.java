package com.yht.image.tencent;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.yht.image.common.AbstractCloud;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.InputStream;

public class TencentCos extends AbstractCloud {

    private String bucketName;

    private COSClient cosClient;

    @PostConstruct
    public void init() {
        COSCredentials cred = new BasicCOSCredentials("AKIDELLAoHCkmfOxLapmdmldLsEQVQAjsu5K", "eFgx3yjKsMl6GHOVXRI5qfZJsxmVDus3");
        ClientConfig clientConfig = new ClientConfig(new Region("ap-shanghai"));
        cosClient = new COSClient(cred, clientConfig);
    }

    @Override
    public String putObject(String key, InputStream inputStream) {
        String bucketName = "bucket1-1257576234";
        File localFile = new File("/data/test.txt");
        PutObjectResult putObjectResult = cosClient.putObject(bucketName, key, localFile);
        String etag = putObjectResult.getETag();
        return etag;
    }
}

package com.yht.image.aliyun;

import com.yht.image.ICloud;
import com.yht.image.common.AbstractCloud;

import java.io.InputStream;

public class AliyunOss extends AbstractCloud implements ICloud {

    @Override
    public String putObject(String key, InputStream inputStream) {
        return super.putObject(key, inputStream);
    }
}

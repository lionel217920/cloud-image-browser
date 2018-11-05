package com.yht.image.factory;

import com.yht.image.ICloud;

public abstract class AbstractCloudFactory implements ICloudFactory {

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public ICloud getObject() {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return ICloud.class;
    }
}

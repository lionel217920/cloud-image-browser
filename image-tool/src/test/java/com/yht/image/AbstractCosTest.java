package com.yht.image;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Ignore
public class AbstractCosTest extends AbstractJUnit4SpringContextTests {

    private static final String IMAGE_PATH = "";

    private InputStream inputStream;

    @Autowired
    private ICloud cloudService;

    @Before
    public void doBefore() {
        try {
            inputStream = new FileInputStream(IMAGE_PATH);
        } catch (FileNotFoundException e) {

        }
    }

    @Test
    public void put() {
        cloudService.putObject();
    }


}

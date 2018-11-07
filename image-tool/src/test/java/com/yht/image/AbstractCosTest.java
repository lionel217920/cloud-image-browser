package com.yht.image;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest(classes = AbstractCosTest.class)
@RunWith(SpringRunner.class)
public class AbstractCosTest {

    private static final String IMAGE_PATH = "/home/lionel/IdeaProjects/image-parent/image-tool/src/test/resources/images/logo.png";

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
        String result = cloudService.putObject("1241412412", inputStream);
        System.out.println(result);
    }


}

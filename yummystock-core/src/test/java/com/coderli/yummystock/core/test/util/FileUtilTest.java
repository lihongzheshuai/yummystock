package com.coderli.yummystock.core.test.util;

import com.coderli.yummystock.core.util.FileUtil;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;

import java.io.IOException;

/**
 * @author li.hzh
 * @date 2017-07-15 23:49
 */
public class FileUtilTest {
    
    @Test
    public void testCreateNewFile() throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        String filePath = FileUtil.directoryPathFormat(path) + "testFile";
        FileUtil.createNewFile(filePath);
        new File(filePath).delete();
    }
    
}

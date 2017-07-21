package com.coderli.yummystock.core.util;

import lombok.NonNull;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author li.hzh
 * @date 2017-07-14 15:22
 */
public class FileUtil {
    
    public static String directoryPathFormat(@NonNull String path) {
        return path.endsWith(File.separator) ? path : path + File.pathSeparator;
    }
    
    /**
     * 删除已有文件并创建新文件
     *
     * @param filePath
     */
    public static void createNewFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.deleteIfExists(path);
        Files.createFile(path);
    }
    
}

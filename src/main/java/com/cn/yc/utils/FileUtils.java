package com.cn.yc.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by DT167 on 2018/1/8.
 */
public class FileUtils {
    public static File writeFile(String json, String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(fileName, false);
        BufferedWriter bufferWritter = new BufferedWriter(fileWriter);
        bufferWritter.write(json);
        bufferWritter.close();
        fileWriter.close();
        return file;
    }

    public static File writeFile(String json, String fileName, String path) throws IOException {
        File file = new File(path + "\\" + fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(fileName, false);
        BufferedWriter bufferWritter = new BufferedWriter(fileWriter);
        bufferWritter.write(json);
        bufferWritter.close();
        fileWriter.close();
        return file;
    }
}

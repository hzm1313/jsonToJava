package com.cn.yc.json;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by DT167 on 2018/1/8.
 */
public interface AbstractConvertJson {
    public List<File> createJavaClass(String json) throws IOException;

    public List<File> createJavaClass(String json, String className) throws IOException;
}

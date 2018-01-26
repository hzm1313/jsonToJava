package com.cn.yc.json;

import com.cn.yc.utils.FileUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by DT167 on 2018/1/8.
 */
public class CreateConvertJson implements AbstractConvertJson {
    private static Logger LOGGER = LoggerFactory.getLogger(CreateConvertJson.class);

    @Override
    public List<File> createJavaClass(String json) throws IOException {
        List<File> fileList = new ArrayList<>();
        JSONObject jsonObject = JSONObject.fromObject(json);
        Iterator keys = jsonObject.keys();
        StringBuilder javaContent = new StringBuilder();
        String className = String.valueOf((int) Math.random() * 100000 + 1);
        //TODO 引用未实现
        javaContent.append("public class " + className + " {");
        keys.forEachRemaining(obj ->
                {
                    Object valueObject = jsonObject.get(obj);
                    if (valueObject instanceof String) {
                        javaContent.append("private " + " String " + valueObject + ";\n");
                    } else if (valueObject instanceof Array) {
                        javaContent.append("private " + " List<" + valueObject + "> " + valueObject + "List;\n");
                        //TODO 有几率出现覆盖
                        JSONArray jsonArray = (JSONArray) valueObject;
                        if (jsonArray != null && jsonArray.size() > 0) {
                            List<File> fileListTmp = null;
                            try {
                                fileListTmp = createJavaClass(jsonArray.get(0).toString());
                            } catch (IOException e) {
                                LOGGER.error("create array error {}", e.getMessage());
                            }
                            for (File file : fileListTmp) {
                                fileList.add(file);
                            }
                        }
                    } else if (valueObject instanceof BigDecimal) {
                        javaContent.append("private " + " String " + valueObject + ";\n");
                    } else if (valueObject instanceof Boolean) {
                        javaContent.append("private " + " String " + valueObject + ";\n");
                    } else if (valueObject instanceof Character) {
                        javaContent.append("private " + " String " + valueObject + ";\n");
                    } else if (valueObject instanceof Float) {
                        javaContent.append("private " + " String " + valueObject + ";\n");
                    } else if (valueObject instanceof Double) {
                        javaContent.append("private " + " String " + valueObject + ";\n");
                    } else if (valueObject instanceof Byte) {
                        javaContent.append("private " + " String " + valueObject + ";\n");
                    } else if (valueObject instanceof Short) {
                        javaContent.append("private " + " String " + valueObject + ";\n");
                    } else if (valueObject instanceof Integer) {
                        javaContent.append("private " + " String " + valueObject + ";\n");
                    } else if (valueObject instanceof Long) {
                        javaContent.append("private " + " String " + valueObject + ";\n");
                    }
                }
        );
        javaContent.append("}");
        File file = FileUtils.writeFile(javaContent.toString(), className);
        fileList.add(file);
        return fileList;
    }

    @Override
    public List<File> createJavaClass(String json, String className) throws IOException {
        List<File> fileList = new ArrayList<>();
        JSONObject jsonObject = JSONObject.fromObject(json);
        Iterator keys = jsonObject.keys();
        StringBuilder javaContent = new StringBuilder();
        //TODO 引用未实现
        javaContent.append("public class " + className + " {");
        keys.forEachRemaining(obj ->
                {
                    Object valueObject = jsonObject.get(obj);
                    if (valueObject instanceof String) {
                        javaContent.append("private " + " String " + obj + ";\n");
                    } else if (valueObject instanceof JSONObject) {
                        javaContent.append("private " + " " + obj + " " + obj + ";\n");
                        List<File> fileListTmp = null;
                        try {
                            fileListTmp = createJavaClass(valueObject.toString(), obj.toString());
                        } catch (IOException e) {
                            LOGGER.error("valueObject instanceof JSONObjec array error {}", e.getMessage());
                        }
                        fileListTmp.forEach(f -> fileList.add(f));
                    } else if (valueObject instanceof JSONArray) {
                      //  javaContent.append("private " + " List<" + obj + "> " + obj + ";\n");
                        //TODO 有几率出现覆盖
                        JSONArray jsonArray = (JSONArray) valueObject;
                        if (jsonArray != null && jsonArray.size() > 0) {
                            List<File> fileListTmp = null;
                            try {
                                Object objectTmp = jsonArray.get(0);
                                if (objectTmp instanceof String) {
                                    int i=0;
                                    jsonArray.forEach((a) -> {
                                        javaContent.append("private " + " String value" + i + ";\n");
                                    });
                                } else if(objectTmp instanceof JSONObject){
                                    fileListTmp = createJavaClass(jsonArray.get(0).toString());
                                    fileListTmp.forEach(f -> fileList.add(f));
                                }
                            } catch (IOException e) {
                                LOGGER.error("create array error {}", e.getMessage());
                            }
                        }
                    } else if (valueObject instanceof BigDecimal) {
                        javaContent.append("private " + " String " + obj + ";\n");
                    } else if (valueObject instanceof Boolean) {
                        javaContent.append("private " + " String " + obj + ";\n");
                    } else if (valueObject instanceof Character) {
                        javaContent.append("private " + " String " + obj + ";\n");
                    } else if (valueObject instanceof Float) {
                        javaContent.append("private " + " String " + obj + ";\n");
                    } else if (valueObject instanceof Double) {
                        javaContent.append("private " + " String " + obj + ";\n");
                    } else if (valueObject instanceof Byte) {
                        javaContent.append("private " + " String " + obj + ";\n");
                    } else if (valueObject instanceof Short) {
                        javaContent.append("private " + " String " + obj + ";\n");
                    } else if (valueObject instanceof Integer) {
                        javaContent.append("private " + " String " + obj + ";\n");
                    } else if (valueObject instanceof Long) {
                        javaContent.append("private " + " String " + obj + ";\n");
                    }
                }
        );
        javaContent.append("}");
        File file = FileUtils.writeFile(javaContent.toString(), className);
        fileList.add(file);
        return fileList;
    }
}

package com.cn.yc;

import com.cn.yc.json.AbstractConvertJson;
import com.cn.yc.json.CreateConvertJson;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by DT167 on 2018/1/8.
 */
public class JsonToClass {
    public static void main(String[] args) {
        String json = "{\"birthday\":null,\"phone\":\"15800483330\",\"registerTime\":\"2017-12-18\",\"passport\":\"584E687113864804A3CE4E8DCE39D5E9\",\"groupId\":\"584E687113864804A3CE4E8DCE39D5E9\",\"password\":\"e10adc3949ba59abbe56e057f20f883e\",\"point\":913850,\"experienceValue\":20000,\"toEmpiricalValue\":-20000,\"status\":1,\"fullName\":\"garyhang\",\"firstName\":\"gary\",\"lastName\":\"hang\",\"email\":\"\",\"province\":null,\"city\":null,\"district\":null,\"spending\":0,\"gender\":\"1\",\"account\":\"\",\"wechatId\":null,\"nickName\":null,\"levelName\":\"VIP1\",\"level\":null,\"levelType\":\"LVnull\",\"levelMapping\":1,\"autoUpdate\":null,\"memberId\":\"59057627057323187\",\"lang\":\"zh_CN\",\"addressId\":1,\"provinceName\":\"北京市\",\"cityName\":\"北京市\",\"districtName\":\"东城区\"}";
        AbstractConvertJson abstractConvertJson = new CreateConvertJson();
        try {
            List<File> fileList = abstractConvertJson.createJavaClass(json, "hzm");
            fileList.forEach(file -> System.out.println(file.getName() + " " + file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

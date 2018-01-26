package com.cn.yc.json;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.io.File;
import java.util.List;

/**
 * Created by DT167 on 2018/1/26.
 */
public class jsonConvertProxy implements ConvertJson {
    private ConvertJson convertJson = null;

    public jsonConvertProxy(){
        this.convertJson = new jsonConvertProxy();
    }

    public jsonConvertProxy(ConvertJson _convertJson){
        this.convertJson = _convertJson;
    }

    @Override
    public List<File> createJavaClass(String json) {
        berfor();
        this.convertJson.createJavaClass(json);
        after();
        return null;
    }

    //预处理
    public void berfor(){

    }

    //善后处理
    public void after(){

    }
}

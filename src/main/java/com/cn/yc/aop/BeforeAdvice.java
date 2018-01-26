package com.cn.yc.aop;

/**
 * Created by DT167 on 2018/1/26.
 */
public class BeforeAdvice implements IAdvice {
    @Override
    public void exec() {
        System.out.println("我是前置通知，我被执行了！");
    }
}

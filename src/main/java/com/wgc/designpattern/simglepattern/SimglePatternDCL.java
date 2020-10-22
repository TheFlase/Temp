package com.wgc.designpattern.simglepattern;

/**
 * @Author wgc
 * @Description //DCL双重检查
 * @Date 2020/10/21
 **/
public class SimglePatternDCL {
    private static SimglePatternDCL instance;
    private SimglePatternDCL(){};
    public static SimglePatternDCL getInstance(){
        if(null != instance){
            synchronized (SimglePatternDCL.class){
                if(null != instance){
                    instance = new SimglePatternDCL();
                }
            }
        }
        return null;
    }
}

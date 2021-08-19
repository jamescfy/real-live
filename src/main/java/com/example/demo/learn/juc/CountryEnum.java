package com.example.demo.learn.juc;


import lombok.Getter;

/**
 * @Author cfy
 * @Date 2021-4-6 下午 2:51
 * @Version 1.0
 */
public enum CountryEnum {

    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"魏"),SIX(0,"韩");
    @Getter private Integer retCode;
    @Getter private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
    
    public static CountryEnum forEachContry(int index){
        CountryEnum[] myCountry = CountryEnum.values();
        for (CountryEnum countryEnum : myCountry){
            if(index == countryEnum.getRetCode()){
                return countryEnum;
            }
        }
        return null;
    }

}


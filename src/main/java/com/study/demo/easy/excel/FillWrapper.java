package com.study.demo.easy.excel;

import lombok.Data;

import java.util.Collection;

/**
 * @Author cfy
 * @Date 2021-5-20 上午 9:50
 * @Version 1.0
 */
@Data
public class FillWrapper {

    private String name;
    /**
     * Data that needs to be filled.
     */
    private Collection collectionData;

    public FillWrapper(Collection collectionData) {
        this.collectionData = collectionData;
    }

    public FillWrapper(String name, Collection collectionData) {
        this.name = name;
        this.collectionData = collectionData;
    }
}

package com.kapcb.ccc.service;

/**
 * <a>Title: IGeneratorService </a>
 * <a>Author: kapcb <a>
 * <a>Description: IGeneratorService <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/10/24 23:08
 * @since 1.0
 */
public interface IGeneratorService {

    /**
     * generate by table names
     *
     * @param tableNames table names
     * @return byte[]
     */
    byte[] generate(String[] tableNames);
}

package com.kapcb.ccc.domain.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <a>Title: ColumnPO </a>
 * <a>Author: kapcb <a>
 * <a>Description: ColumnPO <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/10/24 21:45
 * @since 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ColumnPO {

    /**
     * 列名
     */
    private String columnName;

    /**
     * 列名类型
     */
    private String dataType;

    /**
     * 列名备注
     */
    private String columnComment;

    private String columnKey;

    /**
     * 属性名称(第一个字母大写)，如：user_name => UserName
     */
    private String attrNameUpperCase;

    /**
     * 属性名称(第一个字母小写)，如：user_name => userName
     */
    private String attrNameLowerCase;

    /**
     * 属性类型
     */
    private String attrType;

    /**
     * auto_increment
     */
    private String extra;

}

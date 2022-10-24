package com.kapcb.ccc.domain.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * <a>Title: TablePO </a>
 * <a>Author: kapcb <a>
 * <a>Description: TablePO <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/10/24 21:51
 * @since 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TablePO {

    /**
     * 表的名称
     */
    private String tableName;

    /**
     * 表的备注
     */
    private String tableComment;

    /**
     * 表的主键
     */
    private ColumnPO primaryKey;

    /**
     * 表的列名(不包含主键)
     */
    private List<ColumnPO> columns;

    /**
     * 名(第一个字母大写)，如：sys_user => SysUser
     */
    private String classNameUpperCase;

    /**
     * 类名(第一个字母小写)，如：sys_user => sysUser
     */
    private String classNameLowerCase;

}

package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.po.ColumnPO;
import com.kapcb.ccc.domain.po.TablePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <a>Title: TableMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: TableMapper <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/10/24 22:03
 * @since 1.0
 */
@Mapper
public interface TableMapper {

    /**
     * found table information by table name
     * from information_schema
     *
     * @param tableName table name
     * @return {@link TablePO}
     */
    TablePO foundTableInformationByTableName(@Param("tableName") String tableName);

    /**
     * found table columns by table name
     *
     * @param tableName table name
     * @return {@link ColumnPO}
     */
    List<ColumnPO> foundTableColumnsByTableName(@Param("tableName") String tableName);
}

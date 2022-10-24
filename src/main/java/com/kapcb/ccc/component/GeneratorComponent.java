package com.kapcb.ccc.component;

import com.kapcb.ccc.domain.po.ColumnPO;
import com.kapcb.ccc.domain.po.TablePO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.zip.ZipOutputStream;

/**
 * <a>Title: GeneratorComponent </a>
 * <a>Author: kapcb <a>
 * <a>Description: GeneratorComponent <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/10/24 23:19
 * @since 1.0
 */
@Slf4j
@Component
public class GeneratorComponent implements InitializingBean {

    private static final String CONFIGURATION_PROPERTIES = "kapcb.properties";

    private Configuration configuration;

    public void generateSourceCodeFile(TablePO table, List<ColumnPO> columns, ZipOutputStream zipOutputStream) {
        boolean hasBigDecimal = false;

        String className = tableToJava(table.getTableName(), configuration.getString("tablePrefix"));

        // 表名转换成Java类名
        table.setClassNameLowerCase(className);
        table.setClassNameLowerCase(StringUtils.uncapitalize(className));

        for (ColumnPO column : columns) {

            // 列名转换成Java属性名
            String attrName = columnToJava(column.getColumnName());
            column.setAttrNameUpperCase(attrName);
            column.setAttrNameLowerCase(StringUtils.uncapitalize(attrName));

            // 列的数据类型，转换成Java类型
            String attrType = configuration.getString(column.getDataType(), "unknownType");
            column.setAttrType(attrType);

            if (!hasBigDecimal && "BigDecimal".equals(attrType)) {
                hasBigDecimal = true;
            }

            // 是否主键
            if ("PRI".equalsIgnoreCase(column.getColumnKey()) && Objects.isNull(table.getPrimaryKey())) {
                table.setPrimaryKey(column);
            }

        }

        table.setColumns(columns);

        // 没主键，则第一个字段为主键
        if (Objects.isNull(table.getPrimaryKey())) {
            table.setPrimaryKey(columns.get(0));
        }

        // 设置velocity资源加载器


    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 配置信息
        initialConfiguration();
    }

    private synchronized void initialConfiguration() {
        if (Objects.isNull(configuration)) {
            try {
                configuration = new PropertiesConfiguration(CONFIGURATION_PROPERTIES);
            } catch (ConfigurationException e) {
                throw new RuntimeException("获取配置文件失败，" + e.getMessage());
            }
        }
    }

    /**
     * convert column name to java attr name
     *
     * @param columnName columnName
     * @return java attr name
     */
    private static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    public static String tableToJava(String tableName, String tablePrefix) {
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.substring(tablePrefix.length());
        }
        return columnToJava(tableName);
    }

}

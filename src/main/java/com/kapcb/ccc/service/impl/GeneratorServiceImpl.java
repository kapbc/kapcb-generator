package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.component.GeneratorComponent;
import com.kapcb.ccc.domain.po.ColumnPO;
import com.kapcb.ccc.domain.po.TablePO;
import com.kapcb.ccc.mapper.TableMapper;
import com.kapcb.ccc.service.IGeneratorService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipOutputStream;

/**
 * <a>Title: GeneratorServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: GeneratorServiceImpl <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/10/24 23:08
 * @since 1.0
 */
@Component
@RequiredArgsConstructor
public class GeneratorServiceImpl implements IGeneratorService {

    private final TableMapper tableMapper;

    private final GeneratorComponent generatorComponent;

    @Override
    public byte[] generate(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream)) {
            for (String tableName : tableNames) {
                TablePO table = tableMapper.foundTableInformationByTableName(tableName);
                if (Objects.isNull(table)) {
                    continue;
                }
                List<ColumnPO> columns = tableMapper.foundTableColumnsByTableName(tableName);
                if (CollectionUtils.isEmpty(columns)) {
                    continue;
                }
                generatorComponent.generateSourceCodeFile(table, columns, zipOutputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new byte[0];
    }
}

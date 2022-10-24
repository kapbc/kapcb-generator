package com.kapcb.ccc;

import com.kapcb.ccc.properties.GeneratorFileProperties;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * <a>Title: KapcbGeneratorApplication </a>
 * <a>Author: cb <a>
 * <a>Description: KapcbGeneratorApplication <a>
 *
 * @author cb
 * @version 1.0
 * @date 2022/7/18 17:57
 * @since 1.0
 */
@EnableConfigurationProperties(value = GeneratorFileProperties.class)
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class KapcbGeneratorApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(KapcbGeneratorApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}

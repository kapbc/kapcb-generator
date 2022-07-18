package com.kapcb.ccc;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <a>Title: MyBatisGeneratorApplication </a>
 * <a>Author: cb <a>
 * <a>Description: MyBatisGeneratorApplication <a>
 *
 * @author cb
 * @version 1.0
 * @date 2022/7/18 17:57
 * @since 1.0
 */
@SpringBootApplication
public class MyBatisGeneratorApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MyBatisGeneratorApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}

package com.javabom.definitiveguide.config;

import com.javabom.service.config.BatchServiceConfig;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableBatchProcessing // 애플리케이션 내에서 한 번만 적용됨
@ComponentScan(value = {
        "com.javabom.definitiveguide.chap2",
        "com.javabom.definitiveguide.chap13",
        "com.javabom.definitiveguide.chap4",
        "com.javabom.definitiveguide.chap5",
        "com.javabom.definitiveguide.chap6",
        "com.javabom.definitiveguide.chap7"
})
@Import(value = {
        BatchServiceConfig.class,
        CustomDataSourceConfig.class
})
public class DefiniteBatchConfig {
}

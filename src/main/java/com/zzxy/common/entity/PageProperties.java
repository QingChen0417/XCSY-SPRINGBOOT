package com.zzxy.common.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//对象的创建交给容器管理，加了该注解标识这个类是配置类
@Configuration
@ConfigurationProperties(prefix = "com.zzxy.page")
@Data
public class PageProperties {
	private Integer pageSize;

}

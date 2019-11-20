package com.luzhoumin.mblog.management.config;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class})
public class MybatisConfiguration extends MybatisAutoConfiguration {

	private static Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);

	@Resource(name = "masterDataSource")
	private DataSource masterDataSource;
	@Resource(name = "slaveDataSource")
	private DataSource slaveDataSource;

	public MybatisConfiguration(MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider, ObjectProvider<TypeHandler[]> typeHandlersProvider, ObjectProvider<LanguageDriver[]> languageDriversProvider, ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider, ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
		super(properties, interceptorsProvider, typeHandlersProvider, languageDriversProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryTest(ReadWriteSplitRoutingDataSource dataSource) throws Exception {
		logger.info("-------------------- 重载父类 sqlSessionFactory init---------------------");
		return super.sqlSessionFactory(dataSource);
	}

	@Bean
	public ReadWriteSplitRoutingDataSource roundRobinDataSouceProxy() {
		ReadWriteSplitRoutingDataSource proxy = new ReadWriteSplitRoutingDataSource();
		Map<Object, Object> targetDataResources = new HashMap<>();
		targetDataResources.put(ReadWriteSplitRoutingDataSource.DbType.MASTER, masterDataSource);
		targetDataResources.put(ReadWriteSplitRoutingDataSource.DbType.SLAVE, slaveDataSource);
		proxy.setDefaultTargetDataSource(slaveDataSource);
		proxy.setTargetDataSources(targetDataResources);
		proxy.afterPropertiesSet();
		return proxy;
	}
}

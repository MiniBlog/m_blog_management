package com.luzhoumin.mblog.management.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource {

	private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<>();

	private static DbType getDbType() {
		//默认设定从库连接
		return contextHolder.get() == null ? DbType.SLAVE : contextHolder.get();
	}

	public static void setDbType(DbType dbType) {
		if (dbType == null)
			throw new NullPointerException();
		contextHolder.set(dbType);
	}

	public static void clearDbType() {
		contextHolder.remove();
	}

	@Override
	protected Object determineCurrentLookupKey() {
		return getDbType();
	}

	public enum DbType {
		MASTER, SLAVE
	}
}

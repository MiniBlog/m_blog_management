package com.luzhoumin.mblog.management.interceptor;


import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.config.ReadWriteSplitRoutingDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DBWriteConnectionInterceptor implements Ordered {

	private static Logger logger = LoggerFactory.getLogger(DBWriteConnectionInterceptor.class);

	@Around("@annotation(dbWriteConnection)")
	public Object proceed(ProceedingJoinPoint proceedingJoinPoint, DBWriteConnection dbWriteConnection) throws Throwable {
		Object result = null;
		try {
			logger.info("*****设定数据库连接为主库连接，进行写操作*****");
			ReadWriteSplitRoutingDataSource.setDbType(ReadWriteSplitRoutingDataSource.DbType.MASTER);
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("DBWriteConnectionInterceptor,dbWriteConnection", e);
		} finally {
			ReadWriteSplitRoutingDataSource.setDbType(ReadWriteSplitRoutingDataSource.DbType.SLAVE);
			logger.info("*****恢复数据库连接为默认连接(从库)*****");
		}

		return result;
	}

	@Override
	public int getOrder() {
		return 0;
	}
}

package com.github.support.cbb.flayway;

public interface FlywayMigration
{
	/**
	 * 初始化Flyway metadata 
	 */
	void  init();
	
	/**
	 * 执行Flyway 升级操
	 */
	void migrate();
	
	/**
	 * 校验Flyway 数据正确性
	 */
	void validate();
	
}

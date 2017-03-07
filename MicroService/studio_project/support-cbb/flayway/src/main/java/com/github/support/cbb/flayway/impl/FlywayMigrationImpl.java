package com.github.support.cbb.flayway.impl;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import com.github.support.cbb.flayway.FlywayMigration;

public class FlywayMigrationImpl implements FlywayMigration
{

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	public void migrate()
	{
		Flyway flyway = new Flyway();
		flyway.setBaselineDescription("Init");
		flyway.setDataSource(dataSource);

		// 设置接受flyway进行版本管理的多个数据库
		flyway.setSchemas("flayway_manager");

		// 设置存放flyway metadata数据的表名
		flyway.setTable("t_flayway");

		// 设置flyway扫描sql升级脚本、java升级脚本的目录路径或包路径
		// flyway.setLocations("db/migrations",
		// "com.github.support.cbb.flayway.FlywayMigration");
		flyway.setLocations("db/migrations");

		flyway.setEncoding("UTF-8"); // 设置sql脚本文件的编码

		// flyway.setValidationMode(ValidationMode.ALL); //
		// 设置执行migrate操作之前的validation行为
		// flyway.setValidationErrorMode(ValidationErrorMode.FAIL); //
		// 设置当validation失败时的系统行为

		flyway.migrate();

		System.err.println("FlywayMigrationImpl.migrate- done");
	}

	@Override
	public void init()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void validate()
	{
		// TODO Auto-generated method stub

	}

}

package com.rick.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * -------------------------------------------
 * Title : MybatisGeneratorCreater 
 * Description : 自动生成pojo、mapper
 * Create on : 2017年8月2日 上午10:01:39
 * Copyright (C) strongunion
 * @author RICK
 * @版本号: V1.0
 * -------------------------------------------
 */
public class MybatisGeneratorCreater {
	public static void main(String[] args) throws InvalidConfigurationException, IOException, XMLParserException, SQLException, InterruptedException {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(MybatisGeneratorCreater.class.getResourceAsStream("/generatorConfig.xml"));
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		System.out.println("=============entity、mapper create success================");
	}
}

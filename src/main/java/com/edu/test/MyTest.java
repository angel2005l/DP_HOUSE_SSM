package com.edu.test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.edu.util.MD5Util;

public class MyTest {
	public static void main(String[] args) {
		try {
			System.out.println("startgenerator ...");
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			String path = java.net.URLDecoder.decode(
					MyTest.class.getResource("/generatorConfig.xml").getFile(),
					"utf-8");
			File configFile = new File(path);
			ConfigurationParser cp = new ConfigurationParser(warnings);

			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
					callback, warnings);
			myBatisGenerator.generate(null);
			System.out.println("endgenerator!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void text2(){
		String num = "D10254400002";
		String substring = num.substring(num.length()-5);
		int parseInt = Integer.parseInt(substring);
		System.err.println(substring+parseInt);
	}

	@Test
	public void test3(){
		String salt = MD5Util.getRandomSalt();
		System.err.println(salt);
		String md5EncryptPass = MD5Util.getMD5EncryptPass("sa", salt.getBytes());
		System.err.println(md5EncryptPass);
	}
	@Test
	public void test4(){
		String str = "a";
		//left
		String substring2 = str.substring(str.length()-1);
		System.err.println(1+substring2);
		//right
		String substring3 = str.substring(0, str.length()-2);
		System.err.println(2+substring3);
		//center
		String substring = str.substring(0, str.length()-2);
		System.err.println(3+substring);
		
	}
}

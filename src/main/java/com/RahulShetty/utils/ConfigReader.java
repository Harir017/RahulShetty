package com.RahulShetty.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

	public static Properties initProperties() {
		prop = new Properties();

		try (FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\\\src\\\\test\\\\resources\\\\config.properties")) {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to Load Config.Properties File");
		}
		return prop;
	}
}

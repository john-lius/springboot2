package com.digihealth.common.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

public class PropertiesLoader {

	private static ResourceLoader resourceLoader = new DefaultResourceLoader();

	private final Properties properties;

	public PropertiesLoader(String... resourcesPaths) {
		properties = loadProperties(resourcesPaths);
	}

	public Properties getProperties() {
		return properties;
	}

	/**
	 * 取锟斤拷Property锟斤拷锟斤拷锟斤拷System锟斤拷Property锟斤拷锟斤拷,取锟斤拷锟斤拷锟斤拷锟截匡拷锟街凤拷.
	 */
	private String getValue(String key) {
		String systemProperty = System.getProperty(key);
		if (systemProperty != null) {
			return systemProperty;
		}
		if (properties.containsKey(key)) {
	        return properties.getProperty(key);
	    }
	    return "";
	}

	/**
	 * 取锟斤拷String锟斤拷锟酵碉拷Property锟斤拷锟斤拷锟斤拷System锟斤拷Property锟斤拷锟斤拷,锟斤拷锟轿狽ull锟斤拷锟阶筹拷锟届常.
	 */
	public String getProperty(String key) {
		String value = getValue(key);
		if (value == null) {
			throw new NoSuchElementException();
		}
		return value;
	}

	/**
	 * 取锟斤拷String锟斤拷锟酵碉拷Property锟斤拷锟斤拷锟斤拷System锟斤拷Property锟斤拷锟斤拷.锟斤拷锟轿狽ull锟津返伙拷Default值.
	 */
	public String getProperty(String key, String defaultValue) {
		String value = getValue(key);
		return value != null ? value : defaultValue;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟侥硷拷, 锟侥硷拷路锟斤拷使锟斤拷Spring Resource锟斤拷式.
	 */
	private Properties loadProperties(String... resourcesPaths) {
		Properties props = new Properties();
		for (String location : resourcesPaths) {
			InputStream is = null;
			try {
//				Resource resource = resourceLoader.getResource(location);  // 锟斤拷取锟斤拷目路锟斤拷锟铰碉拷锟斤拷锟斤拷锟侥硷拷;
				BufferedReader bufferedReader;
				bufferedReader = new BufferedReader(new FileReader(location));  // 锟斤拷取锟斤拷锟铰凤拷锟斤拷碌锟斤拷锟斤拷锟斤拷募锟�
//				is = resource.getInputStream();
//				props.load(is);
				props.load(bufferedReader);
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			} finally {
				IOUtils.closeQuietly(is);
			}
		}
		return props;
	}
}

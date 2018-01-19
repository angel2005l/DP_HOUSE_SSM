package com.edu.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	
	@SuppressWarnings("finally")
	public static <T> String list2Json(List<T>  ptcds){
		if ( ptcds == null ||  ptcds.isEmpty()) {
			return "传入的参数有误";
		}
		ObjectMapper mapper = new ObjectMapper();
		String retStr = null;
		try {
			retStr = mapper.writeValueAsString( ptcds);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return retStr;
		}
	}
	
	@SuppressWarnings("finally")
	public static String obj2Json(Object obj) {
		if (obj == null) {
			return "传入的参数有误.";
		}
		String retStr = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			retStr = mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			return retStr;
		}
	}

	@SuppressWarnings("finally")
	public static String map2Json(Map<String, Object> map) {
		if (map == null || map.isEmpty()) {
			return "传入的参数有误";
		}
		String retStr = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			retStr = mapper.writeValueAsString(map);
		} catch (JsonGenerationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			return retStr;
		}
	}

}

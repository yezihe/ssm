package com.yezi.util;

import com.yezi.pojo.Dept;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonDeptValueProcessor implements JsonValueProcessor {

	@Override
	public Object processArrayValue(Object value, JsonConfig config) {
		
		return process(value);
	}

	

	@Override
	public Object processObjectValue(String key, Object value, JsonConfig config) {
		
		return  process(value);
	}
	private Object process(Object value) {
		if(value instanceof Dept){
			return ((Dept) value).getDname();
		}
		return value==null ? "" :value.toString();
		
	}

}

package com.digihealth.common.entity;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.digihealth.common.config.Global;

/**
 * 统一返回消息
 * @author admin
 *
 */
public class ResponseValue {
    //返回结果码
    private String code;

    //返回结果描述信息
    private String msg;
    
    private Map<String, Object> resultObj = new HashMap<String, Object>();
    

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Map<String, Object> getResultObj() {
		return resultObj;
	}

	public void setResultObj(Map<String, Object> resultObj) {
		this.resultObj = resultObj;
	}

    public ResponseValue() {
    	setCode("0");
    	setMsg(com.digihealth.common.config.Global.getRetMsg(getCode()));
    }
    
    public ResponseValue(String retCode) {
    	setCode(retCode);
    	setMsg(Global.getRetMsg(retCode));
    }
    
    public ResponseValue(String retCode, String retMsg) {
    	setCode(retCode);
    	setMsg(retMsg);
    }
    
    public void put(String key, Object value) {
    	resultObj.put(key, value);
    }

    public String getJsonStr() {
    	resultObj.put("code", getCode());
    	resultObj.put("msg", getMsg());
    	return JSON.toJSONString(resultObj);
    }
    
}

package com.handsome.jay.common;

/**
* 
* @ClassName: RequestStatus 
* @Description: 请求状态枚举类
* @author: xz
* @date: 2022年3月17日 下午8:15:26 
*
*/
public enum ReturnCode {
	SUCCESS(1, "成功"), FAIL(0, "失败");
    //请求状态
	private int code;
	//信息
	private String message;

	private ReturnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

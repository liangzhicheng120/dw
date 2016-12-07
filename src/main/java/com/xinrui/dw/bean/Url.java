package com.xinrui.dw.bean;

import com.xinrui.dw.util.UrlStatEnum;

/**
 * 
 * @ClassName: Url
 * @Description: 封装地址信息
 * @author liangzhicheng
 * @date 2016年12月7日 上午9:40:14
 *
 */
public class Url
{
	private UrlStatEnum url; // 要跳转的地址
	private int code; // 状态码
	private String message; // 跳转信息

	public Url(UrlStatEnum url, int code, String message)
	{
		super();
		this.url = url;
		this.code = code;
		this.message = message;
	}

	public Url(UrlStatEnum url, int code)
	{
		super();
		this.url = url;
		this.code = code;
	}

	public UrlStatEnum getUrl()
	{
		return url;
	}

	public void setUrl(UrlStatEnum url)
	{
		this.url = url;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

}

package com.xinrui.dw.bean;

/**
 * 
 * @ClassName: Url
 * @Description: ��װ��ַ��Ϣ
 * @author liangzhicheng
 * @date 2016��12��7�� ����9:40:14
 *
 */
public class Url
{
	private String url; // Ҫ��ת�ĵ�ַ
	private int code; // ״̬��
	private String message; // ��ת��Ϣ

	public Url(String url, int code, String message)
	{
		super();
		this.url = url;
		this.code = code;
		this.message = message;
	}

	public Url(int code, String message)
	{
		super();
		this.code = code;
		this.message = message;
	}

	public Url(String url, int code)
	{
		super();
		this.url = url;
		this.code = code;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
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

package com.xinrui.dw.util;

/**
 * 
 * @ClassName: UrlStatEnum
 * @Description: ���� RSS(Really Simple Syndication) ���ӵ�ö������
 * @author liangzhicheng
 * @date 2016��12��7�� ����9:50:25
 *
 */
public enum UrlStatEnum
{
	// ��ҳ��ַ
	INDEX("/demoweb/index"),

	// ɾ����Ϣ��ַ
	DELETEBYFILMID("/demoweb/index/deleteByFilmId"),

	// ������Ϣ��ַ
	UPDATEBYFILMID("/demoweb/index/updateByFilmId");

	// ö�ٶ���� RSS ��ַ������
	private String rss_url;

	// ö�ٶ����캯��
	private UrlStatEnum(String rss)
	{
		this.rss_url = rss;
	}

	// ö�ٶ����ȡ RSS ��ַ�ķ���
	public String getRssURL()
	{
		return this.rss_url;
	}
}

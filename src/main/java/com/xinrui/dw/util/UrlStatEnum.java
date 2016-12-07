package com.xinrui.dw.util;

/**
 * 
 * @ClassName: UrlStatEnum
 * @Description: 定义 RSS(Really Simple Syndication) 种子的枚举类型
 * @author liangzhicheng
 * @date 2016年12月7日 上午9:50:25
 *
 */
public enum UrlStatEnum
{
	// 首页地址
	INDEX("/demoweb/index"),

	// 删除信息地址
	DELETEBYFILMID("/demoweb/index/deleteByFilmId"),

	// 更新信息地址
	UPDATEBYFILMID("/demoweb/index/updateByFilmId");

	// 枚举对象的 RSS 地址的属性
	private String rss_url;

	// 枚举对象构造函数
	private UrlStatEnum(String rss)
	{
		this.rss_url = rss;
	}

	// 枚举对象获取 RSS 地址的方法
	public String getRssURL()
	{
		return this.rss_url;
	}
}

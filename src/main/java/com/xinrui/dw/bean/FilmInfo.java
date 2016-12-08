package com.xinrui.dw.bean;

/**
 * 
 * @ClassName: FileInfo
 * @Description: 影视剧信息
 * @author liangzhicheng
 * @date 2016年12月5日 上午10:54:35
 *
 */
public class FilmInfo
{
	private int filmId; // 影视剧id
	private String filmName; // 影视剧名称
	private String direct; // 导演
	private String protagonist; // 主演
	private String type; // 影视剧类型
	private String district; // 地区
	private String language; // 语言
	private Integer clustertype;// 聚类类别

	public Integer getClustertype()
	{
		return clustertype;
	}

	public void setClustertype(Integer clustertype)
	{
		this.clustertype = clustertype;
	}

	public int getFilmId()
	{
		return filmId;
	}

	public void setFilmId(int filmId)
	{
		this.filmId = filmId;
	}

	public String getFilmName()
	{
		return filmName;
	}

	public void setFilmName(String filmName)
	{
		this.filmName = filmName;
	}

	public String getDirect()
	{
		return direct;
	}

	public void setDirect(String direct)
	{
		this.direct = direct;
	}

	public String getProtagonist()
	{
		return protagonist;
	}

	public void setProtagonist(String protagonist)
	{
		this.protagonist = protagonist;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getDistrict()
	{
		return district;
	}

	public void setDistrict(String district)
	{
		this.district = district;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	@Override
	public String toString()
	{
		return filmId + "," + filmName + "," + direct + "," + protagonist + "," + type + "," + district + ","
				+ language;
	}

}

package com.xinrui.dw.bean;

/**
 * 
 * @ClassName: FileInfo
 * @Description: Ӱ�Ӿ���Ϣ
 * @author liangzhicheng
 * @date 2016��12��5�� ����10:54:35
 *
 */
public class FilmInfo
{
	private int filmId; // Ӱ�Ӿ�id
	private String filmName; // Ӱ�Ӿ�����
	private String direct; // ����
	private String protagonist; // ����
	private String type; // Ӱ�Ӿ�����
	private String district; // ����
	private String language; // ����
	private Integer clustertype;// �������

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

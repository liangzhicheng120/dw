package com.xinrui.dw.service;

import java.util.List;

import com.xinrui.dw.bean.FilmInfo;
import com.xinrui.dw.bean.PageParam;

/**
 * 
 * @ClassName: IFilmInfoService
 * @Description: Ӱ�Ӿ���Ϣ��ѯ������
 * @author liangzhicheng
 * @date 2016��12��5�� ����11:52:32
 *
 */
public interface IFilmInfoService
{
	// ��ҳ��ѯ����Ӱ����Ϣ
	public List<FilmInfo> queryAllFilmInfoByPage(PageParam pageParam);

	// ����Ӱ�Ӿ�idɾ����Ϣ
	public boolean deleteByFilmId(String filmId);

	// ����Ӱ�Ӿ�
	public boolean insertFilmInfo(String filmName, String direct, String protagonist, String type, String district,
			String language);

	// ��ѯ������Ϣ
	public List<FilmInfo> queryAllFilmInfo();
}

package com.xinrui.dw.service;

import java.util.List;

import com.xinrui.dw.bean.FilmInfo;

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
	// ��ѯ����Ӱ����Ϣ
	public List<FilmInfo> queryAllFilmInfo();
}

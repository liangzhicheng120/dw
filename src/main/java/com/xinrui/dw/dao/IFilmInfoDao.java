package com.xinrui.dw.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xinrui.dw.bean.FilmInfo;

/**
 * 
 * @ClassName: IFilmInfoDao
 * @Description: Ӱ�Ӿ����ݿ�ӿ�
 * @author liangzhicheng
 * @date 2016��12��5�� ����11:50:52
 *
 */
@Repository
public interface IFilmInfoDao
{
	// ��ҳ��ѯ����Ӱ�Ӿ���Ϣ
	public List<FilmInfo> queryAllFilmInfoByPage(Map<String, Object> parameter);

}

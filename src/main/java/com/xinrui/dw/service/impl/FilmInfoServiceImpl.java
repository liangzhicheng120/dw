package com.xinrui.dw.service.impl;

import java.util.List;

import javax.annotation.Resource;






import org.springframework.stereotype.Service;

import com.xinrui.dw.bean.FilmInfo;
import com.xinrui.dw.dao.IFilmInfoDao;
import com.xinrui.dw.service.IFilmInfoService;

/**
 * 
 * @ClassName: FilmInfoServiceImpl
 * @Description: Ӱ�Ӿ����ʵ����
 * @author liangzhicheng
 * @date 2016��12��5�� ����11:55:50
 *
 */
@Service
public class FilmInfoServiceImpl implements IFilmInfoService
{
	@Resource
	IFilmInfoDao filmInfoDao;

	public List<FilmInfo> queryAllFilmInfo()
	{
		return this.filmInfoDao.queryAllFilmInfo();
	}

}

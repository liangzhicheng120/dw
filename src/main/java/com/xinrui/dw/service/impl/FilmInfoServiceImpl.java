package com.xinrui.dw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinrui.dw.bean.FilmInfo;
import com.xinrui.dw.dao.IFilmInfoDao;
import com.xinrui.dw.service.IFilmInfoService;
import com.xinrui.dw.bean.PageParam;

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

	public List<FilmInfo> queryAllFilmInfoByPage(PageParam pageParam)
	{
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("pageParam", pageParam);
		return this.filmInfoDao.queryAllFilmInfoByPage(parameter);
	}

}

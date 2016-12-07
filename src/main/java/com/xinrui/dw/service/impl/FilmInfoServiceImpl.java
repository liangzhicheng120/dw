package com.xinrui.dw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.python.modules.newmodule;
import org.springframework.stereotype.Service;

import com.xinrui.dw.bean.FilmInfo;
import com.xinrui.dw.dao.IFilmInfoDao;
import com.xinrui.dw.python.Cluster;
import com.xinrui.dw.service.IFilmInfoService;
import com.xinrui.dw.bean.PageParam;

/**
 * 
 * @ClassName: FilmInfoServiceImpl
 * @Description: 影视剧服务实现类
 * @author liangzhicheng
 * @date 2016年12月5日 上午11:55:50
 *
 */
@Service
public class FilmInfoServiceImpl implements IFilmInfoService
{
	@Resource
	IFilmInfoDao filmInfoDao;

	// 分页查询影视剧信息
	public List<FilmInfo> queryAllFilmInfoByPage(PageParam pageParam)
	{

		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("pageParam", pageParam);
		List<FilmInfo> filmInfos = this.filmInfoDao.queryAllFilmInfoByPage(parameter);
		// Boolean isCluster = new Cluster().Execution("abc");
		return filmInfos;
	}

	// 根据影视剧id删除信息
	public boolean deleteByFilmId(String filmId)
	{
		if (StringUtils.isNotEmpty(filmId))
		{
			FilmInfo filmInfo = new FilmInfo();
			filmInfo.setFilmId(Integer.valueOf(filmId));
			int row = this.filmInfoDao.deleteByFilmId(filmInfo);
			// 删除成功
			if (row > 0)
			{
				return true;
			}
		}
		// 删除失败
		return false;
	}

	// 增加影视剧
	public boolean insertFilmInfo(String filmName, String direct, String protagonist, String type, String district,
			String language)
	{
		FilmInfo filmInfo = new FilmInfo();
		filmInfo.setDirect(direct);
		filmInfo.setDistrict(district);
		filmInfo.setFilmName(filmName);
		filmInfo.setLanguage(language);
		filmInfo.setProtagonist(protagonist);
		filmInfo.setType(type);

		if (filmInfo != null)
		{
			int row = this.filmInfoDao.insertFilmInfo(filmInfo);
			if (row > 0)
			{
				return true;
			}

		}
		return false;
	}
}

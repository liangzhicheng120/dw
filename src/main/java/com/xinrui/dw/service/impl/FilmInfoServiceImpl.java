package com.xinrui.dw.service.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.python.modules.newmodule;
import org.springframework.stereotype.Service;

import com.csvreader.CsvWriter;
import com.xinrui.dw.bean.FilmInfo;
import com.xinrui.dw.dao.IFilmInfoDao;
import com.xinrui.dw.python.Cluster;
import com.xinrui.dw.service.IFilmInfoService;
import com.xinrui.dw.util.Constant;
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
	public List<FilmInfo> queryAllFilmInfoByPage(PageParam pageParam, String clustertype)
	{
		Map<String, Object> parameter = new HashMap<String, Object>();

		FilmInfo filmInfo = new FilmInfo();
		if (StringUtils.isNotEmpty(clustertype))
		{
			filmInfo.setClustertype(Integer.valueOf(clustertype));
		}
		parameter.put("filmInfo", filmInfo);
		parameter.put("pageParam", pageParam);
		List<FilmInfo> filmInfos = this.filmInfoDao.queryAllFilmInfoByPage(parameter);
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

	// 查询所有信息
	public List<FilmInfo> queryAllFilmInfo()
	{
		return null;
	}

	// 启动聚类脚本
	public boolean startCluster() throws IOException
	{
		List<FilmInfo> filmInfos = filmInfoDao.queryAllFilmInfo();
		CsvWriter wr = new CsvWriter(Constant.CSVFILEPATH, ',', Charset.forName("GBK"));
		// 导出所有数据
		for (FilmInfo filmInfo : filmInfos)
		{
			wr.writeComment(filmInfo.toString());
		}
		wr.close();
		// 删除所有数据
		int row = this.filmInfoDao.deleteAllClusterTab();
		if (row == 0)
		{ // 执行聚类
			return new Cluster().Execution("");
		}
		return false;
	}
}

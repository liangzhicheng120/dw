package com.xinrui.dw.service;

import java.util.List;

import com.xinrui.dw.bean.FilmInfo;
import com.xinrui.dw.bean.PageParam;

/**
 * 
 * @ClassName: IFilmInfoService
 * @Description: 影视剧信息查询服务类
 * @author liangzhicheng
 * @date 2016年12月5日 上午11:52:32
 *
 */
public interface IFilmInfoService
{
	// 分页查询所有影视信息
	public List<FilmInfo> queryAllFilmInfoByPage(PageParam pageParam);

	// 根据影视剧id删除信息
	public boolean deleteByFilmId(String filmId);

	// 增加影视剧
	public boolean insertFilmInfo(String filmName, String direct, String protagonist, String type, String district,
			String language);

	// 查询所有信息
	public List<FilmInfo> queryAllFilmInfo();
}

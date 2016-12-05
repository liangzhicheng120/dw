package com.xinrui.dw.service;

import java.util.List;

import com.xinrui.dw.bean.FilmInfo;

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
	// 查询所有影视信息
	public List<FilmInfo> queryAllFilmInfo();
}

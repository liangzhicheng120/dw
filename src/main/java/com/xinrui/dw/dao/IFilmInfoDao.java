package com.xinrui.dw.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xinrui.dw.bean.FilmInfo;

/**
 * 
 * @ClassName: IFilmInfoDao
 * @Description: 影视剧数据库接口
 * @author liangzhicheng
 * @date 2016年12月5日 上午11:50:52
 *
 */
@Repository
public interface IFilmInfoDao
{
	// 查询所有影视剧信息
	public List<FilmInfo> queryAllFilmInfo();

}

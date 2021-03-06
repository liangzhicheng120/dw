package com.xinrui.dw.service;

import java.io.IOException;
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
	public List<FilmInfo> queryAllFilmInfoByPage(PageParam pageParam, String clustertype);

	// 根据影视剧id删除信息
	public boolean deleteByFilmId(String filmId);

	// 增加影视剧
	public boolean insertFilmInfo(String filmName, String direct, String protagonist, String type, String district,
			String language);

	// 启动聚类脚本
	public boolean startCluster() throws IOException;

	// 通过一组id删除数据
	public boolean deleteInfoByIds(String ids);
}

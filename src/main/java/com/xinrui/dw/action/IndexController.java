package com.xinrui.dw.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinrui.dw.bean.FilmInfo;
import com.xinrui.dw.bean.PageParam;
import com.xinrui.dw.bean.Url;
import com.xinrui.dw.dto.ExecutionResult;
import com.xinrui.dw.service.impl.FilmInfoServiceImpl;
import com.xinrui.dw.util.PageparmUtil;
import com.xinrui.dw.util.UrlUtil;

/**
 * 
 * @ClassName: Indexcontroller
 * @Description: 首页控制类 500:删除失败，501:插入失败,502：聚类失败
 * @author liangzhicheng
 * @date 2016年12月5日 上午11:36:47
 *
 */
@Controller
public class IndexController
{

	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	FilmInfoServiceImpl filmService;

	@RequestMapping(value = "/index")
	public ModelAndView index(String currentPage)
	{
		ModelAndView mav = new ModelAndView("frame/index");
		// 设置并过滤页数
		PageParam page = PageparmUtil.setCurrentPage(currentPage);
		// 查询数据
		List<FilmInfo> infos = filmService.queryAllFilmInfoByPage(page);
		// 向页面返回数据
		mav.addObject("infos", infos);
		mav.addObject("page", page);
		mav.addObject("currentPage", page.getCurrentPage());
		return mav;
	}

	@RequestMapping(value = "/index/deleteByFilmId", method = RequestMethod.POST, produces =
	{ "application/json;charset=UTF-8" })
	@ResponseBody
	public ExecutionResult<Url> deleteByFilmId(String filmId)
	{
		boolean isDelete = filmService.deleteByFilmId(filmId);
		Url url = null;
		// 删除成功
		if (isDelete)
		{
			url = new Url(UrlUtil.CLUSTERTAB, 200);
			return new ExecutionResult<Url>(true, url);
		} else
		// 删除失败
		{
			url = new Url(500, UrlUtil.DELETE_FAIL);
			return new ExecutionResult<Url>(false, url);
		}
	}

	@RequestMapping(value = "/index/clusterTab")
	public ModelAndView clusterTab(String currentPage)
	{
		ModelAndView mav = new ModelAndView("table/clusterTab");
		// 设置并过滤页数
		PageParam page = PageparmUtil.setCurrentPage(currentPage);
		// 查询数据
		List<FilmInfo> infos = filmService.queryAllFilmInfoByPage(page);
		// 向页面返回数据
		mav.addObject("infos", infos);
		mav.addObject("page", page);
		mav.addObject("currentPage", page.getCurrentPage());
		return mav;
	}

	@RequestMapping(value = "/index/insertTab", method = RequestMethod.POST, produces =
	{ "application/json;charset=UTF-8" })
	@ResponseBody
	public ExecutionResult<Url> insertTab(String filmName, String direct, String protagonist, String type,
			String district, String language)
	{
		boolean isInsert = filmService.insertFilmInfo(filmName, direct, protagonist, type, district, language);
		Url url = null;
		// 插入成功
		if (isInsert)
		{
			url = new Url(UrlUtil.CLUSTERTAB, 200);
			return new ExecutionResult<Url>(true, url);
		} else
		// 插入失败
		{
			url = new Url(501, UrlUtil.INSERT_FAIL);
			return new ExecutionResult<Url>(false, url);
		}
	}

	@RequestMapping(value = "/index/startCluster", method = RequestMethod.POST, produces =
	{ "application/json;charset=UTF-8" })
	@ResponseBody
	public ExecutionResult<Url> startCluster() throws IOException
	{
		boolean isSuccess = filmService.startCluster();
		Url url = null;
		if (isSuccess)
		{
			url = new Url(UrlUtil.CLUSTERTAB, 200);
			return new ExecutionResult<Url>(true, url);
		} else
		{
			url = new Url(502, UrlUtil.INSERT_FAIL);
			return new ExecutionResult<Url>(false, url);
		}
	}
}

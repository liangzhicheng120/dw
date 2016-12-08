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
 * @Description: ��ҳ������ 500:ɾ��ʧ�ܣ�501:����ʧ��,502������ʧ��
 * @author liangzhicheng
 * @date 2016��12��5�� ����11:36:47
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
		// ���ò�����ҳ��
		PageParam page = PageparmUtil.setCurrentPage(currentPage);
		// ��ѯ����
		List<FilmInfo> infos = filmService.queryAllFilmInfoByPage(page);
		// ��ҳ�淵������
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
		// ɾ���ɹ�
		if (isDelete)
		{
			url = new Url(UrlUtil.CLUSTERTAB, 200);
			return new ExecutionResult<Url>(true, url);
		} else
		// ɾ��ʧ��
		{
			url = new Url(500, UrlUtil.DELETE_FAIL);
			return new ExecutionResult<Url>(false, url);
		}
	}

	@RequestMapping(value = "/index/clusterTab")
	public ModelAndView clusterTab(String currentPage)
	{
		ModelAndView mav = new ModelAndView("table/clusterTab");
		// ���ò�����ҳ��
		PageParam page = PageparmUtil.setCurrentPage(currentPage);
		// ��ѯ����
		List<FilmInfo> infos = filmService.queryAllFilmInfoByPage(page);
		// ��ҳ�淵������
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
		// ����ɹ�
		if (isInsert)
		{
			url = new Url(UrlUtil.CLUSTERTAB, 200);
			return new ExecutionResult<Url>(true, url);
		} else
		// ����ʧ��
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

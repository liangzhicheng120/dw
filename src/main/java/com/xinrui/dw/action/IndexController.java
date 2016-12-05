package com.xinrui.dw.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xinrui.dw.bean.FilmInfo;
import com.xinrui.dw.service.impl.FilmInfoServiceImpl;

/**
 * 
 * @ClassName: Indexcontroller
 * @Description: 首页控制类
 * @author liangzhicheng
 * @date 2016年12月5日 上午11:36:47
 *
 */
@Controller
public class IndexController
{

	public static Logger logger = Logger.getLogger(IndexController.class);

	@Resource
	FilmInfoServiceImpl filmService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index()
	{
		ModelAndView mav = new ModelAndView("frame/index");
		List<FilmInfo> infos = filmService.queryAllFilmInfo();
		for (FilmInfo filmInfo : infos)
		{
			logger.info(filmInfo.toString());
		}
		mav.addObject("infos", infos);
		
		return mav;
	}

}

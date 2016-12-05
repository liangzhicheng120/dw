package com.xinrui.dw.action;

import java.util.List;

import javax.annotation.Resource;

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
	@Resource
	FilmInfoServiceImpl filmService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index()
	{
		ModelAndView mav = new ModelAndView("frame/index");
		List<FilmInfo> infos = filmService.queryAllFilmInfo();
		for (FilmInfo filmInfo : infos)
		{
			System.out.println(filmInfo.toString());
		}
		return mav;
	}

}

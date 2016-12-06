package com.xinrui.dw.action;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xinrui.dw.bean.FilmInfo;
import com.xinrui.dw.service.impl.FilmInfoServiceImpl;
import com.xinrui.dw.bean.PageParam;
import com.xinrui.dw.util.PageparmUtil;

/**
 * 
 * @ClassName: Indexcontroller
 * @Description: ��ҳ������
 * @author liangzhicheng
 * @date 2016��12��5�� ����11:36:47
 *
 */
@Controller
public class IndexController
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	FilmInfoServiceImpl filmService;

	@RequestMapping(value = "/index/{currentPage}", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable String currentPage)
	{
		ModelAndView mav = new ModelAndView("frame/index");
		// ���ò�����ҳ��
		PageParam page = PageparmUtil.setCurrentPage(currentPage);
		// ��ѯ����
		List<FilmInfo> infos = filmService.queryAllFilmInfoByPage(page);
		for (FilmInfo filmInfo : infos)
		{
			logger.info(filmInfo.toString());
		}
		// ��ҳ�淵������
		mav.addObject("infos", infos);
		mav.addObject("page", page);
		return mav;
	}

}

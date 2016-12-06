package com.xinrui.dw.util;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.xinrui.dw.bean.PageParam;

/**
 * 
 * @ClassName: PageparmUtil
 * @Description: 设置当前页数工具类
 * @author 梁志成
 * @date 2016年4月11日 下午7:12:26
 *
 */
public class PageparmUtil
{

	// 设置当前分页
	public static PageParam setCurrentPage(String currentPage)
	{

		PageParam page = new PageParam();
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if (StringUtils.isEmpty(currentPage) || !pattern.matcher(currentPage).matches())
		{
			// 符合分页规则则正确设置当前页
			page.setCurrentPage(1);
		} else
		{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		return page;
	}
}

package com.xinrui.dw.util;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.xinrui.dw.bean.PageParam;

/**
 * 
 * @ClassName: PageparmUtil
 * @Description: ���õ�ǰҳ��������
 * @author ��־��
 * @date 2016��4��11�� ����7:12:26
 *
 */
public class PageparmUtil
{

	// ���õ�ǰ��ҳ
	public static PageParam setCurrentPage(String currentPage)
	{

		PageParam page = new PageParam();
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if (StringUtils.isEmpty(currentPage) || !pattern.matcher(currentPage).matches())
		{
			// ���Ϸ�ҳ��������ȷ���õ�ǰҳ
			page.setCurrentPage(1);
		} else
		{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		return page;
	}
}

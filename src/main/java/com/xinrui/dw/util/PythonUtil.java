package com.xinrui.dw.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: PythonUtil
 * @Description: python脚本执行工具
 * @author liangzhicheng
 * @date 2016年12月6日 下午4:29:19
 *
 */
public class PythonUtil
{
	private final static Logger logger = LoggerFactory.getLogger(PythonUtil.class);

	public static boolean ExePython(String baseDir, String path, String args)
	{
		try
		{
			// 获取python执行器地址
			Process pr = Runtime.getRuntime().exec(Constant.BASEDIR + " " + Constant.CLUSTERPATH + " " + args);
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null)
			{
				line = new String(line.getBytes("gbk"), "utf-8");
			}
			return true;
		} catch (IOException e)
		{
			logger.error(e.getMessage(), e);
			return false;
		}
	}
}

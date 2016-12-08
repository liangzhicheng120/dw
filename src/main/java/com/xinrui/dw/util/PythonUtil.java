package com.xinrui.dw.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	public static boolean ExePython(String baseDir, String path, String args) throws IOException
	{
		// 获取python执行器地址
		Process pr = Runtime.getRuntime().exec(Constant.BASEDIR + " " + Constant.CLUSTERPATH + " " + args);
		String line = new BufferedReader(new InputStreamReader(pr.getInputStream())).readLine();
		if ("1".equals(line))
		{
			return true;
		}
		return false;
	}
}

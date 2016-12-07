package com.xinrui.dw.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: PythonUtil
 * @Description: python�ű�ִ�й���
 * @author liangzhicheng
 * @date 2016��12��6�� ����4:29:19
 *
 */
public class PythonUtil
{
	private final static Logger logger = LoggerFactory.getLogger(PythonUtil.class);

	public static boolean ExePython(String baseDir, String path, String args)
	{
		try
		{
			// ��ȡpythonִ������ַ
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

package com.xinrui.dw.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	public static boolean ExePython(String baseDir, String path, String args) throws IOException
	{
		// ��ȡpythonִ������ַ
		Process pr = Runtime.getRuntime().exec(Constant.BASEDIR + " " + Constant.CLUSTERPATH + " " + args);
		String line = new BufferedReader(new InputStreamReader(pr.getInputStream())).readLine();
		if ("1".equals(line))
		{
			return true;
		}
		return false;
	}
}

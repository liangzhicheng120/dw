package com.xinrui.dw.python;

import com.xinrui.dw.util.Constant;
import com.xinrui.dw.util.PythonUtil;

/**
 * 
 * @ClassName: Cluster
 * @Description: ִ�о���ű�
 * @author liangzhicheng
 * @date 2016��12��5�� ����5:57:11
 *
 */
public class Cluster
{

	public boolean Execution(String args)
	{
		return PythonUtil.ExePython(Constant.BASEDIR, Constant.CLUSTERPATH, args);
	}

}

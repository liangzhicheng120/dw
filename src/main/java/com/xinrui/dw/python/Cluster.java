package com.xinrui.dw.python;

import com.xinrui.dw.util.Constant;
import com.xinrui.dw.util.PythonUtil;

/**
 * 
 * @ClassName: Cluster
 * @Description: 执行聚类脚本
 * @author liangzhicheng
 * @date 2016年12月5日 下午5:57:11
 *
 */
public class Cluster
{

	public boolean Execution(String args)
	{
		return PythonUtil.ExePython(Constant.BASEDIR, Constant.CLUSTERPATH, args);
	}

}

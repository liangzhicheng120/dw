package demoweb.python;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xinrui.dw.util.Constant;

/**
 * 
 * @ClassName: TestPython
 * @Description: 测试python脚本
 * @author liangzhicheng
 * @date 2016年12月8日 下午2:14:54
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class TestPython
{
	@Test
	public void testCluster() throws IOException
	{
		Process pr = Runtime.getRuntime().exec(Constant.BASEDIR + " " + Constant.CLUSTERPATH + " ");
		BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = in.readLine();
		System.out.println(line);
	}
}

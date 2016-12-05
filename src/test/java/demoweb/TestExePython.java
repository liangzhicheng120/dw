package demoweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import com.xinrui.dw.util.Constant;

/**
 * 
 * @ClassName: TestExePython
 * @Description: ����python�ű���
 * @author liangzhicheng
 * @date 2016��12��5�� ����10:01:18
 *
 */
public class TestExePython
{
	// ���Ծ���ű�
	@Test
	public void testExePython() throws IOException, InterruptedException
	{

		Process pr = Runtime.getRuntime().exec(Constant.BASEDIR + " " + Constant.CLUSTERPATH + " " + "abc");
		BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line;
		while ((line = in.readLine()) != null)
		{
			line = new String(line.getBytes("gbk"), "utf-8");
			System.out.println(line);
		}

	}
}

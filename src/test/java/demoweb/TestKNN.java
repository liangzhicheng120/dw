package demoweb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @ClassName: TestKNN
 * @Description: Weiya He E-mail:heweiya@gmail.com
 * @author liangzhicheng
 * @date 2016年12月2日 上午11:03:07
 *
 */
public class TestKNN
{
	/**
	 * 从数据文件中读取数据
	 * 
	 * @param datas
	 *            存储数据的集合对象
	 * @param path
	 *            数据文件的路径
	 */
	@SuppressWarnings("resource")
	public void read(List<List<Double>> datas, String path)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(path)));
			String data = br.readLine();
			List<Double> l = null;
			while (data != null)
			{
				String t[] = data.split(" ");
				l = new ArrayList<Double>();
				for (int i = 0; i < t.length; i++)
				{
					l.add(Double.parseDouble(t[i]));
				}
				datas.add(l);
				data = br.readLine();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 测试KNN算法
	 */
	@Test
	public void test()
	{
		TestKNN t = new TestKNN();
		String datafile = this.getClass().getClassLoader().getResource("datafile.txt").toString();
		datafile = datafile.replace("file:/", "");// windows 环境上要做的一步
		String testfile = this.getClass().getClassLoader().getResource("testfile.txt").toString();
		testfile = testfile.replace("file:/", "");// windows 环境上要做的一步
		try
		{
			List<List<Double>> datas = new ArrayList<List<Double>>();
			List<List<Double>> testDatas = new ArrayList<List<Double>>();
			t.read(datas, datafile);
			t.read(testDatas, testfile);
			KNN knn = new KNN();
			for (int i = 0; i < testDatas.size(); i++)
			{
				List<Double> test = testDatas.get(i);
				System.out.print("测试元组: ");
				for (int j = 0; j < test.size(); j++)
				{
					System.out.print(test.get(j) + " ");
				}
				System.out.print("类别为: ");
				System.out.println(Math.round(Float.parseFloat((knn.knn(datas, test, 2)))));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
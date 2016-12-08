package demoweb.dao;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.python.modules.newmodule;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csvreader.CsvWriter;
import com.xinrui.dw.bean.FilmInfo;
import com.xinrui.dw.dao.IFilmInfoDao;
import com.xinrui.dw.python.Cluster;
import com.xinrui.dw.util.Constant;

/**
 * 
 * @ClassName: TestAllDao
 * @Description: 测试dao层
 * @author liangzhicheng
 * @date 2016年12月8日 上午10:41:20
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class TestAllDao
{
	@Resource
	IFilmInfoDao filmInfoDao;

	@Test
	public void testCreateCsv() throws IOException
	{
		List<FilmInfo> filmInfos = filmInfoDao.queryAllFilmInfo();
		CsvWriter wr = new CsvWriter(Constant.CSVFILEPATH, ',', Charset.forName("GBK"));
		// 导出所有数据
		for (FilmInfo filmInfo : filmInfos)
		{
			wr.writeComment(filmInfo.toString());
		}
		wr.close();
		// 删除所有数据
		filmInfoDao.deleteAllClusterTab();
		Cluster cluster = new Cluster();
		boolean isCluster = cluster.Execution("");
		System.out.println(isCluster);
	}

}

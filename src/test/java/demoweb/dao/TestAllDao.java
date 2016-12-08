package demoweb.dao;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csvreader.CsvWriter;
import com.xinrui.dw.bean.FilmInfo;
import com.xinrui.dw.dao.IFilmInfoDao;

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
		String csvFilePath = "D:\\workspace\\eclipse-workspace\\dw\\src\\main\\java\\com\\xinrui\\dw\\python\\impl\\source\\test.csv";
		CsvWriter wr = new CsvWriter(csvFilePath, ',', Charset.forName("GBK"));
		for (FilmInfo filmInfo : filmInfos)
		{
			wr.writeComment(filmInfo.toString());
		}
		wr.close();
	}

}

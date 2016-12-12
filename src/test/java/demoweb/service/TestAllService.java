package demoweb.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @ClassName: TestAllService
 * @Description: 测试service层
 * @author liangzhicheng
 * @date 2016年12月8日 上午10:42:26
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class TestAllService
{

	@Test
	public void stringToList()
	{
		String ids = "1,2,3,4";
		List<Integer> idsList = new ArrayList<Integer>();
		for (String id : ids.trim().split(","))
		{
			idsList.add(Integer.valueOf(id));
		}
		for (Integer integer : idsList)
		{
			System.out.println(integer);
		}
	}
}

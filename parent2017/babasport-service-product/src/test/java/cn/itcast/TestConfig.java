package cn.itcast;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.core.bean.TestTb;
import cn.itcast.core.dao.TestTbDao;
import cn.itcast.core.service.TestTbService;

/**
 * 测试类
 * @author pc
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestConfig
{
	
	@Autowired
	private TestTbDao testTbDao;
	
//	@Test
	// 测试数据库的连接
	public void testAdd() throws Exception
	{
		TestTb testTb = new TestTb();
		testTb.setName("漳卅");
		testTb.setBirthday(new Date());
		
		testTbDao.insertTestTb(testTb);
	}
	
	@Autowired
	private TestTbService testTbService;
	
	@Test
	// 测试事务
	public void testAdd2() throws Exception
	{
		TestTb testTb = new TestTb();
		testTb.setName("事务3");
		testTb.setBirthday(new Date());
		
		testTbService.insertTestTb(testTb);
	}
	
}














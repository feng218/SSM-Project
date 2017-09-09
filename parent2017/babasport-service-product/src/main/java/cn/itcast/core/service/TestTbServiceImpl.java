package cn.itcast.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.core.bean.TestTb;
import cn.itcast.core.dao.TestTbDao;

/**
 * 测试事务
 * @author pc
 *
 */
@Service(value = "testTbService")
@Transactional
public class TestTbServiceImpl implements TestTbService
{
	@Autowired
	private TestTbDao testTbDao;

	//保存
	@Override
	public void insertTestTb(TestTb testTb)
	{
		testTbDao.insertTestTb(testTb);
		
		// 若事务起作用, 抛出异常事务回滚
//			throw new RuntimeException();
	}
	
	
}

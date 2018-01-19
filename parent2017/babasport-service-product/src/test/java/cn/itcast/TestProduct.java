package cn.itcast;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.core.bean.TestTb;
import cn.itcast.core.bean.product.Product;
import cn.itcast.core.bean.product.ProductQuery;
import cn.itcast.core.dao.TestTbDao;
import cn.itcast.core.dao.product.ProductDao;
import cn.itcast.core.service.TestTbService;

/**
 * 测试类
 * @author pc
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestProduct
{
	@Autowired
	private ProductDao productDao;
	
	@Test
	public void tesat()
	{
		//查询、分页、指定字段、id、排序
		
		//id
//		Product product = productDao.selectByPrimaryKey(252L);
//		System.out.println(product);
		
		//条件
		ProductQuery proQuery = new ProductQuery();
		String name = "依琦莲";
		proQuery.createCriteria().andNameLike("%" + name + "%"); //模糊查询
		
		//分页
		proQuery.setPageNo(1);
		proQuery.setPageSize(3);
		
		//排序 id desc
		proQuery.setOrderByClause("id desc");
		
		//指定字段查询
		proQuery.setFields("id,name");
		
		List<Product> proList = productDao.selectByExample(proQuery);
		for (Product product : proList)
		{
			System.out.println(product);
		}
	}
	
}














package cn.itcast.core.service.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.bean.product.BrandQuery;
import cn.itcast.core.dao.product.BrandDao;

/**
 * 品牌管理
 * @author lx
 *
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService
{

	@Autowired
	private BrandDao brandDao;
	
	//查询分页对象
	public Pagination selectPaginationByQuery(String name, Integer isDisplay, Integer pageNo)
	{
		BrandQuery brandQuery = new BrandQuery();
		//若pageNo为null 或 小于1, 则设置pageNo等于1
		brandQuery.setPageNo(Pagination.cpn(pageNo)); //当前页
		brandQuery.setPageSize(3); //每页数
		
		//条件
		if(null != name){
			brandQuery.setName(name);
		}
		
		//在页面上是否可见, 默认为是, 值为1
		if(null != isDisplay){
			brandQuery.setIsDisplay(isDisplay);
		}else{
			brandQuery.setIsDisplay(1);
		}
		
		//构建分页对象 (当前页、每页数(自定义)、总条数)
		Pagination pagination = new Pagination(
				brandQuery.getPageNo(),   //当前页
				brandQuery.getPageSize(), //每页数
				brandDao.selectBrandCountByQuery(brandQuery) //总条数
				);
		
		//设置结果集, 从数据库中查询到结果
		pagination.setList(brandDao.selectBrandListByQuery(brandQuery));
		return pagination;
	}
	
	@Override
	public Brand selectBrandById(Long id) {
		// TODO Auto-generated method stub
//		return brandDao.selectBrandById(id);
		return null;
	}

}

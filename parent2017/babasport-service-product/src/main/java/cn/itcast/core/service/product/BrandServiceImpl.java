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
		
		StringBuilder params = new StringBuilder(); //分页前台的URL的参数
		
		//条件
		if(null != name){
			brandQuery.setName(name);
			params.append("name=").append(name); //拼接name
		}
		
		//在页面上是否可见, 默认:是(1)
		if(null != isDisplay){
			brandQuery.setIsDisplay(isDisplay);
			params.append("&isDisplay=").append(isDisplay); //拼接isDisplay
		}else{
			brandQuery.setIsDisplay(1);
			params.append("&isDisplay=1"); //拼接isDisplay
		}
		
		//构建分页对象 (当前页、每页数(自定义)、总条数)
		Pagination pagination = new Pagination(
				brandQuery.getPageNo(),   //当前页
				brandQuery.getPageSize(), //每页数
				brandDao.selectBrandCountByQuery(brandQuery) //总条数
				);
		
		//设置结果集, 从数据库中查询到结果
		pagination.setList(brandDao.selectBrandListByQuery(brandQuery));
		
		//分页在页面上的显示, <a onclick="/brand/list.do?isDisplay=1&pageNo=2"></a>
		String url = "/brand/list.do";
		pagination.pageView(url, params.toString());
		return pagination;
	}
	
	@Override
	public Brand selectBrandById(Long id) {
		return brandDao.selectBrandById(id);
	}

	@Override
	public void updateBrand(Brand brand)
	{
		brandDao.updateBrand(brand);
	}

}

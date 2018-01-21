package cn.itcast.core.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.ProductQuery;
import cn.itcast.core.bean.product.ProductQuery.Criteria;
import cn.itcast.core.dao.product.ProductDao;

@Service("productService")
public class ProductServiceImpl implements ProductService
{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public Pagination selectPaginationByQuery(Integer pageNo, 
			String name, Long brandId, Boolean isShow)
	{
		ProductQuery productQuery = new ProductQuery();
		
		//当前页, 每页数
		productQuery.setPageNo(Pagination.cpn(pageNo));
		productQuery.setPageSize(3);
		
		StringBuilder params = new StringBuilder();
		//判断条件
		Criteria criteria = productQuery.createCriteria();
		if(null != name)
		{
			criteria.andNameLike("%" + name + "%");
			params.append("name=").append(name);
		}
		if(null != brandId) //品牌ID
		{
			criteria.andBrandIdEqualTo(brandId);
			params.append("&brandId=").append(brandId);
		}
		if(null != isShow)  //上下架, 默认下架
		{
			criteria.andIsShowEqualTo(isShow);
			params.append("&isShow=").append(isShow);
		}
		else
		{
			criteria.andIsShowEqualTo(false);
			params.append("&isShow=").append(false);
		}
		
		//分页
		Pagination pagination = new Pagination(
				productQuery.getPageNo(),
				productQuery.getPageSize(),
				productDao.countByExample(productQuery)
		);
		
		//结果集
		pagination.setList(productDao.selectByExample(productQuery));
		
		String url = "/product/list.do";
		pagination.pageView(url, params.toString());
		
		return pagination;
	}
	
	
}

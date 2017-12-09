package cn.itcast.core.service.product;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;

public interface BrandService {
	
	//查询分页对象
	public Pagination selectPaginationByQuery(String name,Integer isDisplay,Integer pageNo);
	//通过ID查询品牌
	public Brand selectBrandById(Long id);

}

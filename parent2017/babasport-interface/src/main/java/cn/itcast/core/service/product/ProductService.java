package cn.itcast.core.service.product;

import cn.itcast.common.page.Pagination;

public interface ProductService
{
	//获取分页对象通过条件
	public Pagination selectPaginationByQuery(Integer pageNo, 
			String name, Long brandId, Boolean isShow);
}

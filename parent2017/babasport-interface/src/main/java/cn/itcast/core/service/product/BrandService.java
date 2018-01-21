package cn.itcast.core.service.product;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;

public interface BrandService {
	
	//查询分页对象
	public Pagination selectPaginationByQuery(String name,Integer isDisplay,Integer pageNo);
	
	//查询所有可见的品牌
	public List<Brand> selectBrandListByQuery(Integer isDisplay);
	
	//通过ID查询品牌
	public Brand selectBrandById(Long id);
	
	//修改
	public void updateBrand(Brand brand);
	
	//批量删除
	public void deleteBrands(Long[] ids);
}

package cn.itcast.core.dao.product;

import java.util.List;

import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.bean.product.BrandQuery;

/**
 * 品牌
 * @author pc
 *
 */
public interface BrandDao
{
	//查询结果集: 名称、是否可用、limit、开始数、每页数
	public List<Brand> selectBrandListByQuery(BrandQuery brandQuery);
	
	//查询总条数: 名称、是否可用
	public Integer selectBrandCountByQuery(BrandQuery brandQuery);
	
	//通过ID查询品牌
	public Brand selectBrandById(Long id);
	
	//修改
	public void updateBrand(Brand brand);
	
	//批量删除
	public void deleteBrands(Long[] ids);
}

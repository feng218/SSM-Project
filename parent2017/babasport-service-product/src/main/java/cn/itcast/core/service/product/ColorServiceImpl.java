package cn.itcast.core.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.core.bean.product.Color;
import cn.itcast.core.bean.product.ColorQuery;
import cn.itcast.core.dao.product.ColorDao;

@Service("colorService")
public class ColorServiceImpl implements ColorService
{

	@Autowired
	private ColorDao colorDao;
	
	@Override
	public List<Color> selectColorList()
	{
		ColorQuery colorQuery = new ColorQuery();
		colorQuery.createCriteria().andParentIdNotEqualTo(0L);
		return colorDao.selectByExample(colorQuery);
	}

}

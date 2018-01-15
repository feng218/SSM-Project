package cn.itcast.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.service.product.BrandService;

/**
 * 品牌管理
 *
 */
@Controller
public class BrandController 
{
	@Autowired
	private BrandService brandService;
	
	//查询
	@RequestMapping(value = "/brand/list.do")
	public String list(String name, Integer isDisplay, Integer pageNo, Model model)
	{
		//返回分页对象
		Pagination pagination = brandService.selectPaginationByQuery(name, isDisplay, pageNo);
		model.addAttribute("pagination", pagination);
		model.addAttribute("name", name);
//		if(null != isDisplay){
			model.addAttribute("isDisplay", isDisplay);
//		}else{
//			model.addAttribute("isDisplay", 1);
//		}
//		
		return "brand/list";
	}
	
	//去修改页面
	@RequestMapping(value = "/brand/toEdit.do")
	public String toEdit(Long id, String condName, Integer condIsDisplay, Model model){
		Brand brand = brandService.selectBrandById(id);//Shift+Alt +L
		model.addAttribute("brand", brand);
		model.addAttribute("condName", condName);
		model.addAttribute("condIsDisplay", condIsDisplay);
		return "brand/edit";
	}
	
	//去修改页面
	@RequestMapping(value = "/brand/edit.do")
	public String edit(String condName, Integer condIsDisplay, Brand brand, RedirectAttributes redirectAttr){
		brandService.updateBrand(brand);
		redirectAttr.addAttribute("name", condName);
		redirectAttr.addAttribute("isDisplay", condIsDisplay);
		return "redirect:/brand/list.do";
	}
	
	//批量删除
	@RequestMapping(value = "/brand/deletes.do")
	public String deletes(Long[] ids, String name, Integer isDisplay, Integer pageNo){
		brandService.deleteBrands(ids);
		return "forward:/brand/list.do";
	}
}

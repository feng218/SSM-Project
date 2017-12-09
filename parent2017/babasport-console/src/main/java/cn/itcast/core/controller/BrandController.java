package cn.itcast.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 品牌管理
 * 列表
 * 删除
 * 修改
 * 添加
 * 删除（单）
 * @author lx
 *
 */
@Controller
public class BrandController 
{
//	@Autowired
//	private BrandService brandService;
	
	//查询
	@RequestMapping(value = "/brand/list.do")
	public String list(String name, Integer isDisplay, Integer pageNo, Model model){
		
//		Pagination pagination = brandService.selectPaginationByQuery(name, isDisplay, pageNo);
//		model.addAttribute("pagination", pagination);
//		model.addAttribute("name", name);
//		if(null != isDisplay){
//			model.addAttribute("isDisplay", isDisplay);
//		}else{
//			model.addAttribute("isDisplay", 1);
//		}
//		
		return "brand/list";
	}
	//去修改页面
//	@RequestMapping(value = "/brand/toEdit.do")
//	public String toEdit(Long id,Model model){
//		Brand brand = brandService.selectBrandById(id);//Shift+Alt +L
//		model.addAttribute("brand", brand);
//		
//		return "brand/edit";
//	}
}

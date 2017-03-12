package cn.itcast.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CenterController
{
	
	//	返回值的三种形式:
	//		ModelView: Model 和 View 放在一起, 因为需要解耦的关系所以不使用;
	//		void	: 使用原生的request, ajax异步时使用;
	//		String	: 返回一个视图, 例如return "index"; ajax同步时使用; model.addAttribute();
	//		测试
	@RequestMapping(value = "/control/index.do")
	public String index()
	{
		return "index";
	}
	
}

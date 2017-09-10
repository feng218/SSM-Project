package cn.itcast.core.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.core.bean.TestTb;
import cn.itcast.core.service.TestTbService;

@Controller
@RequestMapping(value = "/control")
public class CenterController
{
	//入口
	@RequestMapping(value = "/index.do")
	public String index()
	{
		return "index";
	}
	
	//头
	@RequestMapping(value = "/top.do")
	public String top()
	{
		return "top";
	}
	
	//身体
	@RequestMapping(value = "/main.do")
	public String main()
	{
		return "main";
	}
	
	//左边
	@RequestMapping(value = "/left.do")
	public String left()
	{
		return "left";
	}
	
	//右边
	@RequestMapping(value = "/right.do")
	public String right()
	{
		return "right";
	}
	
	//商品的身体
	@RequestMapping(value = "/frame/product_main.do")
	public String product_main()
	{
		return "frame/product_main";
	}
	
	//商品身体左
	@RequestMapping(value = "/frame/product_left.do")
	public String product_left()
	{
		return "frame/product_left";
	}
	
	
	
	
	
	
//	@Autowired
//	private TestTbService testTbService;
	
	//	返回值的三种形式:
	//		ModelView: Model 和 View 放在一起, 因为需要解耦的关系所以不使用;
	//		void	: 使用原生的request, ajax异步时使用;
	//		String	: 返回一个视图, 例如return "index"; ajax同步时使用; model.addAttribute();
	//		测试
//	@RequestMapping(value = "/control/index.do")
//	public String index()
//	{
//		TestTb testTb = new TestTb();
//		testTb.setName("controller1");
//		testTb.setBirthday(new Date());
//		testTbService.insertTestTb(testTb);
//		return "index";
//	}
	
}

package cn.itcast.core.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.itcast.common.web.Constants;
import cn.itcast.core.service.product.UploadService;

@Controller
public class UploadController
{
	@Autowired
	private UploadService uploadService;
	
	//上传单张图片
	@RequestMapping(value = "/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required = false) MultipartFile pic,
			HttpServletResponse response)
	{
		System.out.println(pic.getOriginalFilename());
		try
		{
			String name = pic.getOriginalFilename(); //文件名
			long size = pic.getSize(); //文件大小
			
			// group1/M00/00/00/wKisFFpBG9eAHaQvAAAWKd1hQR4158_big.jpg
			String path = uploadService.uploadPic(pic.getBytes(), name, size);
			String url = Constants.IMAGE_URL + path;
			
			JSONObject json = new JSONObject();
			json.put("url", url);
			json.put("path", path);
			
			//json
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(json.toString()); //返回数据
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/upload/uploadPics.do")
	@ResponseBody
	public List<String> uploadPics(@RequestParam(required = false) MultipartFile[] pics) throws IOException
	{
		List<String> list = new ArrayList<String>(); //保存上传图片后的URL
		for (MultipartFile pic : pics)
		{
			System.out.println(pic.getOriginalFilename());
			try
			{
				String name = pic.getOriginalFilename(); //文件名
				long size = pic.getSize(); //文件大小
				
				// group1/M00/00/00/wKisFFpBG9eAHaQvAAAWKd1hQR4158_big.jpg
				String path = uploadService.uploadPic(pic.getBytes(), name, size);
				String url = Constants.IMAGE_URL + path; //全路径
				list.add(url);
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
}

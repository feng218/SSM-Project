package cn.itcast.core.service.product;

import org.springframework.stereotype.Service;

import cn.itcast.common.fdfs.FastDfsUtils;

@Service("uploadService")
public class UploadServiceImpl implements UploadService
{
	@Override
	public String uploadPic(byte[] pic, String name, long size) throws Exception
	{
		return FastDfsUtils.uploadPic(pic, name, size);
	}
}

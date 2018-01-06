package cn.itcast.core.service.product;

public interface UploadService
{
	public String uploadPic(byte[] pic, String name, long size) throws Exception;
}

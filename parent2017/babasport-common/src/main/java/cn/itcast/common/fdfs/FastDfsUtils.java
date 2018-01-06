package cn.itcast.common.fdfs;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

/**
 * 连接fastdfs, 上传图片
 * 返回上传的路径, 例如: group1/M00/00/00/wKisFFpBG9eAHaQvAAAWKd1hQR4158_big.jpg
 * @author pc
 *
 */
public class FastDfsUtils
{
	//上传图片
	public static String uploadPic(byte[] pic, String name, long size) throws Exception
	{
		//读取配置文件
		ClassPathResource resource = new ClassPathResource("fdfs_client.conf"); //从classpath路径下读取文件
		ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
		
		//连接tracker的客户端
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection(); 
		
		//连接storage的客户端
		StorageServer storageServer = null;
		StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
		
		//上传图片
		String ext = FilenameUtils.getExtension(name);  //获取扩展名
		NameValuePair[] metaArr = new NameValuePair[3]; //描述信息
		metaArr[0] = new NameValuePair("fileName", name);
		metaArr[1] = new NameValuePair("fileExt", ext);
		metaArr[2] = new NameValuePair("fileSize", String.valueOf(size));
		
		String path = storageClient1.upload_file1(pic, ext, metaArr); //返回存储的文件路径
		return path;
	}
}

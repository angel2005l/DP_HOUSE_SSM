package com.edu.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import com.edu.base.Constant;

public final class IOUtil {
	private static final Logger log = LoggerFactory.getLogger(IOUtil.class);
	private static final String realPath = ContextLoader.getCurrentWebApplicationContext().getServletContext()
			.getRealPath("/");

	/**
	 * 
	 * @Title: uploadFile   
	 * @Description: 使用spring方法 上传文件
	 * @param mf
	 * @param filePath
	 * @return
	 * @author: MR.H
	 * @return: String
	 *
	 */
	public static final String uploadFile(MultipartFile mf, String filePath, String newFileName) {
		// 判断文件是否为空
		if (!mf.isEmpty()) {
			String oldFileName = mf.getOriginalFilename();
			String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));
			switch (mf.getContentType()) {
			case Constant.EXCELMIME:
				// 当前时间 唯一性
				newFileName = System.currentTimeMillis() + suffix;
				break;
			case Constant.JPEGMIME:
			case Constant.PNGMIME:
				newFileName += suffix;
				// 新名字使用newFileName来确定 一般是房屋Id+后缀
				break;
			default:
				return "";
			}
			System.err.println("文件路径"+realPath + filePath);
			File fileObj = new File(realPath + filePath, newFileName);
			if (!fileObj.getParentFile().exists()) {
				fileObj.getParentFile().mkdirs();
			}
			try {
				mf.transferTo(new File(realPath + filePath + File.separator + newFileName));// 将文件写到磁盘上
			} catch (IllegalStateException | IOException e) {
				log.error("IO工具类【uploadFile】方法异常,异常原因:" + e.getMessage());
				return "";
			}
			return realPath + filePath + File.separator + newFileName;
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @Title: downloadFile   
	 * @Description: 文件下载
	 * @param path
	 * @param fileName
	 * @return
	 * @author: MR.H
	 * @return: ResponseEntity<byte[]>
	 *
	 */
	public static final ResponseEntity<byte[]> downloadFile(String path, String fileName) {
		// 下载文件路径
		// String path = request.getServletContext().getRealPath("/images/");
		File file = new File(realPath + File.separator + path + File.separator + fileName);
		HttpHeaders headers = new HttpHeaders();
		// 下载显示的文件名，解决中文名称乱码问题
		try {
			// String downloadFielName = new
			// String(filename.getBytes("UTF-8"),"iso-8859-1");
			String downloadFielName = new String(fileName.getBytes("UTF-8"), "UTF-8");
			// 通知浏览器以attachment（下载方式）打开图片
			headers.setContentDispositionFormData("attachment", downloadFielName);
			// application/octet-stream ： 二进制流数据（最常见的文件下载）。
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
					headers, HttpStatus.CREATED);
		} catch (IOException e) {
			log.error("IO工具类【downloadFile】方法异常,异常原因:" + e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * @Title: getFileNname
	 * @Description: 获得子路径名
	 * @param file
	 * @return
	 * @author: MR.H
	 * @return: String
	 *
	 */
	public static final String getFileNname(File file) {
		return file.getName();
	}

	/**
	 * 
	 * @Title: renameFileName   
	 * @Description: 重命名文件 注意：全路径相同
	 * @param oldPath
	 * @param newPath
	 * @return
	 * @author: MR.H
	 * @return: boolean
	 *
	 */
	public static final boolean renameFileName(String oldPath, String newPath) {
		if (!oldPath.equals(newPath)) {
			File oldfile = new File(oldPath);
			File newfile = new File(newPath);
			return oldfile.renameTo(newfile);
		}
		return true;
	}

	/**
	 * 
	 * @Title: deepClone   
	 * @Description: 深度克隆对象
	 * @param obj
	 * @return
	 * @author: MR.H
	 * @return: T
	 *
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deepClone(Object obj) {
		if (null == obj) {
			return null;
		}
		// 将对象写入流中
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			// 将对象从流中读出来
			ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(bi);
			return (T) oi.readObject();
		} catch (IOException | ClassNotFoundException e) {
			log.error("IO工具类【deepClone】方法异常,异常原因:" + e.getMessage());
			return null;
		}
	}
}

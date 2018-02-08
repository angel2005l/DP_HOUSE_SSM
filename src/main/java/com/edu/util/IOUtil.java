package com.edu.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 * @Description: 使用spring方法 对上传的文件处理
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
				// 如果是excel2013 文件的操作
				// 文件名处理 使用系统时间
				// 当前时间 唯一性
				newFileName = System.currentTimeMillis() + suffix;
				break;
			case Constant.JPEGMIME:
			case Constant.PNGMIME:
				// 图片处理
				newFileName += suffix;
				// 新名字使用newFileName来确定 一般是房屋Id+后缀
				break;
			default:
				return "";
			}
			File fileObj = new File(realPath + filePath, newFileName);

			if (!fileObj.getParentFile().exists()) {
				fileObj.getParentFile().mkdirs();
			}
			try {
				mf.transferTo(fileObj);// 将文件写到硬件上
			} catch (IllegalStateException | IOException e) {
				log.error("IO工具类【uploadFile】方法异常,异常原因:" + e.getMessage());
				return "";
			}
			return filePath + newFileName;
		} else {
			return "";
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
	 * @Description: 深度克隆对象 不能使用null对象
	 * @param obj
	 * @return
	 * @author: MR.H
	 * @return: Object
	 *
	 */
	public static T deepClone(Object obj) {
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

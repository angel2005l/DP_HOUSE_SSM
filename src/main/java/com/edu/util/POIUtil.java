package com.edu.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.edu.base.Constant;

public class POIUtil {
	private static final Logger log = LoggerFactory.getLogger(POIUtil.class);

	// 入口方法
	// 需要 是否有头标题 标题所占的行数
	// 有效数据列数
	// 数据列所占的字段数组
	// 路口方法 是否需要数据呢
	// 使用map集合对数据进行处理
	// 获得xlsx文件对象
	// excel 文件数据处理 返回有个 map<String,Object>
	// 判断列是否为空
	// 判断是否数据是否
	// 创建Excel文件的输入流对象
	//// 生成文件内容
	// 入口方法
	public static final List<Map<String, String>> readExcel(String filePath, int colCount, int rowNum,
			String[] rowCodes)
			throws IOException, NullPointerException, Exception {
		// 确认 如何将错误反馈
		if (StrUtil.isBlank(filePath)) {
			throw new NullPointerException("文件路径名为空字符串");
		}

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		String suffix = filePath.substring(filePath.lastIndexOf("."));
		if (Constant.XLSXSUFFIX.equals(suffix)) {
			// 执行2007及以上的.xlsx格式的文件
			list = readExcelXlsx(filePath, colCount, rowNum, rowCodes);
		} else if (Constant.XLSSUFFIX.equals(suffix)) {
			// 执行2017以下的.xls格式的文件
			list = null;// 待开放
		} else {
			throw new Exception("文件格式不正确");
		}
		return list;
	}

	/**
	 * 
	 * @Title: insertExcel2007   
	 * @Description: 2017及以上版本的excel文件操作
	 * @param filePath
	 * @param rowCount
	 * @param rowNum
	 * @param rowCodes
	 * @return
	 * @author: MR.H
	 * @return: List<Map<String,Object>>
	 * @throws IOException 
	 *
	 */
	public static List<Map<String, String>> readExcelXlsx(String filePath, int colCount, int rowNum,
			String[] rowCodes) throws IOException {
		FileInputStream inputStream = null;
		XSSFWorkbook workbook = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			inputStream = new FileInputStream(filePath);// 创建文件流对象
			// XSSFWorkbook 就代表一个 Excel 文件
			// 创建其对象，就打开这个 Excel 文件
			workbook = new XSSFWorkbook(inputStream);
			// System.out.println(workbook);
			// XSSFSheet 代表 Excel 文件中的一张表格
			// 我们通过 getSheetAt(0) 指定表格索引来获取对应表格
			// 注意表格索引从 0 开始！
			XSSFSheet sheet = workbook.getSheetAt(0);// 选择第一个分页
			// 开始循环表格数据,表格的行索引从 0 开始
			// employees.xlsx 第一行是标题行，我们从第二行开始, 对应的行索引是 1
			// sheet.getLastRowNum() : 获取当前表格中最后一行数据对应的行索引

			// 判断当前页 是否有数据
			if (null == sheet || sheet.getLastRowNum() < rowNum)
				throw new IOException("Excel文件有误，数据必须放在第一个sheet，请检查Excel");

			// 校验数据行数据
			for (int rowIndex = rowNum; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex);

				if (row == null)
					throw new IOException("Excel文件第" + (rowIndex + 1) + "行数据为空");
				// 根据传入的columnCount与实际excel中读到的列数量进行比较
				if (row.getLastCellNum() < colCount)
					throw new IOException("Excel文件第" + (rowIndex + 1)
							+ "行数据列总数小于规定的格式");
				// excel一行数据就是一个map
				Integer cellCountInRow = Math.min(row.getLastCellNum(),
						colCount);
				Map<String, String> map = new HashMap<String, String>();
				// 检查当前行数据是否为空
				if (!isCellNull(row)) {
					continue;
				}
				// 遍历列
				for (int cellIndex = 0; cellIndex < cellCountInRow; cellIndex++) {
					XSSFCell cell = row.getCell(cellIndex);
					if (null == cell)
						throw new IOException("Excel文件第" + (rowIndex + 1) + "行第"
								+ (cellIndex + 1) + "列数据为空");
					String cellStr = getValue(cell).trim();
					if ("".equals(cellStr))
						throw new IOException("Excel文件第" + (rowIndex + 1) + "行第"
								+ (cellIndex + 1) + "列的数据不能为空单元格");
					// 按照索引从键数组中得到字段英文名
					map.put(rowCodes[cellIndex], cellStr);
				}
				list.add(map);
			}
			return list;
		} catch (IOException e) {
			log.error("POI工具类【readExcelXlsx】方法异常,异常原因:" + e.getMessage());
			throw new IOException("操作excel文件错误");
		} finally {
			if (null != inputStream) {
				inputStream.close();
			}
			if (null != workbook) {
				workbook.close();
			}
		}

	}

	/**
	 * 
	 * @Title: isCellNull   
	 * @Description: 是否是整行为空
	 * @param row
	 * @return
	 * @author: MR.H
	 * @return: Boolean
	 *
	 */
	@SuppressWarnings("deprecation")
	private static Boolean isCellNull(XSSFRow row) {
		if (row == null) {
			return false;
		}
		// if(row.getPhysicalNumberOfCells()>0){
		// return true;
		// }
		for (int cellnum = 0; cellnum < row.getLastCellNum(); cellnum++) {
			if (row.getCell(cellnum).getCellType() != Cell.CELL_TYPE_BLANK) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	private static String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	private static String getValue(XSSFCell xssfCell) {
		if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfCell.getBooleanCellValue());
		} else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(xssfCell.getNumericCellValue());
		} else {
			return String.valueOf(xssfCell.getStringCellValue());
		}
	}
}
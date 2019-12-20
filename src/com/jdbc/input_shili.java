package com.jdbc;

import java.io.*;
import java.sql.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;



public class input_shili {
	static Connection lianjie=null;
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		lianjie=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc?characterEncoding=UTF-8","root","123456");
		File mulu=new File("D:\\tice");
		File[] files=mulu.listFiles();
		System.out.println("一共有"+files.length+"个文件");
		for(File file:files){
			System.out.println(file);
			if(file.getName().endsWith("xlsx")) {
				dpbxrmgwj_xlsx(file);
			}
			else if(file.getName().endsWith("xls")) {
				dpbxrmgwj_xls(file);
			}
		}

	}

	private static void dpbxrmgwj_xls(File file) throws Exception{
		FileInputStream fin=new FileInputStream(file);
		HSSFWorkbook workbook=new HSSFWorkbook(fin);
		HSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows=sheet.getLastRowNum();
		for(int i=0;i<=rows;i++) {
			HSSFRow row=sheet.getRow(i);
			HSSFCell cell=row.getCell(3);
			String xuehao=cell.getStringCellValue();
			if(xuehao.equals("学号")) {
				continue;
			}
			
			HSSFCell cell20=row.getCell(19);
			HSSFCell cell21=row.getCell(20);
			if(cell20!=null&& cell21!=null) {
			String z_shili=cell20.getStringCellValue();
			String y_shili=cell21.getStringCellValue();
			
			PreparedStatement yudingyi_yuju=lianjie.prepareStatement("update sheet1 set"+"`左眼裸眼视力`=?,`右眼裸眼视力`=? where`学号`=?");
			yudingyi_yuju.setString(1,z_shili);
			yudingyi_yuju.setString(2,y_shili);
			yudingyi_yuju.setString(3,xuehao);
			yudingyi_yuju.executeUpdate();
			
			/*Statement yuju=lianjie.createStatement();
			String sql="UPDATE sheet1 SET `左眼裸眼视力`='"+z_shili+"',`右眼裸眼视力`='"+y_shili+"' where `学号`='"+xuehao+"'";
			
			yuju.execute(sql);*/
			}
		}

	}
	
	private static void dpbxrmgwj_xlsx(File file) throws Exception{
		FileInputStream fin=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fin);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows=sheet.getLastRowNum();
		for(int i=0;i<=rows;i++) {
			XSSFRow row=sheet.getRow(i);
			XSSFCell cell=row.getCell(3);
			String xuehao=cell.getStringCellValue();
			if(xuehao.equals("学号")) {
				continue;
			}
			
			XSSFCell cell20=row.getCell(19);
			XSSFCell cell21=row.getCell(20);

			if(cell20!=null&& cell21!=null) {
			String z_shili=cell20.getStringCellValue();
			String y_shili=cell21.getStringCellValue();
			
			PreparedStatement yudingyi_yuju=lianjie.prepareStatement("update sheet1 set"+"`左眼裸眼视力`=?,`右眼裸眼视力`=? where`学号`=?");
			yudingyi_yuju.setString(1,z_shili);
			yudingyi_yuju.setString(2,y_shili);
			yudingyi_yuju.setString(3,xuehao);
			yudingyi_yuju.executeUpdate();
			/*Statement yuju=lianjie.createStatement();
			String sql="UPDATE sheet1 SET `左眼裸眼视力`='"+z_shili+"',`右眼裸眼视力`='"+y_shili+"' where `学号`='"+xuehao+"'";
			
			yuju.execute(sql);*/
			
			}
		}

	}
}

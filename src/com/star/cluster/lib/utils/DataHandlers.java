package com.star.cluster.lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class DataHandlers {


	public static String  getDatafromExcel(String filepath , String sheetname , int rowindex , int cellIndex)
	{
		String data = null;
		try 
		{
			File f = new File (filepath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetname);
			Row r = st.getRow(rowindex);
			Cell c = r.getCell(cellIndex);
			data = c.toString();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return data;
	}
	

	public static String  getDatafromProperties(String filepath , String key)
	{
		String data = null;
		try 
		{
			File f = new File (filepath);
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties ();
			prop.load(fis);
			data = prop.get(key).toString();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return data;
	}
	
}

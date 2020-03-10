package com.resileo.seleniumweb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class FileUtilities extends Utility{

	// Loading the Data Sheet
	@SuppressWarnings("resource")
	public String getdata(String filename, String Sheetname,int ColumnNo,int rownum) throws Exception{
		File file =    new File("res\\"+filename);
		//cell.setCellType(Cell.CELL_TYPE_STRING)
		FileInputStream inputStream = new FileInputStream(file);
		Workbook TestData = null;
		TestData = new XSSFWorkbook(inputStream);
		Sheet DataSheet = TestData.getSheet(Sheetname);
		Row row = DataSheet.getRow(rownum);
		return row.getCell(ColumnNo).getStringCellValue();//.toString();
	}

	// Counting Rows for Looping 
	@SuppressWarnings("resource")
	public  int getrowcount (String filename, String Sheetname) throws Exception{
		File file =    new File("res\\"+filename);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook TestData = null;
		TestData = new XSSFWorkbook(inputStream);
		Sheet DataSheet = TestData.getSheet(Sheetname);
		int rowCount = DataSheet.getLastRowNum()-DataSheet.getFirstRowNum();
		return rowCount;
	}

	// Get the full file content
	public String getfilecontet() throws Exception
	{
		File file = new File(getProperty("OR"));
		return FileUtils.readFileToString(file);
	}


	// Append Text to an Exiting file.
	public void appendfile(String filename,String data) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			File file = new File(filename);
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	// Write Data to New File
	public void Writefile(String filename,String data) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			File file = new File(filename);
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), false);
			bw = new BufferedWriter(fw);
			bw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	// Get the Object Name from the OR file. 
	public String getObjName(String ObjValue) throws Exception
	{
		String objname ="";
		FileUtilities Fe = new FileUtilities();
		String AllObjects = Fe.getfilecontet();
		String[] objArray = AllObjects.split("\n");
		for(int i = 0;i<objArray.length;i++)
		{
			if(objArray[i].contains(ObjValue))
			{
				String ObjVal[] = objArray[i].split("=");
				objname  = ObjVal[0].replaceAll(" ","").replaceAll("String","").trim();
				break;

			}
		}
		return objname;
	}

}
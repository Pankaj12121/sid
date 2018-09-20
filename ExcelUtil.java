package com.tebt.excelutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {




	public List<HashMap<String,String>> loadAllScenarioData(String ExcelPath, String dataUploadFlag) throws IOException {
		if(dataUploadFlag.equalsIgnoreCase("Yes")){
	
		FileInputStream fis = new FileInputStream(ExcelPath);


		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		//HashMap<Object, Object> map= new HashMap<Object,Object>();
		List<HashMap<String, String>> Allmap= new ArrayList<>();

		int numberOfSheets= workbook.getNumberOfSheets();

		for (int i=0;i<=numberOfSheets-1;i++) {
			String RunningShhet="RunningSheet";
			Sheet sheets = workbook.getSheetAt(i);
			int rows= sheets.getPhysicalNumberOfRows();
			String sheetName=sheets.getSheetName();
			for(int j=1;j<=rows-1;j++) {

				Row Headerrow= sheets.getRow(0);
				Row row= sheets.getRow(j);
				String TestCaseID=row.getCell(1).toString();
				int cells= row.getPhysicalNumberOfCells();
				HashMap<String, String> currentHash= new HashMap<String,String>();
				currentHash.put(RunningShhet, sheetName);
				for (int k =0;k<=cells-1;k++) {

					Cell headercell= Headerrow.getCell(k);
					//System.out.println(headercell);
					Cell currentCell= row.getCell(k);
					//System.out.println(cell);
					switch (currentCell.getCellType())
					{
					case Cell.CELL_TYPE_STRING:
						System.out.print(currentCell.getStringCellValue() + "\t");
						currentHash.put(headercell.getStringCellValue(), currentCell.getStringCellValue());
						break;
					}


					System.out.println(currentHash);

				}
				if(!currentHash.isEmpty()) {
				Allmap.add(currentHash);
				String uName=Allmap.get(0).get("ConfigUserName");
				System.out.println(uName);
				}
			}
		}
		fis.close();
		return Allmap;
		}
		System.out.println("Data Upload flag is set to NO");
		return null;
	}

	public List<HashMap<String,String>> sheetwiseData(List<HashMap<String, String>> testData,String SheetName,String testCaseID) {
		List<HashMap<String,String>> sheetdataAll= new ArrayList<>();
		for(HashMap<String,String> sheetData:testData) {

			if (sheetData.containsValue(SheetName) && sheetData.containsValue(testCaseID))

				sheetdataAll.add(sheetData);


		}




		return sheetdataAll;

	}

	public List<ArrayList<String>> loadTestSteps(String ExcelPath,String testcaseID,String dataUploadFlag) throws IOException {
		if(dataUploadFlag.equalsIgnoreCase("Yes")) {
			
	FileInputStream fis = new FileInputStream(ExcelPath);
	@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//HashMap<Object, Object> map= new HashMap<Object,Object>();
		List<ArrayList<String>> Allmap= new ArrayList<>();
		int numberOfSheets= workbook.getNumberOfSheets();
		for (int i=0;i<=numberOfSheets-1;i++) {
			String RunningShhet="RunningSheet";
			Sheet sheets = workbook.getSheetAt(i);
			int rows= sheets.getPhysicalNumberOfRows();
			String sheetName=sheets.getSheetName();
			for(int j=1;j<=rows-1;j++) {
				int cells=0;
				Row Headerrow= sheets.getRow(0);
				Row row= sheets.getRow(j);
				String TestCaseID=row.getCell(1).toString();
				if(TestCaseID.equalsIgnoreCase(testcaseID))
					cells= row.getPhysicalNumberOfCells();
				ArrayList<String> currentHash= new ArrayList<>();

				for (int k =0;k<=cells-1;k++) {

					Cell headercell= Headerrow.getCell(k);
					//System.out.println(headercell);
					Cell currentCell= row.getCell(k);
					//System.out.println(cell);
					switch (currentCell.getCellType())
					{
					case Cell.CELL_TYPE_STRING:
						System.out.print(currentCell.getStringCellValue() + "\t");
						currentHash.add(currentCell.getStringCellValue());
						break;
					}


					System.out.println(currentHash);

				}
				if(!currentHash.isEmpty())
				Allmap.add(currentHash);

			}
		}
		fis.close();
		return Allmap;
	}
		System.out.println("Data Upload flag is set to NO");
		return null;
	}
	public List<ArrayList<String>> loadscenarioToExecuteFromRepo(String ExcelPath,String dataUploadFlag) throws IOException {
		if(dataUploadFlag.equalsIgnoreCase("Yes")) {
		FileInputStream fis = new FileInputStream(ExcelPath);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//HashMap<Object, Object> map= new HashMap<Object,Object>();
		List<ArrayList<String>> Allmap= new ArrayList<>();
		int numberOfSheets= workbook.getNumberOfSheets();
		for (int i=0;i<=numberOfSheets-1;i++) {
			String RunningShhet="RunningSheet";
			Sheet sheets = workbook.getSheetAt(i);
			int rows= sheets.getPhysicalNumberOfRows();
			String sheetName=sheets.getSheetName();
			for(int j=1;j<=rows-1;j++) {
				int cells=0;
				Row Headerrow= sheets.getRow(0);
				Row row= sheets.getRow(j);
				String TestCaseID=row.getCell(1).toString();
				cells= row.getPhysicalNumberOfCells();
				ArrayList<String> currentHash= new ArrayList<>();

				for (int k =0;k<=cells-1;k++) {

					Cell headercell= Headerrow.getCell(k);
					//System.out.println(headercell);
					Cell currentCell= row.getCell(k);
					//System.out.println(cell);
					switch (currentCell.getCellType())
					{
					case Cell.CELL_TYPE_STRING:
						System.out.print(currentCell.getStringCellValue() + "\t");
						currentHash.add(currentCell.getStringCellValue());
						break;
					}


					System.out.println(currentHash);

				}
				if(!currentHash.isEmpty())
				Allmap.add(currentHash);

			}
		}
		fis.close();
		return Allmap;
		
		}
		System.out.println("Data Upload flag is set to NO");
		return null;
	}
	/*public class DataHelper {
			   public static HashMap<String,String> storeValues = new HashMap();
			   public static List<HashMap<String,String>> data(String filepath,String sheetName)
			   {
			      List<HashMap<String,String>> mydata = new ArrayList<>();
			      try
			      {
			         FileInputStream fs = new FileInputStream(filepath);
			         XSSFWorkbook workbook = new XSSFWorkbook(fs);
			         XSSFSheet sheet = workbook.getSheet(sheetName);
			         Row HeaderRow = sheet.getRow(0);
			         for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
			         {
			            Row currentRow = sheet.getRow(i);
			            HashMap<String,String> currentHash = new HashMap<String,String>();
			            for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
			            {
			               Cell currentCell = currentRow.getCell(j);
			               switch (currentCell.getCellType())
			               {
			               case Cell.CELL_TYPE_STRING:
			                  System.out.print(currentCell.getStringCellValue() + "\t");
			                  currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
			                  break;
			               }
			            }
			            mydata.add(currentHash);
			         }
			         fs.close();
			      }
			      catch (Exception e)
			      {
			         e.printStackTrace();
			      }
			      return mydata;
			   }
			}
	 */

}




package com.tebt.driverScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;

import com.demo.tebtQuotePages.FlowControl;
import com.tebt.common.BrowserInsatnce;
import com.tebt.excelutility.ExcelUtil;


public class DriverExecution {
	public static WebDriver driver;
	static StopWatch watch;
	static BrowserInsatnce instance;
	static Properties prop;
	public static List<HashMap<String,String>>testData;

	public static void main(String[] args) throws InterruptedException {
		try {
			String filePath="D:\\Grid\\ScenarioTestData.xlsx";
			String testStepfile="D:\\Grid\\TestSteps.xlsx";
			String scenarioRepo="D:\\Grid\\ScenarioRepo.xlsx";
			//new DBConnectClass();
			loadConfig();
			instance= new BrowserInsatnce();
			watch= new StopWatch();
			watch.start();
			driver=instance.setup(prop.getProperty("BrowserName"));
			driver.get(prop.getProperty("ApplicationURL"));
			String DataUploadFlag=prop.getProperty("UploadAllDataTables");
			ExcelUtil utils= new ExcelUtil();
			List<ArrayList<String>>scenariorepoList=utils.loadscenarioToExecuteFromRepo(scenarioRepo,DataUploadFlag);
			testData=utils.loadAllScenarioData(filePath,DataUploadFlag);
			for(ArrayList<String> scenarioToExecute:scenariorepoList){

				String TestcaseID=scenarioToExecute.get(0).toString();
				if(scenarioToExecute.get(1).equalsIgnoreCase("Yes")) {

					List<ArrayList<String>>testSteps=utils.loadTestSteps(testStepfile,TestcaseID,DataUploadFlag);
					FlowControl flowcontrol= new FlowControl();

					flowcontrol.executeSteps(testData,testSteps,TestcaseID,driver);

				}
			}

			watch.stop();
			System.out.println(watch.getTime());
		}catch(Exception e) {
			e.printStackTrace();;
		}finally{
			watch.stop();
			System.out.println("Execution Completed & took around " +watch.getTime(TimeUnit.MINUTES)+" minutes");
		}

	}

	public static void loadConfig() {

		try {
			FileInputStream fileinput= new FileInputStream("config.properties");
			prop= new Properties();
			prop.load(fileinput);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}

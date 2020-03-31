package cn.tjuscs.second;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FirstSelenium {
	public WebDriver driver;
	public Map<String, String> user;
	@Before
	public void getuser() throws IOException {
		user = new HashMap<String,String>();
		String Path = System.getProperty("user.dir") + "/Selenium+Lab2020.xlsx";
		File xlsxFile = new File(Path);

		Workbook workbook = WorkbookFactory.create(xlsxFile);
		int sheetCount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetCount; i++) {
			// ��ȡ������
			Sheet sheet = workbook.getSheetAt(i);

			int firstRowNum = sheet.getFirstRowNum(); // ��ȡ��ǰ���ĵ�һ��
			int lastRowNum = sheet.getLastRowNum(); // ��ȡ��ǰ�������һ��
			// �������ݼ�
			for (int rIndex = firstRowNum; rIndex <= lastRowNum; rIndex++) {
				Row row = sheet.getRow(rIndex); // ��ȡ��ǰ������
				if (!row.equals(null)) {
					int firstCellNum = row.getFirstCellNum(); // ��ǰ�еĵ�һ��
					String userkey = row.getCell(firstCellNum).getStringCellValue(); // ��ȡ��ֵ
					String uservalue = row.getCell(firstCellNum+1).getStringCellValue();
					user.put(userkey,uservalue);
				}
			}
		}
		String driverPath = System.getProperty("user.dir") + "/src/sourcesdriver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		String baseUrl = "http://103.120.226.190/selenium-demo/git-repo";
		driver.get(baseUrl);
	}
	@Test
	public void selenium() {
		
		Iterator<Entry<String,String>> iter = user.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<String,String> entry = iter.next();
			String key = entry.getKey();
			String value = entry.getValue(); 
			WebElement userName = driver.findElement(By.name("user_number"));
			userName.sendKeys(key);
			WebElement passName = driver.findElement(By.name("password"));
			passName.sendKeys(value);
			WebElement submitName = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input"));
			submitName.click();
			WebElement textShow = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code"));
			if(textShow.getText().equals(value)) {
				System.out.println("Success!");
			}else {
				System.out.println("Failed!");
			}
		}
	}
	
	@After
	public void end() {
		driver.close();
	}

}

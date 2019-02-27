package com.automation.Bisa;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.Bisa_Error.Screenshot_Utils;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Testd extends Base_Library {
	Excell_Utils elib = new Excell_Utils();

	@BeforeMethod
	public void openApp() throws InterruptedException {
		selectBrowser("Chrome");
		d.get("http://app.autolikesig.globusdemos.com/login");
		Thread.sleep(3000);
	}

	@Test
	public void loginTest() throws Exception {

		int length = elib.lengthOfRow("Sheet1");
		for (int i = 1; i <= length; i++) {
			System.out.println(i + " Run");
			String initaialPageTitle = d.getTitle();
			String username = elib.getExcellData("Sheet1", i, 1);
			String password = elib.getExcellData("Sheet1", i, 2);
			d.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
			d.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			d.findElement(By.xpath("//form[@id='loginform']/div[4]/div/button")).click();
			Thread.sleep(10000);
			String currentPageTitle = d.getTitle();
			if (!initaialPageTitle.equals(currentPageTitle)) {
				String Status = elib.setExcellData("Sheet1", i, 3, "Pass");
				try {
					d.findElement(By.xpath("//div[@class= 'swal2-header']/following-sibling::div[2]/button[2]"))
							.click();
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					d.findElement(By.xpath("//div[@class='navbar-header']/ul[2]/li")).click();
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					d.findElement(By.xpath("//li[@class='dropdown show open']/ul/li[3]/a")).click();
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else {
				String Status = elib.setExcellData("Sheet1", i, 3, "Fail");
				try {
					WebElement errorUsername = d.findElement(By.xpath("//form[@id='loginform']/div[1]"));
					String data1 = errorUsername.getText();
					String error1 = elib.setExcellData("Sheet1", i, 4, data1);
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					WebElement errorUsername = d.findElement(By.xpath("//form[@id='loginform']/div[1]/div/span"));
					String data2 = errorUsername.getText();
					String error2 = elib.setExcellData("Sheet1", i, 4, data2);
				} catch (Exception e) {
				}
				try {
					WebElement errorPassword = d.findElement(By.xpath("//form[@id='loginform']/div[2]/div/span"));
					String data3 = errorPassword.getText();
					String error3 = elib.setExcellData("Sheet1", i, 5, data3);
				} catch (Exception e) {
				}
				Screenshot_Utils.takeSnapShot("Error_" + i + "_");
			}
			Thread.sleep(500);
			d.navigate().refresh();
			Thread.sleep(1000);
		}
	}

	@AfterMethod
	public void tearDown() {
		d.quit();
	}

	/*
	 * @AfterMethod public void screenShot(ITestResult result) { // using
	 * ITestResult.FAILURE is equals to result.getStatus then it enter into if //
	 * condition if (ITestResult.FAILURE == result.getStatus()) { try { // To create
	 * reference of TakesScreenshot TakesScreenshot screenshot = (TakesScreenshot)
	 * d; // Call method to capture screenshot File src =
	 * screenshot.getScreenshotAs(OutputType.FILE); // Copy files to specific
	 * location // result.getName() will return name of test case so that screenshot
	 * name will // be same as test case name FileUtils.copyFile(src, new
	 * File("D:\\myCodeSpace\\Bisa\\Screenshots\\" + result.getName() + ".png"));
	 * System.out.println("Successfully captured a screenshot"); } catch (Exception
	 * e) { System.out.println("Exception while taking screenshot " +
	 * e.getMessage()); } } d.quit(); }
	 */

	/*
	 * @AfterTest // AfterMethod annotation - This method executes after every test
	 * execution public void screenShot(ITestResult result) { // using
	 * ITestResult.FAILURE is equals to result.getStatus then it enter into if //
	 * condition if (ITestResult.FAILURE == result.getStatus()) { try { // To create
	 * reference of TakesScreenshot TakesScreenshot screenshot = (TakesScreenshot)
	 * d; // Call method to capture screenshot File src =
	 * screenshot.getScreenshotAs(OutputType.FILE); // Copy files to specific
	 * location // result.getName() will return name of test case so that screenshot
	 * name will // be same as test case name FileUtils.copyFile(src, new
	 * File("D:\\myCodeSpace\\Bisa\\Screenshots" + result.getName() + ".png"));
	 * System.out.println("Successfully captured a screenshot"); } catch (Exception
	 * e) { System.out.println("Exception while taking screenshot " +
	 * e.getMessage()); } } }
	 */

}

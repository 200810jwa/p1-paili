//package com.revature.web.employee;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
//
//import java.io.File;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.openqa.selenium.NoAlertPresentException;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.revature.web.OSChecker;
//import com.revature.web.employee.page.ApplyPage;
//
//public class ApplyPageTest {
//	private static WebDriver driver;
//	private ApplyPage page;
//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		if (OSChecker.isWindows()) {
//			File f = new File("src/test/resources/chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
//			System.out.println("Using Windows Driver");
//		} else {
//			File f = new File("src/test/resources/chromedriver");
//			System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
//		}
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//		driver.quit();
//	}
//
//	@Before
//	public void setUp()  {
//		this.page = new ApplyPage(driver);
//	}
//
//	@After
//	public void tearDown() {
//		this.page = null;
//	}
//
//	@Test
//	public void testPage() {
//		String methodName = new Object() {}
//	      .getClass()
//	      .getEnclosingMethod()
//	      .getName();
//	    System.out.println("Running " + methodName + "...");
//		
//		assertEquals("New Reimbursement", driver.getTitle());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testLogout() {
//		String methodName = new Object() {}
//	      .getClass()
//	      .getEnclosingMethod()
//	      .getName();
//	    System.out.println("Running " + methodName + "...");
//	    
//	    page.getLogoutBtn().click();
//	    
//		assertEquals(("ERS Portal"), driver.getTitle());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testBack() throws InterruptedException {
//		String methodName = new Object() {}
//	      .getClass()
//	      .getEnclosingMethod()
//	      .getName();
//	    System.out.println("Running " + methodName + "...");
//	    
//	    page.getBackBtn().click();
//	    WebDriverWait wait = new WebDriverWait(driver,2);
//	    wait.until(ExpectedConditions.urlToBe(System.getenv("SERVER_URL") + "/project1/EmployeeHome"));
//	    
//	    assertEquals("Employee Portal", driver.getTitle());
//	    try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testSubmitMissing() {
//		String methodName = new Object() {}
//	      .getClass()
//	      .getEnclosingMethod()
//	      .getName();
//	    System.out.println("Running " + methodName + "...");
//	    
//	    page.getSubmitBtn().click();
//	    try {
//		    driver.switchTo().alert().dismiss();
//		    assertTrue(true);
//	    } catch(NoAlertPresentException e) {
//	    	fail("No alert");
//	    }
//	    try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testTypeSelection() {
//		String methodName = new Object() {}
//	      .getClass()
//	      .getEnclosingMethod()
//	      .getName();
//	    System.out.println("Running " + methodName + "...");
//	    
//	    Select inputType = new Select(page.getInputType());
//	    int nOptions = inputType.getOptions().size();
//	    int count = 0;
//	    
//	    assertTrue(inputType.getOptions().size() == 4);
//	    	    
//	    try {
//	    	inputType.selectByVisibleText("Lodging"); count++;
//	    	inputType.selectByVisibleText("Travel"); count++;
//	    	inputType.selectByVisibleText("Food"); count++;
//	    	inputType.selectByVisibleText("Other"); count++;
//	    } catch (NoSuchElementException e) {
//	    	fail("Missing an option");
//	    }
//	    
//	    assertTrue(count == nOptions);
//	    try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testNegativeAmount() {
//		String methodName = new Object() {}
//	      .getClass()
//	      .getEnclosingMethod()
//	      .getName();
//	    System.out.println("Running " + methodName + "...");
//	    
//	    page.getInputAmt().sendKeys("-100.00");
//	    page.getSubmitBtn().click();
//	    
//	    try {
//	    	String alertText = driver.switchTo().alert().getText();
//	    	assertEquals("Cannot have negative reimbursements!", alertText);
//	    	driver.switchTo().alert().dismiss();
//	    } catch (NoAlertPresentException e) {
//	    	fail("Alert not found!");
//	    }
//	    try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//}

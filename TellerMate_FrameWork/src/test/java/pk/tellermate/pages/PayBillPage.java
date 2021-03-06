/**
 * 
 */
package pk.tellermate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * @author saif.khan
 *
 */
public class PayBillPage {
	WebDriver driver;

	@FindBy(how = How.CLASS_NAME, using = "pg-title")
	private WebElement pageTitle;

	@FindBy(how = How.NAME, using = "billerId")
	private WebElement billerId;

	@FindBy(how = How.NAME, using = "referenceNumber")
	private WebElement consumerNo;

	@FindBy(how = How.NAME, using = "billId")
	private WebElement billId;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Find Bill')]")
	private WebElement findBill_btn;

	// Repetative Bills
	@FindBy(how = How.LINK_TEXT, using = "Repetitive Bills")
	private WebElement repetitiveTab;
	
	@FindBy (how = How.XPATH, using = "//button[contains(text(),'Pay Bill')]") 
	private WebElement btnPayBill;
	
	@FindBy (how = How.XPATH, using ="//span[@class='msg-box success']") 
	private WebElement msgBox;

	////////////////////////////////////////////

	// Constructor
	public PayBillPage(WebDriver driver) {
		this.driver = driver;
	}

	// Method to assert the Pay Bill page
	public void verifyPage() {
		Assert.assertTrue(pageTitle.getText().contains("Pay Bill"));
	}

	// Method to search a bill based on company and consumer number
	public void searchBill(String company, String consumerNo) {
		Select selectBiller = new Select(billerId);
		selectBiller.selectByVisibleText(company);

		this.consumerNo.clear();
		this.consumerNo.sendKeys(consumerNo);

		this.findBill_btn.click();
	}

	// Method to search a bill based on company, consumer number and bill ID
	public void searchBill(String company, String consumerNo, String billId) {
		Select selectBiller = new Select(billerId);
		selectBiller.selectByVisibleText(company);

		this.consumerNo.clear();
		this.consumerNo.sendKeys(consumerNo);

		this.billId.clear();
		this.billId.sendKeys(billId);

		this.findBill_btn.click();
	}

	// Method to find a bill from repetitive bills
	public void findInRepetitive() {
		Assert.assertTrue(repetitiveTab.isEnabled());
		
		try {
			Thread.sleep(300);
			Assert.assertTrue(clickUnPaid());
			clickUnPaid();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Search and click on an UNPAID bill from the dynamic table.
	private boolean clickUnPaid()
	{
		int i=1;
		boolean flag = false; // Is Unpaid record found or not
		String stStatusXPath= "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[";
		String endStatusXPath="]/td[6]";
		WebElement element;

		while(isElementPresent(stStatusXPath+i+endStatusXPath))
		{
			element = driver.findElement(By.xpath(stStatusXPath+i+endStatusXPath));
			if (element.getText().contains("UNPAID"))
			{
				System.out.println("["+i+"] "+element.getText());
				element.click();
				flag=true;
				break;
			}
			else
			{
				System.out.println("else "+i+": "+element.getText());
				flag=false;
				i++;
			}
		}
		return flag;
	}
	// Find an element in Status column of the grid
	private boolean isElementPresent(String xp) 
	{
		int count = driver.findElements(By.xpath(xp)).size();
		if (count==0)
			return false;
		else
			return true;
	}
	
// To Click on PayBill button
	public void clickPayBill()
	{
		if (btnPayBill.isEnabled())
			btnPayBill.click();
		else
			System.out.println ("Button is NOT enabled.");
	}
	

}

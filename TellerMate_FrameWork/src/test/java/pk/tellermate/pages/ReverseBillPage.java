/**
 * 
 */
package pk.tellermate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * @author saif.khan
 *
 */
public class ReverseBillPage 
{
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(how=How.CLASS_NAME, using ="pg-title") 
	private WebElement pgTitle;

	@FindBy (how=How.NAME, using ="billerId") 
	private WebElement billerId;

	@FindBy (how=How.NAME, using ="referenceNumber") 
	private WebElement refNo;

	@FindBy (how=How.NAME, using ="billId") 
	private WebElement billId;

	@FindBy (how=How.XPATH, using ="//button[@class='btn btn-secondary btn-round btn-block']") 
	private WebElement btnFindBill;
	
	@FindBy (how=How.XPATH, using = "//button[@class='btn btn-danger']") 
	private WebElement btnReverse;
	

	///////////////////////////////////
	
	//	To set the company
	public void setCompany(String company)
	{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(billerId));
		
		Select comp = new Select (billerId);
		comp.selectByVisibleText(company);
	}
	//	To set reference no.
	public void setRefNo (String consumerNo) 
	{
		refNo.clear();
		refNo.sendKeys(consumerNo);
	}
	//	To set Bill ID
	public void setBillId (String billId)
	{
		this.billerId.clear();
		this.billerId.sendKeys(billId);
	}

	//	Data Setter
	public void setData(String Company, String consumerNo)
	{
		setCompany(Company);
		setRefNo(consumerNo);
		btnFindBill.click();
	}
	
	// To verify the Page Title
	public void verifyPgTitle() 
	{
		Assert.assertTrue(pgTitle.getText().equalsIgnoreCase("Reverse Bill"));
	}
	



	// Constructor
	public ReverseBillPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	// To click Reverse button
	public void clickReverse() 
	{
		if (btnReverse.isEnabled())
			btnReverse.click();
		else
			Reporter.log("Reverse button is disabled.");
		
	}
}

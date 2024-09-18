package Bai26_ParallelExecutionPOM.Page;

import Drivers.DriverManager;
import Setup.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class CustomersPage {

    //Menu customer
    private By menuCustomers = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Customers']");
    private By buttonAddNew = By.xpath("//a[normalize-space()='New Customer']");
    private By headerCustomersPage = By.xpath("//div[@class='panel-body']//span[normalize-space()='Customers Summary']");
    private By inputSearch = By.xpath("//div[@class='input-group']//input[@type='search']");
    private By inputSearchCustomer = By.xpath("//div[@class='input-group']//input[@type='search']");

    private By dropdowProfile = By.xpath("//li[@class='icon header-user-profile']");
    private By logOut = By.xpath("(//a[@href='#'][normalize-space()='Logout'])[2]");

    //Add new customer
    public By inputCompany = By.xpath("//input[@id='company']");
    public By inputVat = By.xpath("//input[@id='vat']");
    public By inputPhonenumber = By.xpath("//input[@id='phonenumber']");
    public By inputWebsite = By.xpath("//input[@id='website']");
    public By btnGroups = By.xpath("//button[@data-id='groups_in[]']");
    public By inputSearchGroups = By.xpath("//div[@class='bs-searchbox']//input[@aria-controls='bs-select-1']");
    public By btnCurency = By.xpath("//button[@data-id='default_currency']");
    public By inputSearchCurency = By.xpath("//div[@class='dropdown-menu open']//input[@aria-controls='bs-select-2']");
    public By btnLanguage = By.xpath("//button[@data-id='default_language']");
    public By inputSearchLanguage = By.xpath("//span[normalize-space()='French']");
    public By inputAddress = By.xpath("//textarea[@id='address']");
    public By inputCity = By.xpath("//input[@id='city']");
    public By inputState = By.xpath("//input[@id='state']");
    public By inputZip = By.xpath("//input[@id='zip']");
    public By btnCountry = By.xpath("//button[@data-id='country']");
    public By inputSearchCountry = By.xpath("//div[@class='bs-searchbox']//input[@aria-controls='bs-select-4']");
    public By btnSaveAddCustomer = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");
    public By inputSearchCompany = By.xpath("//div[@class='input-group']//input");
    public By itemCustomerOnTable = By.xpath("//td[@class='sorting_1']/a");


    public void clickButtonNewCustomer() {
        WebUI.clickElement(buttonAddNew);
    }

    public void verifyCustomerPageSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerCustomersPage).isDisplayed(), "Khong tim thay header customerpage");
        Assert.assertEquals(WebUI.getElementText(headerCustomersPage), "Customers Summary", "Gia tri heder khong dung");
        WebUI.assertContains(WebUI.getElementText(headerCustomersPage), "Customers Summary", "Gia tri heder khong dung");
    }

    public void inputDataCustomer(String COMPANY) {
        WebUI.setText(inputCompany, COMPANY);
        WebUI.setText(inputVat, "Vat 01");
        WebUI.setText(inputPhonenumber, "0900123123");
        WebUI.setText(inputWebsite, "abc.com.vn");
        WebUI.clickElement(btnGroups);
        WebUI.setText(inputSearchGroups, "Gold");
        WebUI.sleep(1);
        //driver.findElement(inputSearchGroups).sendKeys(Keys.ENTER);
        WebUI.setKey(inputSearchGroups, Keys.ENTER);
        WebUI.clickElement(btnGroups);
        WebUI.setText(inputAddress, "Thanh Ha");
        WebUI.setText(inputCity, "Ha noi");
        WebUI.setText(inputState, "Ha noi 555");
        WebUI.setText(inputZip, "111111");
        WebUI.clickElement(btnCountry);
        WebUI.setText(inputSearchCountry, "Vietnam");
        WebUI.sleep(1);
        //driver.findElement(inputSearchCountry).sendKeys(Keys.ENTER);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
        WebUI.clickElement(btnSaveAddCustomer);

    }

    public ProfilePage searchCustomer(String COMPANY) {
        WebUI.clickElement(menuCustomers);
        WebUI.setText(inputSearchCompany, COMPANY);
        DriverManager.getDriver().findElement(inputSearchCompany).sendKeys(Keys.ENTER);
        WebUI.sleep(2);
        WebUI.clickElement(itemCustomerOnTable);

        return new ProfilePage();
    }


}

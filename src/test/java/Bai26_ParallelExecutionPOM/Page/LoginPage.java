package Bai26_ParallelExecutionPOM.Page;

import Drivers.DriverManager;
import Setup.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {

    private String url = "https://crm.anhtester.com/admin/authentication";


    //Khai bao tat ca cac object (element) tren page nay
    //Thuoc kieu doi tuong By (thuoc cua Selenium)

    By headerLogin = By.xpath("//h1[normalize-space()='Login']");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[@type='submit']");
    By errorrMess = By.xpath("//div[@class='text-center alert alert-danger']");

    By menuDashboard = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Dashboard']");


    // Xay dung cac ham xu ly
    private void setInputEmail(String email) {
        ;
        WebUI.setText(inputEmail, email);

    }

    private void setInputPassword(String password) {
        WebUI.setText(inputPassword, password);
    }

    private void clickButtonLogin() {
        WebUI.clickElement(buttonLogin);
    }


    public DashBoardPage LoginSuccessCRM(String email, String password) {
        //driver.get(url);
        WebUI.openURL(url);
        WebUI.waitForPageLoaded();
//        System.out.println("Navigate to URL: "+ url);
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();
        WebUI.waitForPageLoaded();
        return new DashBoardPage();
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(menuDashboard).isDisplayed(), "menu doasboard not display");
        System.out.println("Verifylogin Success");
    }

    public void verifyLoginFalse() {
        Assert.assertTrue(DriverManager.getDriver().findElement(errorrMess).isDisplayed(), "errorrMess not displayed");
        Assert.assertEquals(WebUI.getElementText(errorrMess), "Invalid email or password", "content of not errorrMess not match.");
        System.out.println("Verifylogin False");
    }

    public void verifyRedirectLogOut() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerLogin).isDisplayed(), "Not Redirect Login success");
        Assert.assertEquals(WebUI.getElementText(headerLogin), "Login", "content of header page not match.");
        System.out.println("Verify Redirect login true");
    }


}

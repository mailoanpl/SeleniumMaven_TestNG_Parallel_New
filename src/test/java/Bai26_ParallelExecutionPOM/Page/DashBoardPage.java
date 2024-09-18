package Bai26_ParallelExecutionPOM.Page;

import Setup.WebUI;
import org.openqa.selenium.By;

public class DashBoardPage {

    private By menuDashboard = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Dashboard']");
    private By menuCustomers = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Customers']");
    private By menuProjects = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Projects']");
    private By menuTasks = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Tasks']");
    private By dropdowProfile = By.xpath("//li[@class='icon header-user-profile']");
    private By logOut = By.xpath("(//a[@href='#'][normalize-space()='Logout'])[2]");


    public CustomersPage clickMenuCustomers() {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuCustomers);
        System.out.println("Click on menu Customers");

        return new CustomersPage();
    }

    public void clickMenProjects() {
        WebUI.clickElement(menuProjects);
        System.out.println("Click on menu Project");
    }

    public void clickMenuTasks() {
        WebUI.clickElement(menuTasks);
        System.out.println("Click on menu Task");
    }

    public LoginPage clickLogout() {
        WebUI.clickElement(dropdowProfile);
        System.out.println("Click on Profile");
        WebUI.sleep(1);
        WebUI.clickElement(logOut);
        System.out.println("Click logout");

        return new LoginPage();
    }


}

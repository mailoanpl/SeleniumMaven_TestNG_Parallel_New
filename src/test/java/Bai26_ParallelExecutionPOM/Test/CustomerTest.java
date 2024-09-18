package Bai26_ParallelExecutionPOM.Test;

import Bai26_ParallelExecutionPOM.Page.CustomersPage;
import Bai26_ParallelExecutionPOM.Page.DashBoardPage;
import Bai26_ParallelExecutionPOM.Page.LoginPage;
import Setup.WebUI;
import common.BaseTest;
import contants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    CustomersPage customersPage;

    private String CUSTOMER_NAME = "Company_12121122";

    @Test
    public void NewAddCustomer() {
        loginPage = new LoginPage();
        dashBoardPage = loginPage.LoginSuccessCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
        customersPage = dashBoardPage.clickMenuCustomers();
        customersPage.clickButtonNewCustomer();
        customersPage.inputDataCustomer(CUSTOMER_NAME);
        WebUI.sleep(2);
        customersPage.searchCustomer(CUSTOMER_NAME);
        WebUI.sleep(2);
        // customersPage.verifyCustomerDetail(CUSTOMER_NAME);

    }
}

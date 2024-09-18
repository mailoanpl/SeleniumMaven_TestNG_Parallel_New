package Bai26_ParallelExecutionPOM.Test;

import Bai26_ParallelExecutionPOM.Page.CustomersPage;
import Bai26_ParallelExecutionPOM.Page.DashBoardPage;
import Bai26_ParallelExecutionPOM.Page.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    DashBoardPage dashBoardPage;
    LoginPage loginPage;
    CustomersPage customersPage;

    @Test
    public void testOpenCustomerPage() {

        loginPage = new LoginPage();
        dashBoardPage = loginPage.LoginSuccessCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        customersPage = dashBoardPage.clickMenuCustomers();
        customersPage.verifyCustomerPageSuccess();

    }

    @Test
    public void testOpenProjectPage() {

    }

    @Test
    public void testLogout() {
        loginPage = new LoginPage();
        dashBoardPage = loginPage.LoginSuccessCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        loginPage = dashBoardPage.clickLogout();
        loginPage.verifyRedirectLogOut();
    }


}

package Bai26_ParallelExecutionPOM.Test;

import Bai26_ParallelExecutionPOM.Page.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success() {
        //Khoi tao doi tuong class Loginpage de truyen gia tri driver tu page test
        loginPage = new LoginPage();
        loginPage.LoginSuccessCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

    }

    @Test
    public void testLoginCRM_emailInvalid() {
        loginPage = new LoginPage();
        loginPage.LoginSuccessCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFalse();
    }

    @Test
    public void testLoginCRM_passInvalid() {
        loginPage = new LoginPage();
        loginPage.LoginSuccessCRM("admin@example.com", "12345678");
        loginPage.verifyLoginFalse();
    }
}

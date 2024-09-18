package Bai26_ParallelExecutionPOM.Page;

import Drivers.DriverManager;
import org.testng.Assert;

public class ProfilePage extends CustomersPage {


    public void verifyCustomerDetail(String COMPANY) {
        Assert.assertEquals(DriverManager.getDriver().findElement(inputCompany).getAttribute("value"), "Company_8888", "Message: not match company_name");
    }
}

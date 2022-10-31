package sauceDemoTest;

import com.BaseTest;
import org.testng.annotations.Test;
import pages.SauceDemo;

public class SauceDemoTest extends BaseTest {

    @Test(description = "Verification of Sauce Demo Cart functionality")
    public void sauceDemoCardAddCheck()
    {
        SauceDemo sauceDemo=new SauceDemo();
        sauceDemo.loginSauce("standard_user","secret_sauce");
        sauceDemo.addProductToCart("Sauce Labs Backpack");
        sauceDemo.addProductToCart("Sauce Labs Bike Light");
        sauceDemo.clickOnCart();
        sauceDemo.verifyProductOnCart("Sauce Labs Backpack");
        sauceDemo.verifyProductOnCart("Sauce Labs Bike Light");
        sauceDemo.clickOnCheckOut();
        sauceDemo.addAddressDetails("Binesh","Samineni","111111");
        sauceDemo.clickOnContinue();
        sauceDemo.verifyTotalPrice();
        sauceDemo.clickOnFinish();
        sauceDemo.verifyOrderConform();
    }
}

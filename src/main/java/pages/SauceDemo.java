package pages;

import com.BaseTest;
import com.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class SauceDemo extends BaseTest {

    public static By userName_txt=By.id("user-name");
    public static By password_txt=By.id("password");
    public static By login_btn=By.id("login-button");
    public static By addProduct=By.xpath("//div[text()='%s']/../../..//button[text()='Add to cart']");
    public static By cart_link=By.xpath("//a[@class='shopping_cart_link']");
    public static By verifyProductName=By.xpath("//div[@class='inventory_item_name'][text()='%s']");
    public static By checkout_btn=By.id("checkout");
    public static By firstName_txt=By.id("first-name");
    public static By lastName_txt=By.id("last-name");
    public static By postalCode_txt=By.id("postal-code");
    public static By continue_btn=By.id("continue");
    public static By itemsPrice_list=By.xpath("//div[@class='inventory_item_price']");
    public static By summaryPrice_lbl=By.xpath("//div[@class='summary_subtotal_label']");
    public static By finish_btn=By.id("finish");
    public static By conform_lbl=By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");



    public void loginSauce(String userName,String password)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName_txt));
        driver.findElement(userName_txt).sendKeys(userName);
        driver.findElement(password_txt).sendKeys(password);
        driver.findElement(login_btn).click();
    }

    public void addAddressDetails(String firstName,String lastName,String postalCode)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName_txt));
        driver.findElement(firstName_txt).sendKeys(firstName);
        driver.findElement(lastName_txt).sendKeys(lastName);
        driver.findElement(postalCode_txt).sendKeys(postalCode);

    }

    public void addProductToCart(String productName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Utility.getNewLocator(addProduct,productName)));
        driver.findElement(Utility.getNewLocator(addProduct,productName)).click();
    }
    public void verifyProductOnCart(String productName)
    {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Utility.getNewLocator(verifyProductName, productName)));
        }
        catch (Exception ignored)
        {
            System.out.println("ignored waited element for verification");
        }
        Assert.assertTrue(driver.findElement(Utility.getNewLocator(verifyProductName,productName)).isDisplayed(),"Product is not found");

    }

    public void verifyTotalPrice()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(summaryPrice_lbl));
        List<WebElement> itemPrices=driver.findElements(itemsPrice_list);
        double sum=0;
        for (WebElement ele:itemPrices
             ) {
            String item= ele.getText().replaceAll("\\$","");
            sum+=Double.parseDouble(item);
        }
        Assert.assertEquals(driver.findElement(summaryPrice_lbl).getText().replaceAll("Item total: \\$",""),String.valueOf(sum));
    }

    public void clickOnFinish()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(finish_btn));
        driver.findElement(finish_btn).click();
    }

    public void clickOnContinue()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continue_btn));
        driver.findElement(continue_btn).click();
    }

    public void clickOnCart()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cart_link));
        driver.findElement(cart_link).click();
    }

    public void clickOnCheckOut()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkout_btn));
        driver.findElement(checkout_btn).click();
    }

    public void verifyOrderConform()
    {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(conform_lbl));
        }
        catch (Exception ignored)
        {
            System.out.println("ignored waited element for verification");
        }
        Assert.assertTrue(driver.findElement(conform_lbl).isDisplayed(),"Order is not conformed");

    }


}

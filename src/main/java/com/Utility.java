package com;

import org.openqa.selenium.By;

public class Utility {

    private enum LocatorType {
        xpath, cssSelector, id, className,name,linkText,partialLinkText,tagName;
    }

    //Dynamic locator change
    public static By getNewLocator(By locator, String dynamicText)
    {
        //By.xpath("//div/a[@title='%s']");
        String locatorTypeS = locator.toString().split(": ")[0].split("\\.")[1];
        String newLocatorString = String.format(locator.toString().split(": ")[1],dynamicText);
        LocatorType locatorType= LocatorType.valueOf(locatorTypeS);
        switch(locatorType)
        {
            case xpath:
                locator = By.xpath(newLocatorString);
                break;
            case cssSelector:
                locator = By.cssSelector(newLocatorString);
                break;
            case id:
                locator = By.id(newLocatorString);
                break;
            case className:
                locator = By.className(newLocatorString);
                break;
            case name:
                locator = By.name(newLocatorString);
                break;
            case linkText:
                locator = By.linkText(newLocatorString);
                break;
            case partialLinkText:
                locator = By.partialLinkText(newLocatorString);
                break;
            case tagName:
                locator = By.tagName(newLocatorString);
                break;
        }
        return locator;
    }
}

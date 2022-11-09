package com.automationqa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.automationqa.BaseClass.driver;
import static com.automationqa.utilities.LocatorUtil.getLocator;

public class ElementUtil {
    public static WebElement getElement(String locatorName,String...args){
        return driver.findElement(By.xpath(getLocator(locatorName,args)));
    }

    public static List<WebElement> getElements(String locatorName, String...args){
        return driver.findElements(By.xpath(getLocator(locatorName,args)));
    }


}

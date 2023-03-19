package com.test_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.test_task.locators.CheckoutCompletePageLocators;

public class CheckoutCompletePage extends Page {

  @CacheLookup
  @FindBy(xpath = CheckoutCompletePageLocators.message)
  public WebElement message;

  public CheckoutCompletePage(WebDriver webDriver) {
    super(webDriver);
  }

}

package com.test_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends Page {

  @CacheLookup
  @FindBy(xpath = "//*[@id='checkout_complete_container']/h2")
  public WebElement message;

  public CheckoutCompletePage(WebDriver webDriver) {
    super(webDriver);
  }

}

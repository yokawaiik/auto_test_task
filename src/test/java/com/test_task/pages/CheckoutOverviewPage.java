package com.test_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.test_task.locators.CheckoutOverviewPageLocators;

public class CheckoutOverviewPage extends Page {

  @CacheLookup
  @FindBy(id = CheckoutOverviewPageLocators.finishButton)
  public WebElement finishButton;

  public CheckoutOverviewPage(WebDriver webDriver) {
    super(webDriver);
  }

  public void finishOrder() {
    finishButton.click();
  }

}

package com.test_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.test_task.constants.CheckoutCredentialConstants;

public class CheckoutInfoPage extends Page {

  @CacheLookup
  @FindBy(id = "first-name")
  public WebElement firstName;

  @CacheLookup
  @FindBy(id = "last-name")
  public WebElement lastName;

  @CacheLookup
  @FindBy(id = "postal-code")
  public WebElement zipCode;

  @CacheLookup
  @FindBy(id = "continue")
  public WebElement continueButton;

  public CheckoutInfoPage(WebDriver webDriver) {
    super(webDriver);
  }

  private void fillTheForm() {
    firstName.sendKeys(CheckoutCredentialConstants.firstName);
    lastName.sendKeys(CheckoutCredentialConstants.lastName);
    zipCode.sendKeys(CheckoutCredentialConstants.zipCode);
  }

  public void continueCheckout() {
    fillTheForm();
    continueButton.click();
  }

  public boolean isInfoDone() {
    return pageUrl != driver.getCurrentUrl();
  }

}

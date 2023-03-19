package com.test_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.test_task.constants.CheckoutCredentialConstants;
import com.test_task.locators.CheckoutInfoPageLocators;

import io.qameta.allure.Step;

public class CheckoutInfoPage extends Page {

  @CacheLookup
  @FindBy(id = CheckoutInfoPageLocators.firstNameElement)
  public WebElement firstName;

  @CacheLookup
  @FindBy(id = CheckoutInfoPageLocators.lastName)
  public WebElement lastName;

  @CacheLookup
  @FindBy(id = CheckoutInfoPageLocators.zipCode)
  public WebElement zipCode;

  @CacheLookup
  @FindBy(id = CheckoutInfoPageLocators.continueButton)
  public WebElement continueButton;

  public CheckoutInfoPage(WebDriver webDriver) {
    super(webDriver);
  }

  @Step("Fill in the form.")
  private void fillTheForm() {
    firstName.sendKeys(CheckoutCredentialConstants.firstName);
    lastName.sendKeys(CheckoutCredentialConstants.lastName);
    zipCode.sendKeys(CheckoutCredentialConstants.zipCode);
  }

  @Step("Press 'continue checkout'.")
  public void continueCheckout() {
    fillTheForm();
    continueButton.click();
  }

  public boolean isInfoDone() {
    return pageUrl != driver.getCurrentUrl();
  }

}

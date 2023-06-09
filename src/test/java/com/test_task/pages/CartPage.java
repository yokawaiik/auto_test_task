package com.test_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.test_task.locators.CartPageLocators;

import io.qameta.allure.Step;

public class CartPage extends Page {

  @CacheLookup
  @FindBy(id = CartPageLocators.checkOutButton)
  public WebElement checkOutButton;

  public CartPage(WebDriver webDriver) {
    super(webDriver);
  }

  @Step("Press 'checkout'.")
  public void checkOut() {
    checkOutButton.click();
  }

}

package com.test_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.test_task.locators.CartPageLocators;

public class CartPage extends Page {

  @CacheLookup
  // @FindBy(id = "checkout")
  @FindBy(id = CartPageLocators.checkOutButton)
  public WebElement checkOutButton;

  public CartPage(WebDriver webDriver) {
    super(webDriver);
  }

  public void checkOut() {
    checkOutButton.click();
  }

}

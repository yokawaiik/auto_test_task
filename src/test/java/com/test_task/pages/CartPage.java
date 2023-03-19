package com.test_task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Page {

  @CacheLookup
  @FindBy(id = "checkout")
  public WebElement checkOutButton;

  public CartPage(WebDriver webDriver) {
    super(webDriver);
  }

  public boolean isCartOpenned() {
    return "https://www.saucedemo.com/cart.html" != driver.getCurrentUrl();
  }

  public void checkOut() {
    checkOutButton.click();
  }

}

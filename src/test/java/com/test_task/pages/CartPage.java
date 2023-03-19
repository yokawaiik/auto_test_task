package com.test_task.pages;

import org.apache.hc.core5.util.Asserts;
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

  public void checkIfCartWasOpenned() {
    Asserts.check(pageUrl != driver.getCurrentUrl(), "Checkout wasn't done.");
  }

  public void checkOut() {
    checkOutButton.click();
  }

}

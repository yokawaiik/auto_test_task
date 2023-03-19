package com.test_task.pages;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test_task.constants.LoginCredentialConstants;

public class LoginPage extends Page {

  @FindBy(id = "user-name")
  public WebElement userName;

  @FindBy(id = "password")
  public WebElement password;

  @FindBy(xpath = "//input[@data-test='login-button']")
  public WebElement loginButton;

  public LoginPage(WebDriver webDriver) {
    super(webDriver);

  }

  public void login() {
    userName.sendKeys(LoginCredentialConstants.userName);
    password.sendKeys(LoginCredentialConstants.password);

    loginButton.click();
  }

  public void checkUserLoggedIn() {
    Asserts.check(pageUrl != driver.getCurrentUrl(), "User wasn't logged in.");
  }
}

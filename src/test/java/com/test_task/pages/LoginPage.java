package com.test_task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

  @FindBy(id = "user-name")
  public WebElement userNameInput;

  @FindBy(id = "password")
  public WebElement passwordInput;

  @FindBy(xpath = "//input[@data-test='login-button']")
  public WebElement loginButton;

  @FindBy(xpath = "//*[@class='error-message-container error']/h3[@data-test='error']")
  public WebElement errorMessageElement;

  public LoginPage(WebDriver webDriver) {
    super(webDriver);

  }

  public void login(String userName, String password) {
    userNameInput.sendKeys(userName);
    passwordInput.sendKeys(password);

    loginButton.click();
  }

  public boolean hasErrorMessageElement() {
    return isElementPresent(By.xpath("//*[@class='error-message-container error']/h3[@data-test='error']"));
  }
}

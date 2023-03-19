package com.test_task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test_task.locators.LoginPageLocators;

import io.qameta.allure.Step;

public class LoginPage extends Page {

  @FindBy(id = LoginPageLocators.userNameInput)
  public WebElement userNameInput;

  @FindBy(id = LoginPageLocators.passwordInput)
  public WebElement passwordInput;

  @FindBy(xpath = LoginPageLocators.loginButton)
  public WebElement loginButton;

  @FindBy(xpath = LoginPageLocators.errorMessageElement)
  public WebElement errorMessageElement;

  public LoginPage(WebDriver webDriver) {
    super(webDriver);

  }

  @Step("Sign in the site.")
  public void login(String userName, String password) {
    userNameInput.sendKeys(userName);
    passwordInput.sendKeys(password);

    loginButton.click();
  }

  public boolean hasErrorMessageElement() {
    return isElementPresent(By.xpath(LoginPageLocators.errorMessageElement));
  }
}

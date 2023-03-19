package com.test_task.tests;

import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.support.PageFactory;

import com.test_task.configuration.JUnitTestBase;
import com.test_task.constants.NonexistentLoginCredentialConstants;
import com.test_task.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;

@Epic("Nonexistent user test")
public class NonexistentUserTest extends JUnitTestBase {

  private LoginPage loginPage;

  @BeforeEach
  public void initPageObjects() {
    loginPage = PageFactory.initElements(driver, LoginPage.class);

  }

  @Test
  @Tag("TC#002")
  @DisplayName("Test Case #002: Check nonexistent user")
  @Story("User tries to login the system with nonexistent username and password for system.")
  @Description("Test Case #002: Check nonexistent user")
  public void unsuccessfulLogin() {
    driver.get(baseUrl);

    loginPage.login(NonexistentLoginCredentialConstants.userName, NonexistentLoginCredentialConstants.password);

    Asserts.check(
        loginPage.errorMessageElement.getText().toLowerCase()
            .equals("Epic sadface: Username and password do not match any user in this service".toLowerCase()),
        "The user was not supposed to be logged in.");
  }
}

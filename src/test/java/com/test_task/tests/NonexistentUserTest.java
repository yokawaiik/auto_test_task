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

public class NonexistentUserTest extends JUnitTestBase {

  private LoginPage loginPage;

  @BeforeEach
  public void initPageObjects() {
    loginPage = PageFactory.initElements(driver, LoginPage.class);

  }

  @DisplayName("Test Case #002: Check nonexistent user")
  @Tag("TC#002")
  @Test
  public void succesfful() {
    driver.get(baseUrl);

    loginPage.login(NonexistentLoginCredentialConstants.userName, NonexistentLoginCredentialConstants.password);

    Asserts.check(
        loginPage.errorMessageElement.getText().toLowerCase()
            .equals("Epic sadface: Username and password do not match any user in this service".toLowerCase()),
        "The user was not supposed to be logged in.");
  }
}

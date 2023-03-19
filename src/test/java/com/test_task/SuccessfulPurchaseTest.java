package com.test_task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.support.PageFactory;

import com.test_task.pages.CartPage;
import com.test_task.pages.CheckoutCompletePage;
import com.test_task.pages.CheckoutInfoPage;
import com.test_task.pages.CheckoutOverviewPage;
import com.test_task.pages.InventoryPage;
import com.test_task.pages.LoginPage;

public class SuccessfulPurchaseTest extends JUnitTestBase {

  private LoginPage loginPage;
  private InventoryPage inventoryPage;
  private CartPage cartPage;
  private CheckoutInfoPage checkoutInfoPage;
  private CheckoutOverviewPage checkoutOverviewPage;
  private CheckoutCompletePage checkoutCompletePage;

  @BeforeEach
  public void initPageObjects() {
    loginPage = PageFactory.initElements(driver, LoginPage.class);
    inventoryPage = PageFactory.initElements(driver, InventoryPage.class);
    cartPage = PageFactory.initElements(driver, CartPage.class);
    checkoutInfoPage = PageFactory.initElements(driver, CheckoutInfoPage.class);
    checkoutOverviewPage = PageFactory.initElements(driver, CheckoutOverviewPage.class);
    checkoutCompletePage = PageFactory.initElements(driver, CheckoutCompletePage.class);
  }

  @DisplayName("Test Case #001: Check Successful Purchase")
  @Test
  public void succesfful() {
    driver.get(baseUrl);

    loginPage.login();
    loginPage.checkUserLoggedIn();

    inventoryPage.getProducts();
    inventoryPage.putFirstProductToCart();
    inventoryPage.checkIfCartNotEmpty();
    inventoryPage.openCart();
    inventoryPage.checkIfCartWasOpenned();

    cartPage.checkOut();

    checkoutInfoPage.continueCheckout();
    checkoutInfoPage.checkCheckoutInfoWasDone();

    checkoutOverviewPage.finishOrder();

    checkoutCompletePage.checkOrderComplete();

  }
}

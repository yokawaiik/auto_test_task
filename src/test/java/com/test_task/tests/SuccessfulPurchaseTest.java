package com.test_task.tests;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import com.test_task.configuration.JUnitTestBase;
import com.test_task.constants.LoginCredentialConstants;
import com.test_task.constants.UrlConstants;
import com.test_task.pages.CartPage;
import com.test_task.pages.CheckoutCompletePage;
import com.test_task.pages.CheckoutInfoPage;
import com.test_task.pages.CheckoutOverviewPage;
import com.test_task.pages.InventoryPage;
import com.test_task.pages.LoginPage;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("Test Case #001: Check Successful Purchase")
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


  @Test
  @Tag("TC#001")
  @DisplayName("Test Case #001: Check Successful Purchase")
  @Story("User signs in, put product to cart, does order and finishes it.")
  @Description("Test Case #001: Check Successful Purchase")
  public void succesfful() {
    Allure.step("Open the site.");
    driver.get(baseUrl);

    loginPage.login(LoginCredentialConstants.userName, LoginCredentialConstants.password);

    Asserts.check(
        loginPage.hasErrorMessageElement() == false,
        "The user was not supposed to be logged in.");

    inventoryPage.getProducts();
    inventoryPage.putFirstProductToCart();

    Asserts.check(inventoryPage.isCartEmpty() == false, "Cart is empty.");

    Asserts.check(inventoryPage.productsInCart.size() == Integer.parseInt(inventoryPage.shoppingCartBadge.getText()),
        "Cart doesn't contain the all added products.");

    inventoryPage.openCart();

    Asserts.check(driver.getCurrentUrl().equals(UrlConstants.cart), "Cart wasn't oppened.");

    cartPage.checkOut();

    checkoutInfoPage.continueCheckout();
    Asserts.check(checkoutInfoPage.isInfoDone(), "Checkout info wasn't done.");

    checkoutOverviewPage.finishOrder();
    assertAll("Order wasn't complete.",
        () -> driver.getCurrentUrl().contains(UrlConstants.checkoutComplete),
        () -> checkoutCompletePage.message.getText().toLowerCase().contains("Thank you for your order".toLowerCase()));

  }
}

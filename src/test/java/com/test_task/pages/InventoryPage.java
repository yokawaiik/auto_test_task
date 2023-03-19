package com.test_task.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends Page {

  @CacheLookup
  @FindBy(id = "shopping_cart_container")
  public WebElement cartButton;


  
  @FindBy(className = "shopping_cart_badge")
  public WebElement shoppingCartBadge;

  public List<WebElement> products;

  public ArrayList<WebElement> productsInCart;

  public InventoryPage(WebDriver webDriver) {
    super(webDriver);

    productsInCart = new ArrayList<WebElement>();
  }

  // if async
  public void getProducts() {

    products = driver.findElements(By.cssSelector("div[class='inventory_item']"));

  }

  public void putFirstProductToCart() {

    final WebElement firstProduct = products.get(0);

    final WebElement addToCartButton = firstProduct.findElement(By.cssSelector("button"));

    addToCartButton.click();

    productsInCart.add(firstProduct);

  }

  public boolean isCartEmpty() {

    if (!isElementPresent(By.className("shopping_cart_badge"))) {
      return true;
    } else {
      return false;
    }
  }

  public void openCart() {
    cartButton.click();
  }

}

package com.qa.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class taskFourPage extends TestBase {
	
//	OBJECTModels for task4 ------ S1
	@FindBy(xpath = "//a[normalize-space()='Login or register']")
	private WebElement loginManueButton;

	public void clickManueButton() {
		loginManueButton.click();
	}

	@FindBy(xpath = "//input[@id='loginFrm_loginname']")
	private WebElement usernameInput_task4;

	@FindBy(xpath = "//input[@id='loginFrm_password']")
	private WebElement passwordInput_task4;

	public void enterUsername_task4(String username) {
		usernameInput_task4.sendKeys(username);
	}

	public void enterPassword_task4(String password) {
		passwordInput_task4.sendKeys(password);
	}

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement login_task4;

	public void clickLoginButton_task4() {
		login_task4.click();
	}

	@FindBy(xpath = "//a[contains(@class, 'menu_home')]")
	private WebElement Home_button;

	public void clickHomeButton_task4() {
		Home_button.click();
	}

	@FindBy(xpath = "//img[@alt='Dove']")
	private WebElement BrandNameButton;

	public void clickBrandNameButton_task4() {
		BrandNameButton.click();
	}

	@FindBy(id = "sort")
    private WebElement dropdownElement;

    public void selectOptionFromDropdown(String optionText) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);
    }
	
    @FindBy(xpath = "(//i[@class='fa fa-cart-plus fa-fw'])[1]")
	private WebElement addToCart;

	public void clickAddtoCart() {
		addToCart.click();
	}
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']//i[@class='fa fa-shopping-cart fa-fw']")
	private WebElement cart;

	public void gotTocart() {
		cart.click();
	}
	

//  S2
    
  @FindBy(xpath = "(//a[contains(text(),'Apparel & accessories')])[2]")
	private WebElement apparals;

	public void gotToapparals() {
		apparals.click();
	}
	
	@FindBy(xpath = "//a[normalize-space()='T-shirts']")
	private WebElement tshirt;

	public void goToTshirtSection() {
		tshirt.click();
	}
	@FindBy(xpath = "//div[6]//div[2]//div[3]//a[1]//i[1]")
	private WebElement goToCartShirt;

	public void clickGoAddtoCartShirt() {
		goToCartShirt.click();
	}
	
	@FindBy(xpath = "//a[normalize-space()='Add to Cart']")
	private WebElement addToCartShirt;

	public void clickAddtoCartShirt() {
		addToCartShirt.click();
	}
	
	@FindBy(xpath = "//a[normalize-space()='Shoes']")
	private WebElement shoesSection;

	public void clicktoShoes() {
		shoesSection.click();
	}
	
	@FindBy(xpath = "//div[@class='contentpanel']//div[1]//div[2]//div[3]//a[1]//i[1]")
	private WebElement goToCartShoes;

	public void clickGoToCartshoes() {
		goToCartShoes.click();
	}
	
	
	@FindBy(xpath = "//input[@id='product_quantity']")
	private WebElement quntity;

	public void enterQuntity() {
		quntity.clear();
		quntity.sendKeys("2");
	}
	
//	initializing the page objects
	public taskFourPage() {
		PageFactory.initElements(driver, this);
	}
	
	
//	Actions
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	// Check if the item is displayed in the cart
    public boolean isCartItemDisplayed() {
        try {
            WebElement cartItem = driver.findElement(By.xpath("//td[@class='align_center']//a//img"));
            return cartItem.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
 // Get the amount for the item in the cart
    public String getCartItemAmount() {
        WebElement amountElement = driver.findElement(By.xpath("(//td[@class='align_right'][normalize-space()='$6.70'])[2]"));
        return amountElement.getText();
    }

    // Get the quantity for the item in the cart
    public String getCartItemQuantity() {
        WebElement quantityElement = driver.findElement(By.xpath("//input[@id='cart_quantity75']"));
        return quantityElement.getAttribute("value");
    }
	
}

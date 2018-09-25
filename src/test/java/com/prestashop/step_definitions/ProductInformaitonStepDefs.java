package com.prestashop.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Random;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ItemPage;
import com.prestashop.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.ast.DataTable;

public class ProductInformaitonStepDefs {

	HomePage homePage = new HomePage();

	@When("the user selects Printed Summer Dress")
	public void the_user_selects_Printed_Summer_Dress() {
		homePage.item("Printed Summer Dress").click();
	}

	@Then("product information page should be displayed")
	public void product_information_page_should_be_displayed() {
		String actual = Driver.getDriver().getTitle();
		String expected = "Printed Summer Dress";

		assertTrue(actual.contains(expected));

	}

	@Then("product name should be Printed Summer Dress")
	public void product_name_should_be_Printed_Summer_Dress() {
		ItemPage itemPage = new ItemPage();
		assertEquals("Printed Summer Dress", itemPage.itemName.getText());
	}

	@Then("correct default count size should be displayed")
	public void correct_default_count_size_should_be_displayed() {
		ItemPage itemPage = new ItemPage();
		assertEquals("1", itemPage.count.getAttribute("value"));
		assertEquals("S", itemPage.size().getFirstSelectedOption().getText());
	}

	@When("the user selects {string}")
	public void the_user_selects(String item) {
		homePage.item(item).click();
	}

	@Then("product page title should contain {string}")
	public void product_page_title_should_contain(String item) {
		assertTrue(Driver.getDriver().getTitle().contains(item));
	}

	@Then("product name should be {string}")
	public void product_name_should_be(String item) {
		ItemPage itemPage = new ItemPage();
		String actual = itemPage.itemName.getText();
		assertEquals(item, actual);
	}

	@Then("correct default count should be {int}")
	public void correct_default_count_should_be(Integer count) {
		ItemPage itemPage = new ItemPage();
		assertEquals(count + "", itemPage.count.getAttribute("value"));

	}

	@Then("the user should be able to toggle the count")
	public void the_user_should_be_able_to_toggle_the_count() {
		ItemPage itemPage = new ItemPage();
		int number = new Random().nextInt(49) + 2;
		
		for (int i = 0; i <= number; i++) {
			itemPage.plus.click();
			assertEquals(i + 2 + "", itemPage.count.getAttribute("value"));
		}

		for (int i = number; i >= 0; i--) {
			itemPage.minus.click();
			assertEquals(i + 1 + "", itemPage.count.getAttribute("value"));
		}
		
		itemPage.minus.click();
		assertEquals("1", itemPage.count.getAttribute("value"));

	}
	
	@Then("the system should display the product information:")
	public void the_system_should_display_the_product_information(Map<String, String> product) {
		System.out.println(product);
		
		ItemPage itemPage = new ItemPage();
		
		String expectedName = product.get("name");
		System.out.println("Product name: "+expectedName);
		assertEquals(expectedName, itemPage.itemName.getText());
		
		String expectedPrice = product.get("price");
		System.out.println("Product price: "+expectedPrice);
		assertEquals(expectedPrice, itemPage.price.getText());
		
		String expectedSize = product.get("size");
		System.out.println("Product size: "+expectedSize);
		assertEquals(expectedSize, itemPage.size().getFirstSelectedOption().getText());
		
		String expectedCondition = product.get("condition");
		System.out.println("Product condition: "+expectedCondition);
		assertEquals(expectedCondition, itemPage.condition.getText());
		
		String expectedCount= product.get("count");
		System.out.println("Product count: "+expectedCount);
		assertEquals(expectedCount, itemPage.count.getAttribute("value"));
		
		
	}
	
	@Then("the price should be {string}")
	public void the_price_should_be(String expectedPrice) {
	    String actualPrice = new ItemPage().price.getText();
		assertEquals(expectedPrice, actualPrice);
	}


}








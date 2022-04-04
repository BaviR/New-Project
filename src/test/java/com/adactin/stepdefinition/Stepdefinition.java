package com.adactin.stepdefinition;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.WebDriver;
import com.adactin.BaseClass;
import com.adactin.config.Page_Object_Manager;
import com.adactin.runner.Runner;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Stepdefinition extends BaseClass {

	public static WebDriver driver = Runner.driver;

	Page_Object_Manager pom = new Page_Object_Manager(driver);

	@Given("User launch the hotel booking application")
	public void user_launch_the_hotel_booking_application() {
		System.out.println("User successfully launch the application");
	}

	@When("User enter the valid username and password")
	public void user_enter_the_valid_username_and_password(DataTable datas) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<String> row = datas.row(0);
		inputValue(pom.getInstanceLogin().getUsername(), row.get(0));
		inputValue(pom.getInstanceLogin().getPassword(), row.get(1));
	}

	@When("User enter the valid {string} and {string}")
	public void user_enter_the_valid_and(String string, String string2) {
		inputValue(pom.getInstanceLogin().getUsername(), string);
		inputValue(pom.getInstanceLogin().getPassword(), string2);
	}

	@When("User click the login button")
	public void user_click_the_login_button() {
		click(pom.getInstanceLogin().getLogin());
	}

	@Then("User validate the username and password then navigates to the homepage")
	public void user_validate_the_username_and_password_then_navigates_to_the_homepage() {
		assertTrue(driver.getCurrentUrl().endsWith("com/SearchHotel.php"));
		System.out.println("User login the application");
	}

}

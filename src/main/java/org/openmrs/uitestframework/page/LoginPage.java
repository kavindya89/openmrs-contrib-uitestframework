package org.openmrs.uitestframework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractBasePage {
	
	static final String USERNAME_TEXTBOX_ID = "username";
	static final String PASSWORD_TEXTBOX_ID = "password";
	static final String LOGIN_BUTTON_ID = "login-button";
	public static final String LOGIN_PATH = "/login.htm";
    public static final String UNKOWN_LOCATION_ELEMENT_ID = "Registration Desk";
	static final String LOGOUT_PATH = "/logout";
	
	private String UserName;
	
	private String Password;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		UserName = properties.getUserName();
		Password = properties.getPassword();
	}
	
	public void login(String user, String password) {
		setTextToField(By.id(USERNAME_TEXTBOX_ID), user);
		setTextToField(By.id(PASSWORD_TEXTBOX_ID), password);
        clickOn(By.id(UNKOWN_LOCATION_ELEMENT_ID));	// TODO, not sure this belongs here because Mirebalais doesn't use it?, or at least make it optional? 
		clickOn(By.id(LOGIN_BUTTON_ID));
		findElement(byFromHref(URL_ROOT + LOGOUT_PATH));	// this waits until the Logoff link is present
	}
	
	public void loginAsAdmin() {
		login(UserName, Password);
	}
	
	@Override
	public String expectedUrlPath() {
		return URL_ROOT + LOGIN_PATH;
	}
}

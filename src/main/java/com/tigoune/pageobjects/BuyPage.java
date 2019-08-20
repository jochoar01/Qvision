package com.tigoune.pageobjects;

import java.awt.AWTException;


import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import com.tigoune.util.ActionOnImages;
import com.tigoune.util.InitialConfig;
import com.tigoune.util.LogicUtil;

public class BuyPage extends InitialConfig {

	static final By SIGN_IN_BUTTON = By.className("login");
	static final By EMAIL_ADDRESS = By.id("email");
	static final By PASSWORD = By.id("passwd");
	static final By SUBMIT_LOGIN = By.id("SubmitLogin");
	static final By DRESSES_BUTTON = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	static final By ADD_TO_CAR_BUTTON = By.name("Submit");
	static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]");
	static final By PROCEED_TO_CHECKOUT_BUTTON_STEP1 = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]");
	static final By PROCEED_TO_CHECKOUT_BUTTON_STEP2 = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]");
	static final By TERMS = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/p[2]/div[1]/span[1]/input[1]");
	static final By PROCEED_TO_CHECKOUT_BUTTON_STEP3 = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]");
	static final By PAY_ORDER  = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/p[1]/a[1]");
	static final By CONFIRM_ORDER  = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]");
	static final By BEFORE_SCREENSHOT  = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]");
	static final By EMAIL_INPUT  = By.id("identifierId");
	static final By NEXT_BUTTON  = By.id("identifierNext");
	static final By INIT_SESSION = By.xpath("/html/body/section/div/div/div[2]/a[2]");
	static final By MEGAN_MAIL = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/input[1]");
	static final By TYPE_MAIL_NEXT = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/input[1]");
	static final By MEGAN_PWD = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]");
	static final By TYPE_PWD_NEXT = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/input[1]");
	static final By NEW_MAIL_BUTTON =By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/div[1]/div[1]");
	static final By MAIL_ADDRESS = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	static final By MAIL_SUBJECT = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/input[1]");
	static final By SEND_BUTTON =By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/button[1]/div[1]");
	static final By PWD_INPUT  = By.name("password");
	static final By ADJ_BUTTON =By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/div[1]/div[1]");
	static final By ADJ_BUTTON2 =By.xpath("/html[1]/body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]/div[1]");
	static final By ADJ_IMAGE =By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]/div[1]/img[1]");
	
	static final By PWD_NEXT_BUTTON  = By.id("passwordNext");
	
	static final String INICIAL_XPATH_FRONT = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[";
	static final String DRESSES_PRICE_BACK = "]/div[1]/div[2]/div[1]/span[1]";	
	static final String BUY_BACK = "]/div[1]/div[1]/div[1]/a[1]/span[1]";	
	static final String HREF_BACK = "]/div[1]/div[2]/h5[1]/a[1]";
	private static final By AFTER_SEND = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]");
	public static String filepath = "src/test/resources/images";
	
	
	
	static LogicUtil logicUtil;

	public static void LoginBuy() {

		webBroserConfig("chrome", "http://automationpractice.com/index.php");
		click(SIGN_IN_BUTTON);
		type(EMAIL_ADDRESS, "jochoar01@gmail.com");
		type(PASSWORD, "12345678");
		click(SUBMIT_LOGIN);

	}

	public static void searchDress() {

		click(DRESSES_BUTTON);
		int[] priceArray = new int[6];
		for (int i = 0; i < 6; i++) {
			try {

				priceArray[i] = Integer.parseInt(
						getTextByXpath(INICIAL_XPATH_FRONT + i + DRESSES_PRICE_BACK).replace("$", "").replace(".", ""));

			} catch (Exception e) {

			}

		}

		int compare = LogicUtil.Expensive(priceArray);
		for (int i = 0; i < priceArray.length; i++) {
			try {

				if (compare == Integer.parseInt(getTextByXpath(INICIAL_XPATH_FRONT + i + DRESSES_PRICE_BACK)
						.replace("$", "").replace(".", ""))) {

					openUrl(getAttributeXpath(INICIAL_XPATH_FRONT + i + HREF_BACK));

				}

			} catch (Exception e) {
			
			}

		}

		
	}

	public static void expensiveDress() throws Exception {
		
			click(ADD_TO_CAR_BUTTON);
			Thread.sleep(3000);
			click(PROCEED_TO_CHECKOUT_BUTTON);			
			click(PROCEED_TO_CHECKOUT_BUTTON_STEP1);
			click(PROCEED_TO_CHECKOUT_BUTTON_STEP2);
			click(TERMS);
			click(PROCEED_TO_CHECKOUT_BUTTON_STEP3);
			click(PAY_ORDER);
			click(CONFIRM_ORDER);	
			scroll();
			LogicUtil.screenshot("c:/expensiveDressVoucher");
			openUrl("http://www.hotmail.com");
			click(INIT_SESSION);
			type(MEGAN_MAIL,"megan19851@outlook.es");
			click(TYPE_MAIL_NEXT);
			waitForElement(MEGAN_PWD, 3000);
			type(MEGAN_PWD,"Meganwannakillyou23");
			click(TYPE_PWD_NEXT);
			waitForElement(NEW_MAIL_BUTTON, 3000);
			click(NEW_MAIL_BUTTON);
			waitForElement(MAIL_ADDRESS, 3000);
			type(MAIL_ADDRESS,"dzapata@qvision.us");				
			type(MAIL_SUBJECT,"Voucher Dress");
			click(ADJ_BUTTON);
			click(ADJ_BUTTON2);
			
			ActionOnImages.clickImage("CDESKTOP", filepath);
			ActionOnImages.type("disc");
			ActionOnImages.writeEnterKey();
			ActionOnImages.clickImage("PROGRAM_FILES.png", filepath);
			ActionOnImages.type("expensive");
			ActionOnImages.writeEnterKey();	
			waitForElement(ADJ_IMAGE, 3000);
			click(SEND_BUTTON);
			waitForElement(AFTER_SEND, 3000);
			closeBrowser();
			
	}
	
	
	
	
	



}

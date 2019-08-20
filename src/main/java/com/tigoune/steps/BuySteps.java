package com.tigoune.steps;

import org.fluentlenium.core.annotation.Page;

import com.tigoune.pageobjects.BuyPage;
import com.tigoune.util.InitialConfig;

import net.thucydides.core.annotations.Step;

public class BuySteps extends InitialConfig {
	@Page
	private static BuyPage buyPage;

	static InitialConfig initialConfig = new InitialConfig();

	@Step
	public static void openBrowserAndLogin() throws Exception {
		
		BuyPage.LoginBuy();

	}

	
	
	@Step

	public static void searchDress() {
		BuyPage.searchDress();
		
		
		
	}
	@Step
	public static void buyDress() throws Exception {
		BuyPage.expensiveDress();
		
	}

}

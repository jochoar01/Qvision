package com.tigoune.definitions;

import com.tigoune.steps.LoginSteps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Steps;
import org.sikuli.script.FindFailed;


public class Hooks {

    @Steps
    LoginSteps loginsteps;

    @Before("@newClient")
    public void beforeScenario() throws InterruptedException, FindFailed {

    }
    @After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
    }
}
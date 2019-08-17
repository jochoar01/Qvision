package com.tigoune.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = "src/test/resources/features/Siebel/Forms/customerRegister.feature", tags = "@newClient", plugin = {"pretty"},
        glue = {"com.tigoune.definitions"})

public class Runner2NewClient {
}



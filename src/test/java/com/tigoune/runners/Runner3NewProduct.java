package com.tigoune.runners;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Siebel/Forms/createProduct.feature", tags = "@newProduct", plugin = {"pretty"},
        glue = {"com.tigoune.definitions"})

public class Runner3NewProduct {
}

package edu.pe.cibertec.shopping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class SearchProductScreen {

    public static final Target SEARCH_INPUT = Target.the("search input field")
            .located(AppiumBy.className("android.widget.EditText"));
    public static final Target PRODUCT_NAME = Target.the("product name")
            .locatedBy("//android.widget.TextView[contains(@text,'{0}')]");
}


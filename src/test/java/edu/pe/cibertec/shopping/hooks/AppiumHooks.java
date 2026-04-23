package edu.pe.cibertec.shopping.hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.webdriver.WebDriverFacade;
import net.thucydides.core.webdriver.WebDriverFactory;

import java.time.Duration;

public class AppiumHooks {

    private static AndroidDriver driver;

    @Before
    public void setup() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName("emulator-5554")
                .setAppPackage("edu.pe.cibertec.shooping_cart_appium_demo")
                .setAppActivity("edu.pe.cibertec.shooping_cart_appium_demo.MainActivity")
                .setNoReset(false)
                .setNewCommandTimeout(Duration.ofSeconds(120));

        driver = new AndroidDriver(options);

        OnStage.setTheStage(Cast.whereEveryoneCan(actor -> actor.whoCan(
                BrowseTheWeb.with(driver)
        )));

        /*
        // Inicializar correctamente el escenario
        OnStage.setTheStage(new net.serenitybdd.screenplay.actors.OnlineCast());

        //Crear actor y darle habilidad
        OnStage.theActorCalled("Andrea").can(BrowseTheWeb.with(driver));
        */
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
        OnStage.drawTheCurtain();
    }

    //public  static Actor AndroidDriver;

    public static AndroidDriver getDriver(){
        return driver;
    }

}

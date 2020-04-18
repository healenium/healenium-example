package com.epam.sha.selenium;


import com.epam.healenium.SelfHealingDriver;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import config.BackendContainer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.security.auth.login.Configuration;
import java.util.concurrent.TimeUnit;

@Testcontainers
public class BaseTest {
    static protected SelfHealingDriver driver;

    @Container
    public static BackendContainer container = BackendContainer.getInstance();


    @BeforeAll
    static public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        //declare delegate
        Config config = ConfigFactory.load("healenium.properties");
        //create self-healing driver
        WebDriver delegate = new ChromeDriver(options);
        driver = SelfHealingDriver.create(delegate,config);

//        driver = SelfHealingDriver.create(delegate);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1200, 800));
    }

    @AfterAll
    static public void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }
}

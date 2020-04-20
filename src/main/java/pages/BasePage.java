package pages;


import com.epam.healenium.SelfHealingDriver;

public class BasePage {
    protected String mainPageUrl = "http://project1618618.tilda.ws/";
    protected SelfHealingDriver driver;

    public BasePage(SelfHealingDriver driver) {
        this.driver = driver;
    }
}

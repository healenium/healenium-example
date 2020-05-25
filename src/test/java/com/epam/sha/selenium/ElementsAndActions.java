package com.epam.sha.selenium;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.AjaxLoadPage;
import pages.MainPageWithFindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ElementsAndActions extends BaseTest {

    @Test
    @Disabled("It don't work. waitForLoadingSpinnerToDisappear - exception")
    public void testWaitForJsElementToDisappear() {
        AjaxLoadPage mainPage = new AjaxLoadPage(driver);
        //  Click on `Send Request` button
        mainPage.open().click();
        //  Check that spinner is displayed
        assertTrue( mainPage.isLoadingSpinnerDisplayed(),"Spinner is not displayed");
        //  Wait for spinner to disappear
        mainPage.waitForLoadingSpinnerToDisappear();
        //  Check that spinner is not displayed
        assertTrue(mainPage.isLoadingContentDisplayed(),"Content loaded is not displayed");
    }

    @Test
    public void testHover() {
        /*
        Checking a bug: https://github.com/healenium/healenium-web/issues/30
         */
        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver).open();
        mainPage.hoverOnTestButton();
        String class_of_element = mainPage.getAttributeFromTestButton("class");
        assertTrue(class_of_element.contains("button_hovered"),
                "In the class not indicated that on the button hovered a cursor");
    }

    @Test
    public void testNotHealWhenUseInvisibilityOf() {
        /*
        Checking a bug: https://github.com/healenium/healenium-web/issues/31
         */
        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver).open();
        mainPage.clickButtonForInvisible();
        assertTrue(mainPage.checkThatButtonInvisible(),
                "The error while checking the invisibility of the element");
    }

    @Test
    public void testFindElementWithinParent() {
        /*
        Checking the bug: https://github.com/healenium/healenium-web/issues/43
         */
        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver).open();
        String text = mainPage.takeValueFromSecondButton();
        assertTrue(text.equalsIgnoreCase("Second"),
                "The text doesn't match with the expected result");
    }

}

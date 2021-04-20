package e2e.page;

import e2e.utilities.BrowserUtils;
import e2e.utilities.ConfigurationReader;
import e2e.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class Challenge {

   WebDriver driver= Driver.get();

   public Challenge(){
       PageFactory.initElements(driver,this);
   }

    @FindBy (xpath = "//span[text()=\"Render the Challenge\"]")
    public WebElement renderTheChallenge;

   @FindBy(css = "h1")
   public WebElement welcomeText;

   @FindBy(xpath = "//tbody/tr[1]/td")
   public List<WebElement> firstRow;

   @FindBy(xpath = "//tbody/tr[2]/td")
   public List<WebElement> secondRow;

   @FindBy(xpath = "//tbody/tr[3]/td")
   public List<WebElement> thirdRow;

   @FindBy(xpath = "//section[@id=\"challenge\"]/div/div/div[2]/div/div/div/input")
   public List<WebElement> submitChallenges;

   @FindBy(xpath = "//section[@id=\"challenge\"]/div/div/div[2]/div/div[2]/button")
   public WebElement submitButton;

   @FindBy(xpath = "//span[text()=\"Close\"]")
   public WebElement closealertScreen;



   public void verifyLandingPage(){
       String expectedText= "Welcome to the ECSDigital Engineer in Test tech test";
       String actualText= welcomeText.getText();

       Assert.assertEquals(expectedText,actualText);
       renderTheChallenge.click();
       BrowserUtils.waitFor(2);
   }






    public void submitChallenges(){
       int firstChallenge=BrowserUtils.centerIndex(BrowserUtils.numberArrays(firstRow));
        System.out.println("First index: "+ firstChallenge);
        submitChallenges.get(0).sendKeys(String.valueOf(firstChallenge));

        int secondChallenge= BrowserUtils.centerIndex(BrowserUtils.numberArrays(secondRow));
        System.out.println("Second Index: "+secondChallenge);
        submitChallenges.get(1).sendKeys(String.valueOf(secondChallenge));

        int thirdChallenge= BrowserUtils.centerIndex(BrowserUtils.numberArrays(thirdRow));
        System.out.println("Third Index: "+thirdChallenge);
        submitChallenges.get(2).sendKeys(String.valueOf(thirdChallenge));

    }

    public void inputNameAndClickSubmit(){
       submitChallenges.get(3).sendKeys(ConfigurationReader.get("name"));
       BrowserUtils.scrollToElement(submitButton);

       BrowserUtils.waitFor(2);
       submitButton.click();
       BrowserUtils.waitFor(2);
        closealertScreen.click();
       BrowserUtils.waitFor(1);
    }




}

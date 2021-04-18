package runInMainMethod;

import e2e.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class ArrayChallenge {

    static WebDriver driver;
    public  static void  driver(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();

    }
    static List<WebElement> submitChallenges;

    public static void main(String[] args) {
        driver();
        navigateAndVerifyLandingPage();
        submitChallenges();
        inputNameAndClickSubmit();
        driver.close();

    }

    public static void navigateAndVerifyLandingPage(){
       driver.get("http://localhost:3000/");
        String expectedText= "Welcome to the ECSDigital Engineer in Test tech test";
        WebElement welcomeText= driver.findElement(By.cssSelector("h1"));
        String actualText = welcomeText.getText();
        Assert.assertEquals(expectedText,actualText);

        WebElement renderTheChallenge= driver.findElement(By.xpath("//span[text()=\"Render the Challenge\"]"));
        renderTheChallenge.click();
        waitFor(1);
    }


    public static void  submitChallenges(){
       submitChallenges =driver.findElements(By.xpath("//section[@id=\"challenge\"]/div/div/div[2]/div/div/div/input"));
        List<WebElement> firstRow= driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int firstChallenge= BrowserUtils.centerIndex(BrowserUtils.numberArrays(firstRow));
        System.out.println("First index: "+ firstChallenge);
        submitChallenges.get(0).sendKeys(String.valueOf(firstChallenge));

        List<WebElement> secondRow= driver.findElements(By.xpath("//tbody/tr[2]/td"));
        int secondChallenge= BrowserUtils.centerIndex(BrowserUtils.numberArrays(secondRow));
        System.out.println("Second Index: "+secondChallenge);
        submitChallenges.get(1).sendKeys(String.valueOf(secondChallenge));

        List<WebElement> thirdRow= driver.findElements(By.xpath("//tbody/tr[3]/td"));
        int thirdChallenge= BrowserUtils.centerIndex(BrowserUtils.numberArrays(thirdRow));
        System.out.println("Third Index: "+thirdChallenge);
        submitChallenges.get(2).sendKeys(String.valueOf(thirdChallenge));
    }
    public static void inputNameAndClickSubmit(){

        submitChallenges.get(3).sendKeys("Ufuk Sahinduran");
        waitFor(1);
        WebElement submitButton=
                driver.findElement(By.xpath("//section[@id=\"challenge\"]/div/div/div[2]/div/div[2]/button"));
        submitButton.click();
        waitFor(3);
    }





    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static Integer centerIndex(int[] numbers) {

        Integer center = 0;


        for (int i = 0; i < numbers.length; i++) {
            center = numbers[i];
            int left = 0;
            int right = 0;
            for (int j = 0; j < numbers.length; j++) {


                if (j < i) {
                    left += numbers[j];
                } else if (j > i) {
                    right += numbers[j];
                } else {
                    continue;
                }
            }

            if (left == right) {
                System.out.println("left: " + left);
                System.out.println("Right: " + right);
                System.out.println("Center number is: " + center);
                System.out.println("###########");
                center = i;
                break;
            }
        }


        if (center == numbers.length-1) {
            return null;
        } else {
            return center;
        }

    }


    public static int[] numberArrays(List<WebElement> numbers){
        int size = numbers.size();

        int[] numberArray =new int[size];

        for (int i = 0; i <size ; i++) {
            numberArray[i]=Integer.parseInt(numbers.get(i).getText());
        }

        return numberArray;
    }



}

package e2e.utilities;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class BrowserUtils {

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
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
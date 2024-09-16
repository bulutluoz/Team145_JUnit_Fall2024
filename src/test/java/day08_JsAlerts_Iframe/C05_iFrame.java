package day08_JsAlerts_Iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_iFrame extends TestBase_Each {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        ReusableMethods.bekle(1);
        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        // ulasmak istedigimiz elementin iframe icinde oldugunu gorduk
        // once iframe'i locate edip, iframe'e gecis yapmaliyiz

        WebElement electronicsIFrame =
                driver.findElement(By.xpath("(//iframe[@frameborder='1'])[1]"));

        driver.switchTo().frame(electronicsIFrame);

        ReusableMethods.bekle(1);
        WebElement electronicsProductYaziElementi =
                driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assertions.assertTrue(electronicsProductYaziElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        WebElement dellIsimElementi =
                driver.findElement(By.xpath("//span[text()='DELL Core I3 11th Gen ']"));

        String expectedDellUrunIsim = "DELL Core I3 11th Gen";
        String actualDellUrunIsim = dellIsimElementi.getText();

        Assertions.assertEquals(expectedDellUrunIsim,actualDellUrunIsim);

        //4- Sagdaki bolumde gorunen urunler arasinda
        //   ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin
        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin
        //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin

        ReusableMethods.bekle(3);
    }
}

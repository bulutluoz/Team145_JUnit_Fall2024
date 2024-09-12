package day06_jUnitFramework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_BeforeVeAfterNotasyonlari {

    /*
            1- JUnit test method'larini kafasina gore calistirir
               Hangi test method'unun once calisacagini ONGOREMEYIZ
               ve KONTROL EDEMEYIZ
            2- Eger sira bizim icin onemli ise
               test method'larinin isimlerini
               method01, method02,... seklinde verirsek
               bu siralamaya uygun calistirir
            3- test01'de anasayfaya gidip url testini yaptiktan sonra driver'i kapatirsak
               test02 calistiginda phone icin ARAMA YAPAMAZ
            4- Bu tur birbirine bagimli test method'lari oldugunda
               en basta setup calismali, tum test method'lari calisip[ bittikten sonra
               teardown devreye girmeli
            5- JUnit bu modeli @BeforeAll ve @AfterAll ile gerceklestirir
               ANCAKKK bu notasyonlari kullanan method'larin
               MECBUREN static olmasi gerekir


     */

    // 3 farkli test method'u olusturun ve asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidin ve url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapin ve arama sonucunda urun bulunabildigini test edin
    // 3- bulunan urunlerden ilkini tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan phone gectigini test edin

    static WebDriver driver;
    @BeforeAll // her test method'undan once calis
    public static void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/path/to/your/custom/profile");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll // her test method'undan sonra calis
    public static void teardown(){
        ReusableMethods.bekle(2);
        driver.quit();
    }


    @Test
    public void test01(){
        // anaSayfaUrltesti
    }

    @Test
    public void test02(){
        // phoneAramaTesti
    }

    @Test
    public void test03(){
        // urunIsimTesti
    }

}

package com.example.swagger.glue;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MainPageTest {
    private final String url = "https://petstore3.swagger.io";
    private WebDriver driver;

    @Before
    public void setUp(){
        System.out.println("SetUp");
        //levantar el browser : chrome
        System.setProperty("webdriver.chrome.driver","/Users/HUMBERTO/IdeaProjects/Swagger/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //maximiza la pantalla
    }
    @Given("abro la pagina PetStore")
    public void abroLaPaginaPetStore() throws InterruptedException {
        driver.get(url); //navegar hacia la URL
        System.out.println("Title: " + driver.getTitle());
        Thread.sleep(5000);
    }

    @And("presiono boton findByStatus")
    public void presionoBotonFindByStatus() throws InterruptedException {
        WebElement findByStatus = this.driver.findElement(By.xpath("//div[@id='operations-pet-findPetsByStatus']"));
        findByStatus.click();
            Thread.sleep(5000);
        }

    @And("presiono boton tryinout")
    public void presionoBotonTryinout() throws InterruptedException {
        WebElement tryinout = this.driver.findElement(By.xpath("//*[@id=\"operations-pet-findPetsByStatus\"]/div[2]/div/div[2]/div[1]/div[2]"));
        tryinout.click();
        Thread.sleep(5000);
    }
    @And("presiono boton execute")
    public void presionoBotonExecute() throws InterruptedException {
        WebElement execute = this.driver.findElement(By.xpath("//div[@id='operations-pet-findPetsByStatus']//following::div[@class='execute-wrapper']"));
        execute.click();
        Thread.sleep(5000);
    }
    @Then("valido que el codigo de respuesta sea {int}")
    public void validoQueElCodigoDeRespuestaSea(int statusCode) {
        WebElement code = this.driver.findElement(By.xpath("//*[@id=\"operations-pet-findPetsByStatus\"]/div[2]/div/div[4]/div[2]/div/div/table/tbody/tr/td[1]"));
                String codigo =code.getText();
                int codigo2 = Integer.parseInt(codigo);
        Assert.assertEquals(statusCode, codigo2);
    }


}

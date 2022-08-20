package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RuncucumberTest;

public class Cadastro {

    WebDriver driver = new ChromeDriver();

   @Dado("^que estou no site informado")
        public void acessar_site_informado (){
            driver.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");

    }

    @Quando("^fazer um filtro")
        public void fazerumfiltro(){

            driver.findElement(By.cssSelector("#switch-version-select > option:nth-child(4)")).click();
    }
    @E("^cadastrar novo membro")
        public void cadastrarnovomembro(){
            driver.findElement(By.cssSelector("#gcrud-search-form > div.header-tools > div.floatL.t5 > a")).click();
            driver.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
            driver.findElement(By.id("field-contactLastName")).sendKeys("Teste");
            driver.findElement(By.id("field-contactFirstName")).sendKeys("Ailton Junior");
            driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
            driver.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
            driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
            driver.findElement(By.id("field-city")).sendKeys("Porto Alegre");
            driver.findElement(By.id("field-state")).sendKeys("RS");
            driver.findElement(By.id("field-postalCode")).sendKeys("91000-000");
            driver.findElement(By.id("field-country")).sendKeys("Brasil");
            driver.findElement(By.id("field-salesRepEmployeeNumber")).sendKeys("Fixter");
            driver.findElement(By.id("field-creditLimit")).sendKeys("200");
            driver.findElement(By.cssSelector("#form-button-save")).click();
    }
    @Entao("^devo verificar a mensagem de confirmacao")
            public void devoverificarmensagemdeconfimarcao() {
            Assert.assertEquals(true, driver.findElement(By.id("report-success")).isEnabled());
    }
    @E("^fechar o navegador$")
        public void fecharONavegador() {
            driver.quit();
   }
}

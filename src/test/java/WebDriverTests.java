import config.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTests {

  private WebDriver driver;

  @BeforeEach
  public void startDriver() {
    driver = new WebDriverProvider().get();
  }

  @Test
  public void testsGithub() {
    // Подготовка Driver.
    WebDriverManager.chromedriver().setup();
    // тело выполнения теста.
    driver.get("https://github.com");
    String title = driver.getTitle();
    assertEquals("GitHub · Change is constant. GitHub keeps you ahead. · GitHub", title);
    driver.quit();
  }


  @AfterEach
  public void stopDriver() {

    if (driver != null) {
      driver.quit();
    }

    driver.quit();
  }
}
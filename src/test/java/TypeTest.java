import config.TypeConfig;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static config.Browser.FIREFOX;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TypeTest {

  @Test
  public void testInteger() {
    System.setProperty("integer", "10");

    TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
    assertThat(config.getInteger()).isEqualTo(10);
  }

  @Test
  public void testDouble() {
    System.setProperty("double", "10.10");

    TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
    assertThat(config.getDouble()).isEqualTo(10.10);
  }

  @Test
  public void testBoolean() {
    System.setProperty("boolean", "true");

    TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
    assertThat(config.getBoolean()).isEqualTo(true);
  }

  @Test
  public void testEnum() {
    System.setProperty("enum", "FIREFOX");

    TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
    assertThat(config.getEnum()).isEqualTo(FIREFOX);
  }

  // Обязательно использовать MalformedURLException для URL
  @Test
  public void testUrl() throws MalformedURLException {
    System.setProperty("Url", "https://github.com");

    TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
    assertThat(config.getUrl()).isEqualTo(new URL("https://github.com"));
  }

//  @Test
// public void testPath() {
//    System.setProperty("Path", "src/test/resources/test.txt");
//
//    TypeConfig config =
//            ConfigFactory.create(TypeConfig.class, System.getProperties());
//
//    assertThat(config.getPath())
//            .isEqualTo(Path.of("src/test/resources/test.txt"));
//}

  @Test
  public void testFile() {
    System.setProperty("File", "src/test/resources/test.txt");

    TypeConfig config =
      ConfigFactory.create(TypeConfig.class, System.getProperties());

    assertThat(config.getFile())
      .isEqualTo(new File("src/test/resources/test.txt"));
  }

}

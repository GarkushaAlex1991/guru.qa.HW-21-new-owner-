package web;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class  HwTest implements Config {

  @Test
  public void localTest() {
    System.setProperty("type", "local");
    WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    assertThat(config.getBrowserName()).isEqualTo("chrome");
    assertThat(config.getBrowserVersion()).isEqualTo("150");
    assertThat(config.isRemote()).isFalse();
  }

  @Test
  public void remoteTest() throws MalformedURLException {
    System.setProperty("type", "remote");
    WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    assertThat(config.getBrowserName()).isEqualTo("chrome");
    assertThat(config.getBrowserVersion()).isEqualTo("100");
    assertThat(config.isRemote()).isTrue();
    assertThat(config.getRemoteUrl()).isEqualTo(new URL("http://localhost:4444/wd/hub"));
  }

}

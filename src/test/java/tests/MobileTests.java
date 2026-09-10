package tests;

import config.MobileConfig;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Config.Sources({
  "classpath:${device}.properties",
})

public class MobileTests {

  @Test
  public void testMobile() {
    System.setProperty("device", "mobile");

    MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

    assertThat(config.getDeviceName()).isEqualTo("iPhone 18");
    assertThat(config.getPlatformName()).isEqualTo("IOS");
    assertThat(config.getPlatformVersion()).isEqualTo("12");
  }

  @Test
  public void testMobileWithAndroid() {
    System.setProperty("device", "google-pixel");

    MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

    assertThat(config.getDeviceName()).isEqualTo("Google pixel");
    assertThat(config.getPlatformName()).isEqualTo("ANDROID");
    assertThat(config.getPlatformVersion()).isEqualTo("24");
  }

  @Test
  public void testMobileWithIPhone() {
    System.setProperty("device", "iphone-13");

    MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

    assertThat(config.getDeviceName()).isEqualTo("iPhone 13 Pro max Super Man");
    assertThat(config.getPlatformName()).isEqualTo("IOS");
    assertThat(config.getPlatformVersion()).isEqualTo("13");
  }
}

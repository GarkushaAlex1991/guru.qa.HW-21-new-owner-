package web;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({
  "classpath:${type}.properties"
})

public interface WebConfig extends Config {

  @Key("browser.name")
  String getBrowserName();

  @Key("browser.version")
  String getBrowserVersion();

  @Key("remote")
  boolean isRemote();

  @Key("remoteUrl")
  URL getRemoteUrl();
}

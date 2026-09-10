package config;

import org.aeonbits.owner.Config;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;

// Проверить FILE, URL, Path, byte[]
public interface TypeConfig extends Config {

  @Key("integer")
  Integer getInteger();

  @Key("double")
  Double getDouble();

  @Key("boolean")
  Boolean getBoolean();

  @Key("enum")
  Browser getEnum();

  @Key("Url")
  URL getUrl();

  @Key("Path")
  Path getPath();

  @Key("File")
  File getFile();

  @Key("Byte")
  Byte getByte();

}


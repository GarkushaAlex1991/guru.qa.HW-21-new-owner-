package tests;

import config.FruitsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// проверить дома - list + возвращаемый тип.
public class FruitsTest {

  @Test
  public void testArray() {
    System.setProperty("array", "banana, apple");

    FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());

    assertThat(config.getFruitsArray())
      .containsExactly("banana", "apple");
  }

  @Test
  public void testList() {
    System.setProperty("list", "apple, orange");

    FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());

    assertThat(config.getFruitsList())
      .containsExactly("apple", "orange");
  }
}

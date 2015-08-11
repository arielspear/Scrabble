import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {


  @Test
  public void scrabbleScore_returnsAScrabbleScoreForALetter_1() {
    App testApp = new App();
    Integer score = 1;
    assertEquals(score, testApp.scrabbleScore("a"));
  }
}

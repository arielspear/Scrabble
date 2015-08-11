import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {


  @Test
  public void scrabbleScore_returnsAScrabbleScoreForALetter_1() {
    Integer score = 1;
    assertEquals(score, App.scrabbleScore("a"));
  }

  @Test
  public void scrabbleScore_returnsAScrabbleScoreForAWord_8() {
    Integer score = 8;
    assertEquals(score, App.scrabbleScore("hand"));
  }

}

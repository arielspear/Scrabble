import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.ArrayList;
import static spark.Spark.*;
import java.util.Arrays;
import java.util.List;


public class App {
  public static void main(String[] args) {
    String layout = "/templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "/templates/home.vtl");

      return new ModelAndView(model, "/templates/home.vtl");
    }, new VelocityTemplateEngine());

    get("/score", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "/templates/score.vtl");

      String word = request.queryParams("word");
      Integer score = scrabbleScore(word);

      model.put("userWord", word);
      model.put("wordScore", score);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

  public static Integer scrabbleScore(String word) {

    String[] wordArray = word.split("");
    Integer score = 0;
    String onePoint = "aeioulnrst";
    String twoPoints = "dg";
    String threePoints = "bcmp";
    String fourPoints = "fhvwy";
    String fivePoints = "k";
    String eightPoints = "jx";
    String tenPoints = "qz";



    for (String letter : wordArray ) {

      if (onePoint.contains(letter)) {
        score = score + 1;
      } else if (twoPoints.contains(letter)) {
          score = score + 2;
        } else if (threePoints.contains(letter)) {
          score = score + 3;
        } else if (fourPoints.contains(letter)) {
          score = score + 4;
        } else if (fivePoints.contains(letter)) {
          score = score + 5;
        } else if (eightPoints.contains(letter)) {
          score = score + 8;
        } else if (tenPoints.contains(letter)) {
          score = score + 10;
        } else {
          System.out.println("That's not a scrabble word");
        }

    }

      return score;
  }

}

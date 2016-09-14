import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/rectangle", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int length = Integer.parseInt(request.queryParams("side-one"));
      int width =  Integer.parseInt(request.queryParams("side-two"));

      Rectangle rectangle = new Rectangle( length, width);
      model.put("rectangle", rectangle);

      if (rectangle.isSquare()) {
        Cube cube = new Cube(rectangle);
        model.put("cube", cube);
      }

      model.put("template", "templates/rectangle.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}












//     Console console = System.console();
//
//     System.out.println("Enter one side length");
//     int sideOne = Integer.parseInt(console.readLine());
//
//     System.out.println("Enter another side length");
//     int sideTwo = Integer.parseInt(console.readLine());
//
//     Rectangle rectangle = new Rectangle(sideOne,sideTwo);
//
//     System.out.println("Is your rectangle a square. too?" + rectangle.isSquare());
//   }
// }

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);


        //Dispalys the homepage
        get("/", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }), new HandlebarsTemplateEngine());

        //Displays Endangered form
        get("/endangered/new", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "endangered-form.hbs");
        }), new HandlebarsTemplateEngine());

        //Saves endangered form data
        post("/endangered/new", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String health = request.queryParams("health");
            EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal(name,age,health);
            newEndangeredAnimal.save();
            response.redirect("/");

            return null;

        }), new HandlebarsTemplateEngine());

        //Displays endangered species
        get("/endangered", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<EndangeredAnimal> endangeredAnimals = EndangeredAnimal.all();
            model.put("endangeredAnimals", endangeredAnimals);
            return new ModelAndView(model, "endangered-list.hbs");
        }), new HandlebarsTemplateEngine());

        //Displays non-endangered form
        get("/non-endangered/new", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "non-endangered-form.hbs");
        }), new HandlebarsTemplateEngine());

        //Saves non-endangered form data
        post("/non-endangered/new", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");

            NonEndangeredAnimal newNonEndangeredAnimal = new NonEndangeredAnimal(name,age);
            newNonEndangeredAnimal.save();
            response.redirect("/");

            return null;

        }), new HandlebarsTemplateEngine());

        //Displays non-endangered animals
        get("/non-endangered", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<NonEndangeredAnimal> nonEndangeredAnimals = NonEndangeredAnimal.all();
            model.put("nonEndangeredAnimals", nonEndangeredAnimals);
            return new ModelAndView(model, "view-nonEndangered.hbs");
        }), new HandlebarsTemplateEngine());

        //Displays Sighting Form
        get("/sighting/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<NonEndangeredAnimal> nonEndangeredAnimals = NonEndangeredAnimal.all();
            List<EndangeredAnimal> endangeredAnimals = EndangeredAnimal.all();
            List<Object> animals = new ArrayList<Object>();
            for (int i=0;i<nonEndangeredAnimals.size();i++){
                animals.add(NonEndangeredAnimal.all().get(i));
            }
            for (int i=0;i<endangeredAnimals.size();i++){
                animals.add(EndangeredAnimal.all().get(i));
            }

            model.put("animals",animals );
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //Saves sightings
        post("/sighting/new", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String rangerName = request.queryParams("rangerName");
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            String location = request.queryParams("location");
            try {
                Sighting sighting = new Sighting(rangerName,animalId,location);
                sighting.save();
            } catch (IllegalArgumentException exception) {
                System.out.println("Please fill in all input fields.");
            }
            response.redirect("/");

            return null;

        }), new HandlebarsTemplateEngine());

        //Display sightings
        get("/sightings", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightings =Sighting.all();
            model.put("Animal", Animal.class);
            model.put("sightings", sightings);
            return new ModelAndView(model, "sighting-view.hbs");
        }), new HandlebarsTemplateEngine());

        //Delete Sighting
        get("/sightings/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Sighting.find(Integer.parseInt(request.params(":id"))).delete();
            response.redirect("/sightings");

            return null;
        }, new HandlebarsTemplateEngine());




    }
}

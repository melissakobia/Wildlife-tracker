import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;


public class EndangeredAnimal extends Animal {

    private String health;
    public static final String[] healthArray = {"healthy", "ill", "okay"};
    public static final String DATABASE_TYPE = "endangered";



    public EndangeredAnimal(String name) {
        this.name = name;
        health = healthArray[0];
        age = ageArray[0];
        type = DATABASE_TYPE;

    }

    public String getHealth() {
        return health;
    }

   public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type='endangered';";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(EndangeredAnimal.class);

        }
   }

   public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id = :id;";

            EndangeredAnimal animal = con.createQuery(sql).addParameter("id", id).throwOnMappingFailure(false).executeAndFetchFirst(EndangeredAnimal.class);
            return animal;

        }

   }


}

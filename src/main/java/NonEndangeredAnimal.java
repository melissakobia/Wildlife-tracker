
import java.util.List;
import org.sql2o.*;

public class NonEndangeredAnimal extends Animal{
    public static final String DATABASE_TYPE = "non-endangered";


    public NonEndangeredAnimal(String name) {
        this.name = name;

        age = ageArray[0];
        type = DATABASE_TYPE;
    }

    public static List<NonEndangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type='non-endangered' ";
        try (Connection con =DB.sql2o.open()) {
            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(NonEndangeredAnimal.class);

        }
    }

    public static NonEndangeredAnimal find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE id = :id;";
            NonEndangeredAnimal animal = con.createQuery(sql).addParameter("id", id).throwOnMappingFailure(false).executeAndFetchFirst(NonEndangeredAnimal.class);
            return animal;
        }
    }



}

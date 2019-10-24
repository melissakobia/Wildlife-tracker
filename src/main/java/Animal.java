
import java.util.Objects;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Animal {
    public String name;
    public int id;
    public String age;
    public static final String[] ageArray = {"newborn", "young", "adult"};
    public String type;

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(getName(), animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, age, type) VALUES (:name, :age, :type)";
            this.id = (int) con.createQuery(sql, true).addParameter("name", this.name)
                    .addParameter("age", this.age).addParameter("type", this.type).executeUpdate().getKey();
        }
    }

//    public static List<Animal> all() {
//        String sql = "SELECT * FROM animals;";
//        try (Connection con = DB.sql2o.open()) {
//            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(Animal.class);
//
//        }
//    }

    public static Animal find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id = :id;";
            Animal animal = con.createQuery(sql).addParameter("id", id).throwOnMappingFailure(false).executeAndFetchFirst(Animal.class);
            return animal;

        }
    }





}

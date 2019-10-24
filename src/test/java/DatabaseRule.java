import org.junit.rules.ExternalResource;
import org.sql2o.*;
public class DatabaseRule extends ExternalResource  {
    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "sonnie", "DBpassword");  //Those with linux or windows use two strings for username and password
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalsQuery = "DELETE FROM animals";
            con.createQuery(deleteAnimalsQuery).executeUpdate();

            String deleteSightingsQuery = "DELETE FROM sightings";
            con.createQuery(deleteSightingsQuery).executeUpdate();


        }
    }
}

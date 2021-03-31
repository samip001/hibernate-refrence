import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {

    public static void main(String[] args) {
        String jdbc="jdbc:mysql://localhost:3306/hb_test?useSSL=false";
        String user="root";
        String password="";

        try {
            System.out.println("Connecting to database: "+ jdbc);

            Connection conn = DriverManager.getConnection(jdbc, user, password);

            System.out.println("Connection Started Successfulyy: "+conn);
        }
        catch(Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}

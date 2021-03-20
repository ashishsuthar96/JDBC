import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement st = con.createStatement();
            String sql =  "CREATE TABLE   REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            st.executeUpdate(sql);
            System.out.println("Created table in given database...");
            con.close();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

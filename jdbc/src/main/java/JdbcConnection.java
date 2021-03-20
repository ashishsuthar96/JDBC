import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnection {
    public static void main(String[] args)  throws Exception {
        Connection con=null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("org.h2.Driver");
             con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
             st = con.createStatement();
             rs= st.executeQuery("select * from CUSTOMER");
            while (rs.next()){
                String name = rs.getString("NAME");
                int age = rs.getInt("AGE");
                System.out.println(name+","+age);
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            rs.close();
            st.close();
            con.close();
        }
    }
}

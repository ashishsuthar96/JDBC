import java.sql.*;

public class TableUpdate {
    public static void main(String[] args) {
            try{
                Class.forName("org.h2.Driver");
                Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
                String sql = "INSERT INTO CUSTOMER " + "VALUES (?,?, ?, ?,?)";
                PreparedStatement st = con.prepareStatement(sql); //create prepared statment
                st.setInt(1,9);
                st.setString(2,"ashish");
                //To-Do
                st.executeUpdate(sql);
                ResultSet rs = st.executeQuery("select * from CUSTOMER");
                while (rs.next()){
                    String name = rs.getString("name");
                    int id = rs.getInt("id");
                    int age = rs.getInt("age");
                    String address = rs.getString("address");
                    int salary = rs.getInt("salary");
                    System.out.println(name+","+ id+","+age+","+address+","+salary);
                }
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
}

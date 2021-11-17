import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author sqlitetutorial.net
 */
public class SqliteConnect {
    /**
     * Connect to a sample database
     * @return
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/Users/mac/Dropbox/DHQB/Java/Tiem Vacine/Vacination/vacine.db";
            //jdbc:mysql://localhost:3306/database_name
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void insertPerson(Person person) {
        String sql = "INSERT INTO Person(Name,Birthday,QR_Code,Security_Number,Identifer_Number,Address) VALUES(?,?,?,?,?,?)";
        try {
            Connection conn = SqliteConnect.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, person.name);
            pstmt.setString(2, person.birthday);
            pstmt.setString(3, person.qrCode);
            pstmt.setString(4, person.securityNumber);
            pstmt.setString(5, person.identifierNumber);
            pstmt.setString(6, person.address);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Person> search(String searchItem) {
        String sql = "Select * from Person where Name like ?";
        try {
            Connection conn = SqliteConnect.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%" + searchItem + "%");
            ResultSet resultSet = pstmt.executeQuery();
            ArrayList<Person> personList = new ArrayList<Person>();
            while (resultSet.next()){
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String birthday = resultSet.getString("Birthday");
                String address = resultSet.getString("Address");
                Person person = new Person(id,name,birthday,"","","",address);
                personList.add(person);
            }
            return personList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }


}

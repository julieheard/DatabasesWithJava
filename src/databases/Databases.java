package databases;

import java.sql.*;

public class Databases {

    public static void main(String[] args) {
//        GUISingle gui2 = new GUISingle();
//        gui2.setVisible(true);
//        
//        GUITable gui = new GUITable();
//        gui.setVisible(true);

        
        
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/OrdersDatabase", "julie", "password");

            Statement stmt = con.createStatement();

            //Generate primary key
            String SQL = "Select MAX(CustomerID) as maxID from TBL_Customers";
            ResultSet rs = stmt.executeQuery(SQL); 

            rs.next();
            int id = rs.getInt("maxID")+1;
            
           //insert a record - Commented out just so Roshan doesn't get lots of record entries
            SQL = "insert into TBL_Customers Values ("+id+", 'Roshan', 'Roshan@Roshan.com')";
            stmt.executeUpdate(SQL);
            
            //prints out all customers in TBLcustomer
            SQL = "SELECT * FROM TBL_CUSTOMERS";
            rs = stmt.executeQuery(SQL); 
            
            while (rs.next()) {
                int Custid = rs.getInt("CustomerID");
                String fieldName = rs.getString("CustomerName");
                System.out.println(Custid + " " + fieldName);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}



import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Update {
        public static void main(String args[]){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","mukul");
                String sql1="select user_name from user_data where no_of_books=0";
                PreparedStatement ps=con.prepareStatement(sql1);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    ps=con.prepareStatement("insert into user_books(user_name,book1,book2,book3) values(?,?,?,?)");
                    ps.setString(1,rs.getString("user_name"));
                    ps.setString(2,"-");
                    ps.setString(3,"-");
                    ps.setString(4,"-");
                    int i=ps.executeUpdate();
                }
            }catch(Exception e){System.out.println(e);}
        }
}

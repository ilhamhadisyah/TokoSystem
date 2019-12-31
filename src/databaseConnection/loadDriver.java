package databaseConnection;

import javax.swing.*;

import java.sql.*;

public class loadDriver {

    java.sql.Connection con = null;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    PreparedStatement pps;
    String temp;
    String namaTemp, nimTemp, emailTemp, TTLTemp, alamatTemp, noHPTemp, JKTemp, passWordTemp, semesterTemp;



    public void connect(){ // database connection (needed in any conection)

        try {
            //String url ="jdbc:mysql://www.db4free.net:3306/hadisyah";
            //String user ="ilhamhadisyah";
            //String password = "qwertyuiop123";
            String url = "jdbc:mysql://localhost:3306/apotik_db";
            String user ="user1";
            String password = "1234";

            con = DriverManager.getConnection(url,user,password); // database
            System.out.println("connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean access(String No_faktur) throws SQLException {// used to login sesion and return boolean data type
        try {
            connect();


            pps = con.prepareStatement("select No_faktur from brg_in where No_faktur = ? ");
            pps.setString(1,No_faktur);

            rs= pps.executeQuery();
            System.out.println(rs.first());
            System.out.println(rs.getString(2));

        } catch (SQLException e) {
            System.out.println("error :"+e.getMessage());
        }
        return rs.first();
    }
}

package databaseConnection;


import java.sql.*;
import java.util.Date;

public class loadDriver {

    java.sql.Connection con = null;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    PreparedStatement pps;
    String temp;
    String namaTemp, nimTemp, emailTemp, TTLTemp, alamatTemp, noHPTemp, JKTemp, passWordTemp, semesterTemp;

    Date date= new Date();



    public void connect(){ // database connection (needed in any conection)

        try {
            //String url ="jdbc:mysql://www.db4free.net:3306/hadisyah";
            //String user ="ilhamhadisyah";
            //String password = "qwertyuiop123";
            String url = "jdbc:mysql://localhost:3306/apotik";
            String user ="user1";
            String password = "1234";

            con = DriverManager.getConnection(url,user,password); // database
            System.out.println("connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addItem() {// used to login sesion and return boolean data type

        String namaBarang="paracetzmol";
        String suplier="viva";
        String noFaktur="3334";
        Object jatuhTempo= new Timestamp(date.getTime());
        String harga=  "12";
        String disc="2";
        String noBatch= "2ddd"  ;
        Object expDate=new Timestamp(date.getTime());
        String jumlahBarang = "10";
        try {
            connect();
            pps = con.prepareStatement("INSERT INTO brg_in (suplier, no_faktur,jatuh_tempo,nama_barang,jml_barang,harga,disc,No_batch,exp_date) " +
                    "VALUES ('"+suplier+"',"+noFaktur+",'"+jatuhTempo+"','"+namaBarang+"',"+jumlahBarang+","+harga+","+disc+","+noBatch+",'"+expDate+"');");
            pps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error :"+e.getMessage());
        }
    }

    public void retrieveData() throws SQLException {
        connect();
        pps = con.prepareStatement("SELECT * FROM brg_in");
        rs = pps.executeQuery();

        while (rs.next()){
            String namaBarang= rs.getString("nama_barang");
            String suplier=rs.getString("suplier");
            String noFaktur=rs.getString("no_faktur");
            Object jatuhTempo= rs.getDate("jatuh_tempo");
            int harga=  rs.getInt("harga");
            int disc=rs.getInt("disc");
            String noBatch= rs.getString("No_batch");
            Object expDate=rs.getDate("exp_date");
            int jumlahBarang = rs.getInt("jml_barang");

            System.out.println(namaBarang+suplier+noFaktur+jatuhTempo.toString()+harga+disc+noBatch+expDate.toString()+jumlahBarang);
        }
    }
}

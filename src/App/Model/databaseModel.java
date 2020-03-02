package App.Model;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class databaseModel {
    static public String namaItem = "panadol";
    static public String distributorAsal = "kimia farma";
    static public String jenisSediaan = "kapsul";
    static public String noFaktur = "sahdvhbj";
    static public String noBatch = "hiasdvgas";
    static public int jumlahBarang = 12;
    static public int hargaSatuan = 12000;
    static public int diskon = 10;
    static public int totalHarga = jumlahBarang * hargaSatuan;
    static public String kodeBarang = "bsadhuv";
    static public LocalDate tglFaktur = LocalDate.now();
    static public LocalDate expDate = LocalDate.now();
    static public LocalDate jatuhTempo = LocalDate.now();
}

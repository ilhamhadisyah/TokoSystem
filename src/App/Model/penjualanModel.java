package App.Model;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class penjualanModel {
    private SimpleStringProperty idBarang;
    private SimpleStringProperty namaBarang;
    private SimpleIntegerProperty hargabarang;
    private SimpleIntegerProperty stok;


    public penjualanModel(String fName, String lName, int harga, int stok) {
        this.idBarang = new SimpleStringProperty(fName);
        this.namaBarang = new SimpleStringProperty(lName);
        this.hargabarang = new SimpleIntegerProperty(harga);
        this.stok = new SimpleIntegerProperty(stok);

    }

    public String getIdBarang() {
        return idBarang.get();
    }

    public void setIdBarang(String a) {
        this.idBarang.set(a);
    }

    public String getNamaBarang() {
        return namaBarang.get();
    }

    public void setNamaBarang(String b) {
        this.namaBarang.set(b);
    }

    public int getHargabarang() {
        return hargabarang.get();
    }

    public void setHargabarang(int hargabarang) {
        this.hargabarang.set(hargabarang);
    }

    public int getStok() {
        return stok.get();
    }

    public void setStok(int stok) {
        this.stok.set(stok);
    }
}

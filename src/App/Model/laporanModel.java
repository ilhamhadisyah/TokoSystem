package App.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class laporanModel {
    private SimpleIntegerProperty idPelanggan;
    private SimpleStringProperty tanggalPembelian;
    private SimpleIntegerProperty totalHargaBeli;
    private SimpleStringProperty barangDibeli;

    public laporanModel(int idPel, String tanggal, int totalHarga, String barangDibeli) {
        this.idPelanggan = new SimpleIntegerProperty(idPel);
        this.tanggalPembelian = new SimpleStringProperty(tanggal);
        this.totalHargaBeli = new SimpleIntegerProperty(totalHarga);
        this.barangDibeli = new SimpleStringProperty(barangDibeli);

    }

    public int getIdPelanggan() {
        return idPelanggan.get();
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan.set(idPelanggan);
    }

    public String getTanggalPembelian() {
        return tanggalPembelian.get();
    }

    public void setTanggalPembelian(String tanggalPembelian) {
        this.tanggalPembelian.set(tanggalPembelian);
    }

    public int getTotalHargaBeli() {
        return totalHargaBeli.get();
    }

    public void setTotalHargaBeli(int totalHargaBeli) {
        this.totalHargaBeli.set(totalHargaBeli);
    }

    public String getBarangDibeli() {
        return barangDibeli.get();
    }

    public void setBarangDibeli(String barangDibeli) {
        this.barangDibeli.set(barangDibeli);
    }
}

package App.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.StringReader;

public class barangMasukModel {

    private SimpleStringProperty IDItem;
    private SimpleStringProperty namaItem;
    private SimpleStringProperty noFaktur;
    private SimpleIntegerProperty hargaSatuan;
    private SimpleIntegerProperty jumlahBarang;
    private SimpleStringProperty jenisSediaan;
    private SimpleStringProperty noBatch;
    private SimpleStringProperty asalDistributor;
    private SimpleIntegerProperty diskon;
    private SimpleStringProperty expDate;

    private SimpleStringProperty tglFaktur;
    private SimpleStringProperty jatuhTempo;
    private SimpleIntegerProperty totalHarga;

    public barangMasukModel(String id, String nama, String faktur,
                            int harga, int jumlah, String jenis, String noBatch,
                            String suplier, int diskon, String expDate, String tglFaktur,
                            String jatuhTempo, int totHarga) {
        this.IDItem = new SimpleStringProperty(id);
        this.namaItem = new SimpleStringProperty(nama);
        this.noFaktur = new SimpleStringProperty(faktur);
        this.hargaSatuan = new SimpleIntegerProperty(harga);
        this.jumlahBarang = new SimpleIntegerProperty(jumlah);
        this.jenisSediaan = new SimpleStringProperty(jenis);
        this.noBatch = new SimpleStringProperty(noBatch);
        this.asalDistributor = new SimpleStringProperty(suplier);
        this.diskon = new SimpleIntegerProperty(diskon);
        this.expDate = new SimpleStringProperty(expDate);
        this.tglFaktur = (new SimpleStringProperty(tglFaktur));
        this.jatuhTempo = (new SimpleStringProperty(jatuhTempo));
        this.totalHarga = (new SimpleIntegerProperty(totHarga));
    }

    public String getIDItem() {
        return IDItem.get();
    }

    public void setIDItem(String IDItem) {
        this.IDItem.set(IDItem);
    }

    public String getNamaItem() {
        return namaItem.get();
    }

    public void setNamaItem(String namaItem) {
        this.namaItem.set(namaItem);
    }

    public String getNoFaktur() {
        return noFaktur.get();
    }

    public void setNoFaktur(String noFaktur) {
        this.noFaktur.set(noFaktur);
    }

    public int getHargaSatuan() {
        return hargaSatuan.get();
    }

    public void setHargaSatuan(int hargaSatuan) {
        this.hargaSatuan.set(hargaSatuan);
    }

    public int getJumlahBarang() {
        return jumlahBarang.get();
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang.set(jumlahBarang);
    }

    public String getJenisSediaan() {
        return jenisSediaan.get();
    }

    public void setJenisSediaan(String jenisSediaan) {
        this.jenisSediaan.set(jenisSediaan);
    }

    public String getNoBatch() {
        return noBatch.get();
    }

    public void setNoBatch(String noBatch) {
        this.noBatch.set(noBatch);
    }

    public String getAsalDistributor() {
        return asalDistributor.get();
    }

    public void setAsalDistributor(String asalDistributor) {
        this.asalDistributor.set(asalDistributor);
    }

    public int getDiskon() {
        return diskon.get();
    }

    public void setDiskon(int diskon) {
        this.diskon.set(diskon);
    }

    public String getExpDate() {
        return expDate.get();
    }

    public void setExpDate(String expDate) {
        this.expDate.set(expDate);
    }


    public String getTglFaktur() {
        return tglFaktur.get();
    }

    public void setTglFaktur(String tglFaktur) {
        this.tglFaktur.set(tglFaktur);
    }

    public String getJatuhTempo() {
        return jatuhTempo.get();
    }

    public void setJatuhTempo(String jatuhTempo) {
        this.jatuhTempo.set(jatuhTempo);
    }

    public int getTotalHarga() {
        return totalHarga.get();
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga.set(totalHarga);
    }
}

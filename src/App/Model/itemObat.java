package App.Model;

import java.time.LocalDate;

public class itemObat {
    static public String namaItem;
    static public String distributorAsal;
    static public String jenisSediaan;
    static public String noFaktur;
    static public String noBatch;
    static public int jumlahBarang;
    static public int hargaSatuan;
    static public int diskon;
    static public int totalHarga;
    static public String kodeBarang;
    static public LocalDate tglFaktur;
    static public LocalDate expDate;
    static public LocalDate jatuhTempo;

    public void clear() {
        namaItem = "";
        distributorAsal = "";
        jenisSediaan = "";
        noFaktur = "";
        noBatch = "";
        jumlahBarang = 0;
        hargaSatuan = 0;
        diskon = 0;
        totalHarga = 0;
        kodeBarang = "";
        jenisSediaan = "";
        tglFaktur = LocalDate.now();
        expDate = LocalDate.now();
        jatuhTempo = LocalDate.now();
    }

    public itemObat(String namaBarang, String distributorAsal,
                    String jenisSediaan, String noFaktur, String noBatch,
                    int jumlahBarang, int hargaBarang,int diskon,
                    LocalDate expDate,LocalDate jatuhTempo){
        this.namaItem = namaBarang;
        this.distributorAsal = distributorAsal;
        this.jenisSediaan = jenisSediaan;
        this.noFaktur = noFaktur;
        this.noBatch= noBatch;
        this.jumlahBarang = jumlahBarang;
        this.hargaSatuan = hargaBarang;
        this.diskon = diskon;
        this.totalHarga = hargaBarang * jumlahBarang;
        this.expDate = expDate;
        this.jatuhTempo = jatuhTempo;

    }
    public itemObat(){

    }

    public String getNamaItem() {
        return namaItem;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public String getDistributorAsal() {
        return distributorAsal;
    }

    public void setDistributorAsal(String distributorAsal) {
        this.distributorAsal = distributorAsal;
    }

    public String getJenisSediaan() {
        return jenisSediaan;
    }

    public void setJenisSediaan(String jenisSediaan) {
        this.jenisSediaan = jenisSediaan;
    }

    public String getNoFaktur() {
        return noFaktur;
    }

    public void setNoFaktur(String noFaktur) {
        this.noFaktur = noFaktur;
    }

    public String getNoBatch() {
        return noBatch;
    }

    public void setNoBatch(String noBatch) {
        this.noBatch = noBatch;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public int getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(int hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public int getDiskon() {
        return diskon;
    }

    public void setDiskon(int diskon) {
        this.diskon = diskon;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = hargaSatuan * jumlahBarang;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public LocalDate getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(LocalDate tglFaktur) {
        this.jatuhTempo = jatuhTempo;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public LocalDate getTglFaktur() {
        return tglFaktur;
    }

    public void setTglFaktur(LocalDate tglFaktur) {
        this.tglFaktur = tglFaktur;
    }
}

package App.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class katalogModel {
    private SimpleStringProperty IDItem;
    private SimpleStringProperty namaItem;
    private SimpleStringProperty noFaktur;
    private SimpleIntegerProperty hargaSatuan;
    private SimpleStringProperty jenisSediaan;
    private SimpleStringProperty noBatch;
    private SimpleStringProperty asalDistributor;
    private SimpleStringProperty expDate;

    public katalogModel(String id, String nama, String faktur,
                        int harga, String jenis, String noBatch,
                        String suplier, String expDate) {
        this.IDItem = new SimpleStringProperty(id);
        this.namaItem = new SimpleStringProperty(nama);
        this.noFaktur = new SimpleStringProperty(faktur);
        this.hargaSatuan = new SimpleIntegerProperty(harga);
        this.jenisSediaan = new SimpleStringProperty(jenis);
        this.noBatch = new SimpleStringProperty(noBatch);
        this.asalDistributor = new SimpleStringProperty(suplier);
        this.expDate = new SimpleStringProperty(expDate);
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

    public String getExpDate() {
        return expDate.get();
    }

    public void setExpDate(String expDate) {
        this.expDate.set(expDate);
    }
}
/*
<columns>
                    <TableColumn fx:id="idItem" prefWidth="75.0" text="ID Item"/>
                    <TableColumn fx:id="namaItem" prefWidth="90.0" text="Nama Item"/>
                    <TableColumn fx:id="nofaktur" prefWidth="90.0" text="No faktur"/>
                    <TableColumn fx:id="hargaSatuan" prefWidth="90.0" text="Harga Satuan"/>
                    <TableColumn fx:id="jumlahBarang" prefWidth="90.0" text="Jumlah Barang"/>
                    <TableColumn fx:id="jenisSediaan" prefWidth="90.0" text="Jenis Sediaaan"/>
                    <TableColumn fx:id="noBatch" prefWidth="90.0" text="No Batch"/>
                    <TableColumn fx:id="suplier" prefWidth="90.0" text="Asal Distributor"/>
                    <TableColumn fx:id="diskon" prefWidth="90.0" text="Diskon"/>
                    <TableColumn fx:id="expDate" prefWidth="90.0" text="Exp Date"/>

                </columns>
 */
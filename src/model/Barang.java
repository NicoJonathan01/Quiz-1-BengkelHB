package model;

public class Barang {
    private String namaBarang;
    private String jenisBarang;
    private int harga;
    
    public Barang(String namaBarang, String jenisBarang, int harga) {
        this.namaBarang = namaBarang;
        this.jenisBarang = jenisBarang;
        this.harga = harga;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String toString(){
        return "\nNama Barang: " + namaBarang + "\nJenis Barang: " + jenisBarang + "\nHarga: " + harga;
    }
}

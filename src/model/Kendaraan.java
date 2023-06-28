package model;

public class Kendaraan {
    private String jenisKendaraan;
    private String nomorPolisi;
    private String merekKendaraan;
    private String modelKendaraan;
    
    public Kendaraan(String jenisKendaraan, String nomorPolisi, String merekKendaraan, String modelKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
        this.nomorPolisi = nomorPolisi;
        this.merekKendaraan = merekKendaraan;
        this.modelKendaraan = modelKendaraan;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getNomorPolisi() {
        return nomorPolisi;
    }

    public void setNomorPolisi(String nomorPolisi) {
        this.nomorPolisi = nomorPolisi;
    }

    public String getMerekKendaraan() {
        return merekKendaraan;
    }

    public void setMerekKendaraan(String merekKendaraan) {
        this.merekKendaraan = merekKendaraan;
    }

    public String getModelKendaraan() {
        return modelKendaraan;
    }

    public void setModelKendaraan(String modelKendaraan) {
        this.modelKendaraan = modelKendaraan;
    }

    public String toString(){
        return "\nJenis Kendaraan: " + jenisKendaraan + "\nNomor Polisi: " + nomorPolisi + "\nMerek Kendaraan: " + merekKendaraan + "\nModel Kendaraan: " + modelKendaraan + "\n";
    }

    
}

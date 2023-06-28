package model;

public class Keranjang {
    private Barang barang;
    private int kuantitas;
    
    public Keranjang(Barang barang, int kuantitas) {
        this.barang = barang;
        this.kuantitas = kuantitas;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public String toString(){
        return barang.toString() + "\nKuantitas: " + kuantitas + "\n";
    }
    
}

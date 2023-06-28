package view;

import controller.KeranjangController;
import java.util.ArrayList;
import model.Barang;
import model.Keranjang;

public class KeranjangScreen {
    private KeranjangController keranjangController;
    private ArrayList<Barang> listBarang;

    public KeranjangScreen(KeranjangController keranjangController, ArrayList<Barang> listBarang) {
        this.keranjangController = keranjangController;
        this.listBarang = listBarang;
    }

    public ArrayList<Keranjang> selectBarangToKeranjang() {

        boolean add = false;

        do{
            String showBarang = "";
            for (Barang barang : this.listBarang) {
                showBarang += (barang.getNamaBarang() + "\n");
            }

            String pilihBarang = Dialog.showInputDialog(showBarang);
            int kuantitas = Integer.parseInt(Dialog.showInputDialog("Masukkan kuantitas: "));

            Barang selected = null;
            for (Barang barang : listBarang) {
                if (pilihBarang.equals(barang.getNamaBarang())) {
                    selected = barang;
                }
            }

            keranjangController.addKeranjang(selected, kuantitas);
            add = Boolean.parseBoolean(Dialog.showInputDialog("Mau add lagi? "));

        }while(add);

        ArrayList<Keranjang> listKeranjang = keranjangController.getKeranjang();
        keranjangController.setListKeranjangToNull();
        return listKeranjang;

    }
}

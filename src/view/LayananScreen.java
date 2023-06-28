package view;

import controller.LayananController;
import java.util.ArrayList;
import model.Layanan;

public class LayananScreen {
    private LayananController layananController;

    public LayananScreen(LayananController layananController){
        this.layananController = layananController;
    }

    public ArrayList<Layanan> inputLayanan(){

        boolean inputLayanan = false;
        do{
            String jenisLayanan = Dialog.showInputDialog("Masukkan jenis layanan: ");
            int harga = Integer.parseInt(Dialog.showInputDialog("Masukkan harga: "));

            layananController.addLayanan(jenisLayanan, harga);

            inputLayanan = Boolean.parseBoolean(Dialog.showInputDialog("Mau add layanan lagi?"));
        }while(inputLayanan);

        ArrayList<Layanan> listLayanan = layananController.getLayanan();
        layananController.setListLayananToNull();
        return listLayanan;

    }
}

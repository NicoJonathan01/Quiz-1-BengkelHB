package view;

import controller.*;
import model.*;
import java.util.ArrayList;

public class MainMenuScreen {
    private MainMenuController mainMenuController;
    private PelangganController pelangganController;
    private TransaksiController transaksiController;
    private KeranjangController keranjangController;
    private LayananController layananController;
    private PelangganScreen pelangganScreen;
    private TransaksiScreen transaksiScreen;
    private KeranjangScreen keranjangScreen;
    private LayananScreen layananScreen;

    public MainMenuScreen(MainMenuController mainMenuController, PelangganController pelangganController, TransaksiController transaksiController, KeranjangController keranjangController, LayananController layananController, ArrayList<Barang> listBarang){
        this.mainMenuController = mainMenuController;
        this.pelangganController = pelangganController;
        this.transaksiController = transaksiController;
        this.keranjangController = keranjangController;
        this.layananController = layananController;
        this.pelangganScreen = new PelangganScreen(this.pelangganController);
        this.transaksiScreen = new TransaksiScreen(this.transaksiController);
        this.keranjangScreen = new KeranjangScreen(this.keranjangController, listBarang);
        this.layananScreen = new LayananScreen(this.layananController);
    }

    private void lihatTotalPendapatan(){
        double totalPendapatan = mainMenuController.hitungTotalPendapatan();
        Dialog.showMessageDialog(Double.toString(totalPendapatan));
    }

    public void displayMainMenu(){
        String pilihanMenu = "Main menu: \n1. Input Anggota \n2. Input Transaksi \n3. Hitung total pendapatan";

        int menu = 0;
        do{

            menu = Integer.parseInt(Dialog.showInputDialog(pilihanMenu));

            switch(menu){
                case 1:
                    pelangganScreen.inputNewMember();
                    break;
                case 2:
                    ArrayList<Keranjang> listKeranjang = keranjangScreen.selectBarangToKeranjang();
                    ArrayList<Layanan> listLayanan = layananScreen.inputLayanan();
                    transaksiScreen.inputTransaksi(listKeranjang, listLayanan);
                    break;
                case 3:
                    lihatTotalPendapatan();
                    break;
            }

        }while(menu != 0);
    }
}

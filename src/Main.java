import model.*;
import view.MainMenuScreen;
import controller.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private ArrayList<Pelanggan> listPelanggan;
    private ArrayList<Barang> listBarang;

    public Main(){
        this.listPelanggan = new ArrayList<Pelanggan>();
        this.listBarang = new ArrayList<Barang>();
    }

    public void inputDummy(){
        //data dummy barang
        Barang barang1 = new Barang("Castrol", "oli", 200000);
        Barang barang2 = new Barang("NGK", "busi", 350000);
        Barang barang3 = new Barang("V-Kool", "kaca film", 600000);
        Barang barang4 = new Barang("Dunlop", "ban", 500000);

        //data dummy list barang
        listBarang.add(barang1);
        listBarang.add(barang2);
        listBarang.add(barang3);
        listBarang.add(barang4);

        //data dummy keranjang 1
        ArrayList<Keranjang> listKeranjang1 = new ArrayList<Keranjang>();
        Keranjang keranjang1 = new Keranjang(barang1, 1);
        Keranjang keranjang2 = new Keranjang(barang2, 4);

        //data dummy list keranjang 1
        listKeranjang1.add(keranjang1);
        listKeranjang1.add(keranjang2);

        //data dummy keranjang 2
        ArrayList<Keranjang> listKeranjang2 = new ArrayList<Keranjang>();
        Keranjang keranjang3 = new Keranjang(barang3, 1);
        Keranjang keranjang4 = new Keranjang(barang4, 2);

        //data dummy list keranjang 2
        listKeranjang2.add(keranjang3);
        listKeranjang2.add(keranjang4);


        //data dummy layanan 1
        ArrayList<Layanan> listLayanan1 = new ArrayList<Layanan>();
        Layanan layanan1 = new Layanan("ganti oli", 30000);
        Layanan layanan2 = new Layanan("ganti busi", 35000);

        //data dummy list layanan 
        listLayanan1.add(layanan1);
        listLayanan1.add(layanan2);

        //data dummy layanan 2
        ArrayList<Layanan> listLayanan2 = new ArrayList<Layanan>();
        Layanan layanan3 = new Layanan("pasang kaca film", 100000);
        Layanan layanan4 = new Layanan("ganti ban", 100000);

        //data dummy list layanan 2
        listLayanan2.add(layanan3);
        listLayanan2.add(layanan4);

        //data dummy transaksi1
        ArrayList<Transaksi> listTransaksi1 = new ArrayList<Transaksi>();
        Transaksi transaksi1 = new Transaksi(JenisPembayaran.GOPAY, new Date(), 1665000, listLayanan1, listKeranjang1);

        //data list transaksi
        listTransaksi1.add(transaksi1);

        //data dummy transaksi2
        ArrayList<Transaksi> listTransaksi2 = new ArrayList<Transaksi>();
        Transaksi transaksi2 = new Transaksi(JenisPembayaran.TUNAI, new Date(), 1800000, listLayanan2, listKeranjang2);

        //data dummy list transaksi 2
        listTransaksi2.add(transaksi2);

        //data dummy kendaraan
        ArrayList<Kendaraan> listKendaraan = new ArrayList<Kendaraan>();
        Kendaraan kendaraan1 = new Kendaraan("mobil", "B 123 BZ", "Honda", "Accord");
        Kendaraan kendaraan2 = new Kendaraan("motor", "D 123 DZ", "Kawasaki", "Ninja");

        listKendaraan.add(kendaraan1);
        listKendaraan.add(kendaraan2);

        //data dummy pelanggan
        Pelanggan pelanggan1 = new Pelanggan("Nico", "TKI 1", "08123", listTransaksi1);

        Anggota anggota1 = new Anggota("Ucup", "Margahayu", "02679", listTransaksi2, "ucup@gmail.com", listKendaraan);

        listPelanggan.add(pelanggan1);
        listPelanggan.add(anggota1);

        System.out.println("====== List Pelanggan =====");
        for(Pelanggan pelanggan : listPelanggan){
            if(pelanggan instanceof Anggota){
                Anggota anggota = (Anggota) pelanggan;
                System.out.println(anggota.toString() + "\n--------------------");
            }else{
                System.out.println(pelanggan.toString() + "\n--------------------");
            }
        }
        
    }

    public ArrayList<Pelanggan> getListPelanggan() {
        return listPelanggan;
    }

    public void setListPelanggan(ArrayList<Pelanggan> listPelanggan) {
        this.listPelanggan = listPelanggan;
    }

    public ArrayList<Barang> getListBarang() {
        return listBarang;
    }

    public void setListBarang(ArrayList<Barang> listBarang) {
        this.listBarang = listBarang;
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.inputDummy();

        MainMenuController mainMenuController = new MainMenuController(main.getListPelanggan());
        PelangganController pelangganController = new PelangganController(main.getListPelanggan());
        TransaksiController transaksiController = new TransaksiController(main.getListPelanggan());
        KeranjangController keranjangController = new KeranjangController();
        LayananController layananController = new LayananController();

        MainMenuScreen mainMenu = new MainMenuScreen(mainMenuController, pelangganController, transaksiController, keranjangController, layananController, main.getListBarang());

        mainMenu.displayMainMenu();

        main.showTigaBarangPalingBanyakDibeli();
        
    }

    public void showTigaBarangPalingBanyakDibeli(){
        int jumlahCastrol = 0, jumlahNGK = 0, jumlahVKool = 0, jumlahDunlop = 0;

        for(Barang barang : listBarang){
            if(barang.getNamaBarang().equals("Castrol")){
                jumlahCastrol++;
            }else if(barang.getNamaBarang().equals("NGK")){
                jumlahNGK++;
            }else if(barang.getNamaBarang().equals("V-Kool")){
                jumlahVKool++;
            }else if(barang.getNamaBarang().equals("Dunlop")){
                jumlahDunlop++;
            }
        }

        int[] numbers = {jumlahCastrol, jumlahNGK, jumlahVKool, jumlahDunlop};

        Arrays.sort(numbers);
        System.out.println(
            "\nTerlaris pertama: " + numbers[numbers.length-1] + "\nTerlaris kedua: " + numbers[numbers.length-2] + "\nTerlaris ketiga: " + numbers[numbers.length-3]
        );
    
    }
}

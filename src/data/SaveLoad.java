package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import benda.*;
import entity.*;

import main.GamePanel;

public class SaveLoad {
    GamePanel gamePanel;

    public SaveLoad(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public Benda getObject(String itemName) {
        Benda obj = null;

        switch (itemName) {
            case "Ayam":
                obj = new BahanMakanan_Ayam();
                break;
            case "Bayam":
                obj = new BahanMakanan_Bayam();
                break;
            case "Kacang":
                obj = new BahanMakanan_Kacang();
                break;
            case "Kentang":
                obj = new BahanMakanan_Kentang();
                break;
            case "Nasi":
                obj = new BahanMakanan_Nasi();
                break;
            case "Sapi":
                obj = new BahanMakanan_Sapi();
                break;
            case "Wortel":
                obj = new BahanMakanan_Wortel();
                break;
            case "Susu":
                obj = new BahanMakanan_Susu();
                break;
            case "Jam":
                obj = new Furnitur_Jam(gamePanel);
                break;
            case "Kasur King Size":
                obj = new Furnitur_KasurKingSize(gamePanel);
                break;
            case "Kasur Queen Size":
                obj = new Furnitur_KasurQueenSize(gamePanel);
                break;
            case "Kasur Single":
                obj = new Furnitur_KasurSingle(gamePanel);
                break;
            case "Kompor Gas":
                obj = new Furnitur_KomporGas(gamePanel);
                break;
            case "Kompor Listrik":
                obj = new Furnitur_KomporListrik(gamePanel);
                break;
            case "Meja Kursi":
                obj = new Furnitur_MejaKursi(gamePanel);
                break;
            case "Toilet":
                obj = new Furnitur_Toilet(gamePanel);
                break;
            case "Bistik":
                obj = new Makanan_Bistik();
                break;
            case "Nasi Ayam":
                obj = new Makanan_NasiAyam();
                break;
            case "Nasi Kari":
                obj = new Makanan_NasiKari();
                break;
            case "Susu Kacang":
                obj = new Makanan_SusuKacang();
                break;
            case "Tumis Sayur":
                obj = new Makanan_TumisSayur();
                break;
            case "Lampu":
                obj = new Lampu(gamePanel);
                break;
        }

        return obj;
    }

    public void save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
            DataStorage ds = new DataStorage();

            // ds.sim.get(0).nama = gamePanel.getCurrentSim().nama;

            ds.nama = gamePanel.getCurrentSim().nama;
            ds.pekerjaan = gamePanel.getCurrentSim().pekerjaan;
            ds.uang = gamePanel.getCurrentSim().uang;
            ds.kesehatan = gamePanel.getCurrentSim().kesehatan;
            ds.kekenyangan = gamePanel.getCurrentSim().kekenyangan;
            ds.mood = gamePanel.getCurrentSim().mood;
            ds.lightUpdated = gamePanel.getCurrentSim().lightUpdated;
            // ds.currentLocation = gamePanel.getCurrentSim().currentLocation;
            // ds.indexLocationRuangan = gamePanel.getCurrentSim().indexLocationRuangan;
            // ds.indexBendaYangDisentuh = gamePanel.getCurrentSim().indexBendaYangDisentuh;
            // ds.indexRumahYangDimasuki = gamePanel.getCurrentSim().indexRumahYangDimasuki;
            // ds.currentMap = gamePanel.getCurrentSim().currentMap;

            // System.out.println(gamePanel.listRumah[gamePanel.listSim.get(gamePanel.indexCurrentSim).currentMap].get(0));
            // System.out.println(
            // gamePanel.listSim.get(gamePanel.indexCurrentSim).inventory);

            // ds.sim.nama = gamePanel.getCurrentSim().nama;

            // ds.kontol.add(gamePanel.getCurrentSim().nama);
            // ds.kontol.add(gamePanel.getCurrentSim().nama);

            for (int i = 0; i < gamePanel.getCurrentSim().inventory.size(); i++) {
                ds.itemNames.add(gamePanel.getCurrentSim().inventory.get(i).name);
                ds.itemAmounts.add(gamePanel.getCurrentSim().inventory.get(i).quantity);
            }

            ds.rumah.add(0);
            ds.rumah.add(gamePanel.getCurrentSim().rumah.jumlahRuangan);
            ds.rumah.add(gamePanel.getCurrentSim().rumah.worldX);
            ds.rumah.add(gamePanel.getCurrentSim().rumah.worldY);

            System.out.println("a");

            for (int i = 0; i < gamePanel.getCurrentSim().rumah.jumlahRuangan; i++) {
                ds.ruangan.add(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).index);
                ds.namaRuangan.add(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).name);
                if (gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).up != null) {
                    ds.ruangan.add(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).up.index);
                } else {
                    ds.ruangan.add(null);
                }
                if (gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).down != null) {
                    ds.ruangan.add(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).down.index);
                } else {
                    ds.ruangan.add(null);
                }
                if (gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).right != null) {
                    ds.ruangan.add(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).right.index);
                } else {
                    ds.ruangan.add(null);
                }
                if (gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).left != null) {
                    ds.ruangan.add(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).left.index);
                } else {
                    ds.ruangan.add(null);
                }
                System.out.println(0);

                ds.bendaRuangan.add(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).index + "");
                ds.bendaRuangan.add(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).bendaRuangan.size() + "");
                System.out.println(ds.bendaRuangan);
                for (int j = 0; j < gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).bendaRuangan.size(); j++) {
                    ds.bendaRuangan.add(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).bendaRuangan.get(j).name);
                    ds.bendaRuangan
                            .add(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).bendaRuangan.get(j).worldX + "");
                    ds.bendaRuangan
                            .add(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).bendaRuangan.get(j).worldY + "");
                    System.out.println(8);
                    System.out.println(ds.bendaRuangan);
                }

            }
            System.out.println(ds.bendaRuangan);

            System.out.println(ds.ruangan);

            // Write the DataStorage object
            oos.writeObject(ds);

        } catch (Exception e) {
            System.out.println("Save Exception!");
        }
    }

    public void load() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
            DataStorage ds = (DataStorage) ois.readObject();
            gamePanel.getCurrentSim().nama = ds.nama;
            gamePanel.getCurrentSim().pekerjaan = ds.pekerjaan;
            gamePanel.getCurrentSim().uang = ds.uang;
            gamePanel.getCurrentSim().kesehatan = ds.kesehatan;
            gamePanel.getCurrentSim().kekenyangan = ds.kekenyangan;
            gamePanel.getCurrentSim().mood = ds.mood;
            gamePanel.getCurrentSim().lightUpdated = ds.lightUpdated;
            // gamePanel.getCurrentSim().currentLocation = ds.currentLocation;
            // gamePanel.getCurrentSim().indexLocationRuangan = ds.indexLocationRuangan;
            // gamePanel.getCurrentSim().indexBendaYangDisentuh = ds.indexBendaYangDisentuh;
            // gamePanel.getCurrentSim().indexRumahYangDimasuki = ds.indexRumahYangDimasuki;
            // gamePanel.getCurrentSim().currentMap = ds.currentMap;
            gamePanel.getCurrentSim().inventory.clear();
            for (int i = 0; i < ds.itemNames.size(); i++) {
                gamePanel.getCurrentSim().inventory.add(getObject(ds.itemNames.get(i)));
                gamePanel.getCurrentSim().inventory.get(i).quantity = ds.itemAmounts.get(i);
            }

            gamePanel.getCurrentSim().rumah.worldX = ds.rumah.get(2);
            gamePanel.getCurrentSim().rumah.worldY = ds.rumah.get(3);
            gamePanel.getCurrentSim().rumah.colRumah = ds.rumah.get(2) / gamePanel.tileSize;
            gamePanel.getCurrentSim().rumah.rowRumah = ds.rumah.get(3) / gamePanel.tileSize;

            // gamePanel.getCurrentSim().rumah.ruanganRumah.get(0).up = ds.ruangan.get(1);

            // ds.ruangan.add(gamePanel.getCurrentSim().rumah.ruanganRumah.get(0).up.index);
            // ds.ruangan.add(gamePanel.getCurrentSim().rumah.ruanganRumah.get(0).left.index);
            // ds.ruangan.add(null);

            Ruangan ruanganUtama = gamePanel.getCurrentSim().rumah.ruanganRumah.get(0);
            gamePanel.getCurrentSim().rumah.ruanganRumah.clear();
            gamePanel.getCurrentSim().rumah.ruanganRumah.add(ruanganUtama);
            gamePanel.getCurrentSim().rumah.ruanganRumah.get(0).name = "Ruangan Utama";
            for (int i = 0; i < ds.rumah.get(1) - 1; i++) {
                Ruangan ruangan = new Ruangan(gamePanel);
                ruangan.name = ds.namaRuangan.get(i + 1);
                gamePanel.getCurrentSim().rumah.ruanganRumah.add(ruangan);
            }

            int num = 0;
            int indexPencariBenda = 0;
            for (int i = 0; i < ds.rumah.get(1); i++) {

                if (ds.ruangan.get(num + 1) != null) {
                    gamePanel.getCurrentSim().rumah.ruanganRumah
                            .get(i).up = gamePanel.getCurrentSim().rumah.ruanganRumah.get(ds.ruangan.get(num + 1));
                }
                if (ds.ruangan.get(num + 2) != null) {
                    if (i != 0) {
                        gamePanel.getCurrentSim().rumah.ruanganRumah
                                .get(i).down = gamePanel.getCurrentSim().rumah.ruanganRumah
                                        .get(ds.ruangan.get(num + 2));
                    }
                }
                if (ds.ruangan.get(num + 3) != null) {
                    gamePanel.getCurrentSim().rumah.ruanganRumah
                            .get(i).right = gamePanel.getCurrentSim().rumah.ruanganRumah.get(ds.ruangan.get(num + 3));
                }
                if (ds.ruangan.get(num + 4) != null) {
                    gamePanel.getCurrentSim().rumah.ruanganRumah
                            .get(i).left = gamePanel.getCurrentSim().rumah.ruanganRumah.get(ds.ruangan.get(num + 4));
                }
                num += 5;

                int nums = 0;
                for (int j = 0; j < Integer.parseInt(ds.bendaRuangan.get(indexPencariBenda + 1)); j++) {
                    gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).bendaRuangan
                            .add(getObject(ds.bendaRuangan.get(indexPencariBenda + 2 + j * 3)));
                    gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).bendaRuangan.get(j).worldX = Integer
                            .parseInt(ds.bendaRuangan.get(indexPencariBenda + 3 + j * 3));
                    gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).bendaRuangan.get(j).worldY = Integer
                            .parseInt(ds.bendaRuangan.get(indexPencariBenda + 4 + j * 3));
                    System.out.println(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).bendaRuangan.size());
                    System.out.println(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).bendaRuangan.get(j).name);
                    System.out.println(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).bendaRuangan.get(j).worldX);
                    System.out.println(gamePanel.getCurrentSim().rumah.ruanganRumah.get(i).bendaRuangan.get(j).worldY);
                    nums += 1;
                }
                System.out.println(0);
                indexPencariBenda += nums * 3;
                indexPencariBenda += 2;
                System.out.println(indexPencariBenda);
                System.out.println(100);
            }

            System.out.println('a');

            // gamePanel.getCurrentSim().nama = ds.kontol.get(0);

            // if (ds.ruangan.get(num + 4) != null) {
            // gamePanel.getCurrentSim().rumah.ruanganRumah.set(i,
            // gamePanel.getCurrentSim().rumah.ruanganRumah.get(ds.ruangan.get(num + 4)));
        } catch (Exception e) {
            System.out.println("Load Exception!");
        }
    }
}

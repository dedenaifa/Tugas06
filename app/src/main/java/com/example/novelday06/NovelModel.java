package com.example.novelday06;

public class NovelModel {
    private String namaNovel;
    private int gambarNovel;
    private String deskripsiNovel;
    private int hargaNovel;

    public NovelModel(String namaNovel, int gambarNovel, String deskripsiNovel, int hargaNovel) {
        this.namaNovel = namaNovel;
        this.gambarNovel = gambarNovel;
        this.deskripsiNovel = deskripsiNovel;
        this.hargaNovel = hargaNovel;
    }

    public String getNamaNovel() {
        return namaNovel;
    }

    public void setNamaNovel(String namaNovel) {
        this.namaNovel = namaNovel;
    }

    public int getGambarNovel() {
        return gambarNovel;
    }

    public void setGambarNovel(int gambarNovel) {
        this.gambarNovel = gambarNovel;
    }

    public String getDeskripsiNovel() {
        return deskripsiNovel;
    }

    public void setDeskripsiNovel(String deskripsiNovel) {
        this.deskripsiNovel = deskripsiNovel;
    }

    public int getHargaNovel() {
        return hargaNovel;
    }

    public void setHargaNovel(int hargaNovel) {
        this.hargaNovel = hargaNovel;
    }

}
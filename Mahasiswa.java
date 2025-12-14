/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

/**
 *
 * @author agrahizbullah
 */
public class Mahasiswa {
    
    // Variabel yang sudah ada
    protected int id;
    protected int tahunmasuk;
    protected String nim;
    protected String nama;
    
    // Variabel baru untuk perhitungan Biaya
    protected int sks; 
    protected String jenisMahasiswa; 
    
    // Constructor yang sudah ada, tambahkan sks dan jenisMahasiswa
    public Mahasiswa(int id, String nim, String nama, int tahunmasuk, String jenisMahasiswa, int sks) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.tahunmasuk = tahunmasuk;
        this.jenisMahasiswa = jenisMahasiswa;
        this.sks = sks;
    }
    
    public Mahasiswa(int sks, String jenisMahasiswa) {
    this.sks = sks;
    this.jenisMahasiswa = jenisMahasiswa;
    
    // Inisialisasi field wajib lainnya (dengan nilai default atau kosong)
    this.id = -1;
    this.nim = "";
    this.nama = "";
    this.tahunmasuk = 0;
}
    
    // Constructor untuk insert (tanpa ID)
    public Mahasiswa(String nim, String nama, int tahunmasuk, String jenisMahasiswa, int sks) {
        this.nim = nim;
        this.nama = nama;
        this.tahunmasuk = tahunmasuk;
        this.jenisMahasiswa = jenisMahasiswa;
        this.sks = sks;
    }
    
    // METHOD POLYMORPHISM (akan di-override oleh class turunan)
    // Jika class ini dipanggil, biaya default adalah 0
    public double hitungBiayaKuliah() {
        return 0.0; 
    }
    
    // Getter untuk diakses dari TampilanGUI jika diperlukan
    public String getJenisMahasiswa() {
        return jenisMahasiswa;
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

/**
 *
 * @author USER
 */
public class Mahasiswa {
    
    int id, tahunmasuk;
    String nim, nama;
 
    public Mahasiswa(int id, String nim, String nama, int tahunmasuk) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.tahunmasuk = tahunmasuk;

    }  
    
    public Mahasiswa( String nim, String nama, int tahunmasuk) {
        this.nim = nim;
        this.nama = nama;
        this.tahunmasuk = tahunmasuk;
    
    
}
}


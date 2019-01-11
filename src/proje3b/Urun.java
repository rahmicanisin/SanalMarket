/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje3b;

/**
 *
 * @author Rahmican
 */
public class Urun {
    private String urunAdi,kategori,marka,model,adMarkaModel;
    private int miktar;
    private float maliyet,satisFiyati;
    
    //consructor
    public Urun(String urunAdi,String kategori,String marka,String model,int miktar,float maliyet,float satisFiyati){
        this.urunAdi=urunAdi;
        this.miktar=miktar;
        this.marka=marka;
        this.model=model;
        this.kategori=kategori;
        this.maliyet=maliyet;
        this.satisFiyati=satisFiyati;
        this.adMarkaModel=urunAdi+marka+model;
    }

    @Override
    public String toString() {
        return   "urunAdi=" + urunAdi + ", kategori=" + kategori + ", marka=" + marka + ", model=" + model + ", miktar=" + miktar + ", maliyet=" + maliyet + ", satisFiyati=" + satisFiyati ;
    }





//getter and setter
    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public float getMaliyet() {
        return maliyet;
    }

    public void setMaliyet(float maliyet) {
        this.maliyet = maliyet;
    }

    public float getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(float satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    public String getAdMarkaModel() {
        return adMarkaModel;
    }

    public void setAdMarkaModel(String adMarkaModel) {
        this.adMarkaModel = adMarkaModel;
    }
    
    
}

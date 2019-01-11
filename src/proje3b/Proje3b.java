/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje3b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rahmican
 */
public class Proje3b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        menu();
    }
    static void  menu(){
        Scanner giris=new Scanner(System.in);
        int secim=0;
        while(secim!=-1){
        System.out.print("Projenin 1.maddesinin a şıkkı için 1: "
               + "\nProjenin 1.maddesinin b şıkkı için  2: "
               + "\nProjenin 1.maddesinin c şıkkı için 3: "
                +"\nProjenin 1.maddesinin d şıkkı için 4: "
                +"\nProjenin 2.maddesi için 5: "
                +"\nProjenin 3.maddesi için 6: "
                +"\nProjenin 4.maddesinin a şıkkı için 7: "
                +"\nProjenin 4.maddesinin b şıkkı için 8: "
                 +"\nSeçiminiz(çıkmak için -1 giriniz): ");
        
         secim=giris.nextInt();
        switch(secim){
            case 1:
                Proje_1a();
                break;
            case 2:
                Proje_1b();
                break;
            case 3:
                Proje_1c();
                break;
            case 4:
                System.out.println("Bilgisayar kategorisini silip ürünleri elektronik kategorisine ekleme");
                Proje_1d();
                break;
            case 5:
                Proje_2();
                break;
            case 6:
                Proje_3();
                break;
            case 7:
                proje_4a();
                break;
            case 8:
                Proje_4b();
                break;               
                
             }
            System.out.println("\nMenu için 1 giriniz: ");
            giris.next();
        }
    }
    public static Urun[] UrunOlustur(){//Dizide bulunan ürün bilgileri split metodu ile ayrılarak nesneler oluşturulur dizi içinde tutularak return edilir
         String[] urunler = { "Dizüstü Bilgisayar, Bilgisayar, Dell, XPS 13 9333 Intel Core i5, 10, 5799, 5927.3","Elektrikli Testere, Bahçe, Stihl, Ms 250 45 cm Pala, 5, 1500, 2750" 
                 , "Buzdolabı, Beyaz Eşya, Regal, Cool RGL 3000, 45, 899.5, 929"
         ,"Televizyon, Elektronik, Samsung, UE43MU7000 Ultra HD, 25, 2500, 3953",
         "Kalem, Kırtasiye, Rotring, Rapid Versatil Kalem, 63, 10, 28.9","Traş Makinesi, Kozmetik, Philips, 5000 Serisi S5050/06 Islak Kuru Şarjlı, 48, 225, 383"
         ,"Oyun Bilgisayarı, Bilgisayar, Monster, Tulpar T7 i7 7700, 18, 5021, 6980"};
         Urun[] urunDizi=new Urun[7];
         for(int i=0;i<urunler.length;i++){
         String[] bilgiler=urunler[i].split(", ");
           
         Urun u=new Urun(bilgiler[0],bilgiler[1],bilgiler[2],bilgiler[3],Integer.parseInt(bilgiler[4]),Float.parseFloat(bilgiler[5]),Float.parseFloat(bilgiler[6]));
         urunDizi[i]=u;                 
         }
         return urunDizi;
    }//end urunOlustur
    
    public static void Proje_1a(){//ürünler dizisindeki string’leri sahalarına ayrıştırarak Ürün
                                  // Nesnelerini oluşturup, Ürün Adı + Marka + Model’e göre ikili arama ağacına yerleştiren metod
        Urun[] urunDizi=UrunOlustur();//dizideki bilgiler ile oluşturulmuş nesneler elde edilir.
        Tree aramaAgac=new Tree();
        System.out.println("------------Ağaca eklenen ürünler listeleniyor\n");
        for(int i=0;i<urunDizi.length;i++){
            aramaAgac.insert(urunDizi[i]);
        }
        aramaAgac.inOrder(aramaAgac.getRoot());
    }//Proje_1a end
    public static void Proje_1b(){
//ürünler dizisindeki string’leri sahalarına ayrıştırarak Ürün Nesnelerini oluşturup,
//  Ürün Adı+ Marka + Model’e göre kategori ağaçlarına yerleştiren metod      
      List<Tree> kategoriAgac=kategoriAgacOlustur();
       
        
        System.out.println("----------Kategori ağacı listeleniyor");
        
        //yazdırma
      for(Tree agac:kategoriAgac){
          agac.inOrder(agac.getRoot());
      }//for end
    
    }//proje_1b end
    public static List<Tree> kategoriAgacOlustur(){
         //kategorilere göre ürünleri bulup kategoriAgac listesine sıralı olarak
        //yerleştirir
        Urun[] urunDizi=UrunOlustur();
        List<Tree> kategoriAgac=new ArrayList();
        ArrayList<String> kategoriAd=kategoriSıraDizi();
        
        for(int i=0;i<kategoriAd.size();i++){
            int girdi=0;
            for(int k=0;k<urunDizi.length;k++){
                
                if(kategoriAd.get(i).equalsIgnoreCase(urunDizi[k].getKategori())){
                    
                    if(girdi==0){//aynı kategoride olanları ayırmak için
                        Tree t=new Tree();
                        t.insert(urunDizi[k]);
                        kategoriAgac.add(t);
                        girdi++;
                        
                    }else
                        kategoriAgac.get(i).insert(urunDizi[k]);
                }//if end
            }//for end
        }//for end
        return kategoriAgac;
    }
    public static ArrayList<String> kategoriSıraDizi(){
         Urun[] urunDizi=UrunOlustur();
        
        ArrayList<String> kategoriAd=new ArrayList();
         for(int j=0;j<urunDizi.length;j++){//kategoriler bir listeye alınır
           
                if(!kategoriAd.contains(urunDizi[j].getKategori())){
                    kategoriAd.add(urunDizi[j].getKategori());
                }
        }
        Collections.sort(kategoriAd);//kategoriler alfabetik sıralanır
        return kategoriAd;
    }
    public static void Proje_1c(){
//Kategori ağaçlarının her birinin derinliğini, eleman sayısını, 
//düğümlerin derinlik ortalamasını bulan ve toplam kar miktarını hesaplar

        List<Tree> kategoriAgac=kategoriAgacOlustur();
        Scanner giris=new Scanner(System.in);
        float toplamKar=0;
        for(Tree agac:kategoriAgac){//kar hesaplanır
            System.out.println("\n"+agac.getRoot().data.getKategori()+" Ağacı");
            agac.agacBilgi(agac.getRoot(), agac.elemanSay);
            agac.karhesapla(agac.getRoot());
            toplamKar+=agac.kar;
        }
        System.out.println("\n"+"Toplam Kar :"+toplamKar);
       // Kullanıcıdan Ürün Adı alarak arama işlemi yapılır
        System.out.println("Aramak istediğiniz ürünün adını giriniz: ");
        String aranan=giris.nextLine();
      
        for(Tree agac:kategoriAgac){
         
            agac.arama(agac.getRoot(), aranan);            
        }       
    }
    public static void Proje_1d(){
  //Bilgisayar kategorisini silerek, içindeki tüm ürünleri Elektronik kategorisine ekler
        List<Tree> kategoriAgac=kategoriAgacOlustur();
        ArrayList<String> kategoriSıra=kategoriSıraDizi();
        int bilgisayarYer=kategoriSıra.indexOf("Bilgisayar");
        int elektronikYer=kategoriSıra.indexOf("Elektronik");
        kategoriAgac.get(elektronikYer).agacEkle(kategoriAgac.get(bilgisayarYer).getRoot());     
        kategoriAgac.remove(bilgisayarYer);
        for(Tree agac:kategoriAgac){
            System.out.println("\n"+agac.getRoot().data.getKategori()+" Ağacı");
            agac.inOrder(agac.getRoot());
        }
    }
    
    public static void Proje_2(){
// Ürün Nesnelerini (Ürün Adı + Marka + Model) bileşimine göre bir Hash Table’a yerleştirilir

        Urun[] urunDizi=UrunOlustur();
        Hashtable<String, Urun> urunHash = new Hashtable<String, Urun>();
       
        for(int i=0;i<urunDizi.length;i++)
            urunHash.put(urunDizi[i].getAdMarkaModel(), urunDizi[i]);
        System.out.println("\n-------------Hastable dan ürünler yazdırılıyor");
        for(int i=0;i<urunDizi.length;i++){
            System.out.println(urunHash.get(urunDizi[i].getAdMarkaModel()));
            
        }
//Adında Bilgisayar geçen ürünlerin Satış Fiyatlarında %10 indirim yaparak Hash Tablosunda günceller
        for(Urun  dizi:urunDizi){
            if(dizi.getUrunAdi().indexOf("Bilgisayar")!=-1){
                dizi.setSatisFiyati((dizi.getSatisFiyati()*9)/10);
                urunHash.replace(dizi.getAdMarkaModel(), dizi);
            }
        }
         System.out.println("\n--------Adında bilgisayar geçen ürünlere %10 indirim uygulandıktan sonra\n");
        for(int i=0;i<urunDizi.length;i++){
        
            System.out.println(urunHash.get(urunDizi[i].getAdMarkaModel()));
     }
            
    }
    public static void Proje_3(){
        // Sadece maliyetler bir Heap e yerleştirilir
// Maliyetlerine göre en ucuz 2 ve en pahalı 2 ürünü Heap’ten çekerek listelenir
        Urun[] urunler=UrunOlustur();
        Heap maliyet=new Heap();//heap oluşturulur
        for(Urun u:urunler){ //maliyetler heap e eklenir
            maliyet.ekle(u.getMaliyet());
            
        }
//        for(int i=0;i<urunler.length;i++) 
//             System.out.println(maliyet.cıkar());
       float[] maliyetEnler=new float[4]; //en küçük ve en büyük 2 maliyetleri tutmak için
       for(int i=0;i<urunler.length;i++){//heapten en büyük ve en küçük 2 eleman çekilir
           if(i<2)//en küçük iki eleman için 
               maliyetEnler[i]=maliyet.cıkar();
           else if(i>urunler.length-3)//en büyük 2 eleman için
               maliyetEnler[i-3]=maliyet.cıkar();
           else{
               maliyet.cıkar();
           }
       }
       for(int i=0;i<maliyetEnler.length;i++){ //ürünler yazdırılır
            if(i==0)
                System.out.println("En ucuz ürünler\n");
            else{ if(i==2)
                    System.out.println("En pahalı ürünler\n");
            } 
            for(Urun u:urunler){
                if(u.getMaliyet()==maliyetEnler[i])
                    System.out.println(u);     
            }
       }
    }
    public static void proje_4a(){//buble sort ile liste sıranır
        int[] dizi={8,6,32,25,85,12,75,2,48,95,15,28};
        System.out.println("Sıralanmadan önceki liste");
        for(int i:dizi)
            System.out.print(i+" ");
        int degisim=0;
        while(degisim==0){//değişim olmadığında döngü sonlanır ve dizi sıralanmış olur
            int girdi=0;
            for(int i=0;i<dizi.length-1;i++){//2 li çiftler halinde elemanları karşılaştırır
                if(dizi[i]>dizi[i+1]){//küçük olan başa alınır
                    int kopya=dizi[i];
                    dizi[i]=dizi[i+1];
                    dizi[i+1]=kopya;
                    girdi=1;
                }
            }
            if(girdi!=1)
                degisim=1;
        }
        System.out.println("\nBuble sort ile sıralandıktan sonra liste");
        for(int i:dizi){
            System.out.print(i+" ");
        }
        System.out.println("\n");
    }
      
    public static void quickSort(int[] a, int altindis, int üstindis) {
// altindis o adımda sıralanan altdizinin ek küçük indisidir
// üstindis o adımda sıralanan altdizinin ek büyük indisidir
        int i = altindis, j = üstindis, h;
// x terimi, mukayesenin yapılacağı mihenk'dir (pivot)
        int x = a[(altindis + üstindis) / 2];
// Takas eylemiyle diziyi ayrıştırma
            
        do {
            while (a[i] < x)
                i++;
            while (a[j] > x)
                j--;
            if (i <= j) {
                h = a[i];
                a[i] = a[j];
                a[j] = h;
                i++;
                j--;
            }
        } while (i <= j);
        // yinelge (recursion)
        if (altindis < j)
            quickSort(a, altindis, j);
        if (i < üstindis)
            quickSort(a, i, üstindis);
      }
      public static void Proje_4b(){//dizi quickSort metodu kullanılarak sıralanır
          int[] dizi={8,6,32,25,85,12,75,2,48,95,15,28};
          System.out.println("Sıralamadan önceki liste");
           for(int i:dizi){
            System.out.print(i+" ");
        }
          quickSort(dizi,0,dizi.length-1);
          System.out.println("\nquick sort ile Sıralamadan sonraki liste");
          for(int i:dizi){
            System.out.print(i+" ");
        }
          System.out.println("\n"); 
      }
}

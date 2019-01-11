/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje3b;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rahmican
 */
public class Heap {
    public List<Float> liste;
    
    public Heap(){ //consructor
        liste=new ArrayList();
    }
    public int sag(int dugum){//sağ düğümün index i bulunur
        return 2*dugum+2;
    }
    public int sol(int dugum){//sol duğumun indexsi bulunur
        return 2*dugum+1;
    }
    public int ustDugum(int dugum){//üst dugum indexsi bulunur
        return (dugum-1)/2;
    }
    public void ekle(float eklenen){//heap e eleman eklenip heap düzenlenir
        liste.add(eklenen);
        duzenleYukarı(liste.size()-1);
        
    }
    public void duzenleYukarı(int index){
//aşağıdan yukarıya doğru düzenleme yaparak evebeynin çocuklardan küçük olması sağlanır
        if(index!=0){
            int ustDugum=ustDugum(index);
            if( liste.get(ustDugum)>liste.get(index)){
                float kopya=liste.get(index);
                liste.set(index, liste.get(ustDugum));
                liste.set(ustDugum, kopya);
                duzenleYukarı(ustDugum);
            }
        }
    }
    public void duzenleAsagı(int index){
//heapte yukarıdan aşağıya doğru elemanları düzenler
        int sol=sol(index);
        int sag=sag(index);
        int min=-1;
        if(sag<liste.size()){  
            if(liste.get(sol)<liste.get(sag))
                min=sol;
            else
                min=sag;
        }else{
            if(sol<liste.size())
                min=sol;
        }if(min!=-1){
        if(liste.get(min)<liste.get(index)){//evebeynin çocuklardan küçük olması sağlanır
            float kopya=liste.get(index);
            liste.set(index,liste.get(min));
            liste.set(min, kopya);
            duzenleAsagı(min);
            
        }
        }
        
    }
    public float cıkar(){//heapten veriler çıkartılır ve silinir
        float donen;
        if(liste.size()!=0){
            donen=liste.get(0);
            liste.set(0, liste.get(liste.size()-1));
            liste.remove(liste.size()-1);
            duzenleAsagı(0);
            return donen;
        }else{
            return -1;
                    }
    }
    
}

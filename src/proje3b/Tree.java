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
   class TreeNode
    {
         
        public Urun data;
        public TreeNode leftChild;
        public TreeNode rightChild;
        public void displayNode() { System.out.println(" " + data + " "); }
    }

    // Agaç Sınıfı
    class Tree
    {    
          
        private TreeNode root;
        public int sayi, düzey,elemanSay,toplamDerinlik,maxDerinlik;
        public float kar;
      

        public Tree() { root = null; }

        public TreeNode getRoot()
        { return root; }

        // Agacın preOrder Dolasılması
        public void preOrder(TreeNode localRoot)
        {
            if (localRoot != null)
            {
                localRoot.displayNode();
                preOrder(localRoot.leftChild);
                preOrder(localRoot.rightChild);
            }
        }

        // Agacın inOrder Dolasılması
        public void inOrder(TreeNode localRoot)
        {
            if (localRoot != null)
            {
                inOrder(localRoot.leftChild);
                localRoot.displayNode();
                inOrder(localRoot.rightChild);
            }
        }

        // Agacın postOrder Dolasılması
        public void postOrder(TreeNode localRoot)
        {
            if (localRoot != null)
            {
                postOrder(localRoot.leftChild);
                postOrder(localRoot.rightChild);
                localRoot.displayNode();
            }
        }

        // Agaca bir dügüm eklemeyi saglayan metot
        public void insert(Urun newdata)
        {
            TreeNode newNode = new TreeNode();
            newNode.data = newdata;
            elemanSay++;
            if (root == null)
                root = newNode;
            else
            {
                TreeNode current = root;
                TreeNode parent;
                while (true)
                {
                    parent = current;
                    if (newdata.getAdMarkaModel().compareToIgnoreCase(current.data.getAdMarkaModel())<0 )
                    {
                        current = current.leftChild;
                        if (current == null)
                        {
                            parent.leftChild = newNode;
                            return;
                        }
                    }
                    else
                    {
                        current = current.rightChild;
                        if (current == null)
                        {
                            parent.rightChild = newNode;
                            return;
                        }
                    }
                } // end while
            } // end else not root
        } // end insert()

       public void düzeyListele(TreeNode etkin)
        {//agacın duzeyleri listelenir
            if (etkin != null)
            {
                düzey = düzey + 1;
                düzeyListele(etkin.leftChild);
                System.out.println(" " + etkin.data + " " + düzey + ". düzeyde");
                düzeyListele(etkin.rightChild);
                düzey = düzey - 1;
            }
        }
        public void arama(TreeNode localRoot,String aranan){
//agacta ürün adına göre arama yapar
              if (localRoot != null)
            {
                arama(localRoot.leftChild,aranan);
                
                arama(localRoot.rightChild,aranan);
                
                if(aranan.compareToIgnoreCase(localRoot.data.getUrunAdi())==0){
                    System.out.println("Bulundu"+"\n"+localRoot.data);
                 
                    
                }
            }
              
            
        }
        public boolean isEmpty(){//agacın boş olup olmadığını kontrol eder
            return root==null;
        }
         public void agacBilgi(TreeNode rootNode, int elemanSay)
//agacın derinliği eleman sayısını ve ortalama derinliği bulunup yazdırılır
        {

            toplamDerinlik = 0;
            maxDerinlik = 0;
           
            derinlik(rootNode, -1);

            System.out.println("Agacın Derinliği: " + maxDerinlik);
            System.out.println("Eleman Sayısı :"+elemanSay);
           
            System.out.println("ortalama Derinlik:  " + ((double)toplamDerinlik / elemanSay));

        }
        public void derinlik(TreeNode node,int derinlik){ //derinlik bulmak için
            if (node != null)
            {
                derinlik++;

              

                if (derinlik > maxDerinlik)
                    maxDerinlik = derinlik; //Max derinliği bulmak için

                toplamDerinlik += derinlik;

                derinlik(node.leftChild, derinlik); 
                derinlik(node.rightChild, derinlik); 

            }
        }
         public void karhesapla(TreeNode localRoot)//ürünlerin satışından elde edilen kar hesaplanır
        {
            if (localRoot != null)
            {
                karhesapla(localRoot.leftChild);
                karhesapla(localRoot.rightChild);
                kar+=(localRoot.data.getSatisFiyati()-localRoot.data.getMaliyet())*localRoot.data.getMiktar();
            }
        }
         public void dolas(TreeNode localRoot)//agacı dolasmak için
        {
            if (localRoot != null)
            {
                dolas(localRoot.leftChild);
                dolas(localRoot.rightChild);
            }
        }
         public void agacEkle(TreeNode localRoot)//agaca bir baska agacın elemanlarını eklemek için
        {
            if ( localRoot != null)
            {
                agacEkle(localRoot.leftChild);
                
                agacEkle(localRoot.rightChild);
                insert(localRoot.data);
                
        }}
    }

    

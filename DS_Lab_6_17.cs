using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ds_lab_6_2017
{
    // Düğüm Sınıfı
    class TreeNode
    {
        public int data;
        public TreeNode leftChild;
        public TreeNode rightChild;
        public void displayNode() { Console.Write(" " + data + " "); }
    }

    // Agaç Sınıfı
    class Tree
    {
        private TreeNode root;
        public int totalDepth;
        public int maxDepth;
        public int treeSize;
        public int[] elementCountForEachDepth;
        public int[] sumElementCountForEachDepth;
        public Tree() { root = null; }

        public TreeNode getRoot()
        {
            return root;
        }

        // Agaca bir dügüm eklemeyi saglayan metot
        public void insert(int newdata)
        {
            TreeNode newNode = new TreeNode();
            newNode.data = newdata;
            treeSize++;
            if (root == null)
                root = newNode;
            else
            {
                TreeNode current = root;
                TreeNode parent;
                while (true)
                {
                    parent = current;
                    if (newdata < current.data)
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

        public void findTreeInfo(TreeNode rootNode, int treeSize)
        {

            totalDepth = 0;
            maxDepth = 0;

            elementCountForEachDepth = new int[treeSize];
            sumElementCountForEachDepth = new int[treeSize];

            traverseTreeForInfo(rootNode, -1);

            Console.WriteLine("\nDepth of the tree: " + maxDepth);
            Console.WriteLine("Element counts for each depth");
            for (int i = 0; i <= maxDepth; i++)
            {
                Console.WriteLine("\tFor depth {0}: Number of elements: {1}  Sum of elements {2}", i, elementCountForEachDepth[i], sumElementCountForEachDepth[i]);
            }
            Console.WriteLine("Average depth: " + ((double)totalDepth / treeSize));

        }

        private void traverseTreeForInfo(TreeNode node, int depth)
        {
            if (node != null)
            {
                depth++;

                elementCountForEachDepth[depth]++;
                sumElementCountForEachDepth[depth] += node.data;

                if (depth > maxDepth)
                    maxDepth = depth; //update max depth

                totalDepth += depth;

                traverseTreeForInfo(node.leftChild, depth); //traverse left sub-tree
                traverseTreeForInfo(node.rightChild, depth); //traverse right sub-tree

            }
        }
        public void traverseTreeInorder(TreeNode node)
        {
            if (node != null)
            {

                traverseTreeInorder(node.leftChild); //traverse left sub-tree
                Console.Write(node.data + "  ");
                traverseTreeInorder(node.rightChild); //traverse right sub-tree

            }
        }
    }

    class DS_Lab_6_17
    {
        static void Main(string[] args)
        {
            int num;

            Random r = new Random();
            Tree tree = new Tree();

            Console.Write("Random numbers: ");
            for (int i = 0; i < 10; i++)
            {
                num = r.Next(0, 100);
                tree.insert(num);
                Console.Write(num + " ");
            }
            Console.WriteLine("");

            //Console.WriteLine("Tree Size: {0}", tree.treeSize);
            Console.Write("Inorder: ");
            tree.traverseTreeInorder(tree.getRoot());

            tree.findTreeInfo(tree.getRoot(), tree.treeSize);

            Console.ReadLine();
        }
    }
}

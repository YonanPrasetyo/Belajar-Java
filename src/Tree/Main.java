package Tree;

class NodeTree {
    int data;
    NodeTree left;
    NodeTree right;

    public NodeTree(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

class Tree {
    NodeTree root;

    public Tree(){
        this.root = null;
    }

    public boolean TreeEmpty(){
        return this.root == null;
    }

    public void insert(int data){
        NodeTree newNode = new NodeTree(data);
        insertNode(newNode, this.root);
    }

    public void insertNode(NodeTree newNode, NodeTree node){

        if (this.TreeEmpty()){
            this.root = newNode;
        }else{
            if (newNode.data < node.data){
                if (node.left == null){
                    node.left = newNode;
                }else{
                    insertNode(newNode, node.left);
                }
            }else {
                if (node.right == null){
                    node.right = newNode;
                }else {
                    insertNode(newNode, node.right);
                }
            }
        }
    }

    public void preorder(NodeTree node){
        if (node != null){
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void inorder(NodeTree node){
        if (node != null){
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }

    public void postorder(NodeTree node){
        if (node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data);
        }
    }

    public int tinggi(NodeTree node){
        if (node == null){
            return 0;
        }else {
            int tinggi1 = tinggi(node.left);
            int tinggi2 = tinggi(node.right);
            if (tinggi1 > tinggi2){
                return tinggi1 + 1;
            }else {
                return tinggi2 + 1;
            }
        }
    }

    public void daun(NodeTree node){
        if (node == null)
            return;
        if (node.left != null)
            daun(node.left);
        if (node.right != null)
            daun(node.right);
        if (node.left == null && node.right == null)
            System.out.println(node.data);
    }

    public boolean mencari(int cari, NodeTree node){
        if (node == null)
            return false;
        if (node.data == cari)
            return true;
        if (cari < node.data){
            return mencari(cari, node.left);
        }else {
            return mencari(cari, node.right);
        }
    }

    public void cari(int cari){
        System.out.println("mencari angka "+ cari);
        if (mencari(cari, this.root)){
            System.out.println("ditemukan");
        }else {
            System.out.println("tidak ditemukan");
        }
    }

    public int hitungnode(NodeTree node){
        if (node == null) {
            return 0;
        }else{
            return 1 + hitungnode(node.left) + hitungnode(node.right);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Tree list = new Tree();

        list.insert(5);
        list.insert(3);
        list.insert(8);
        list.insert(6);
        list.insert(2);

        System.out.println("preorder :");
        list.preorder(list.root);
        System.out.println("inorder :");
        list.inorder(list.root);
        System.out.println("postorder :");
        list.postorder(list.root);

        System.out.println("tinggi pohon : "+list.tinggi(list.root));
        System.out.println("daun : ");
        list.daun(list.root);

        System.out.println("Jumlah node : " + list.hitungnode(list.root));

        System.out.println("cari angka : ");
        list.cari(2);
        list.cari(5);
        list.cari(1);
        list.cari(10);
    }
}

package linkList;

class NodeLinkList{
    int data;
    NodeLinkList next;
    NodeLinkList prev;

    public NodeLinkList(int data){
        this.data = data;
        this.next = this.prev = null;
    }
}

class Linkedlist {
    NodeLinkList head;
    NodeLinkList tail;
    int size = 0;

    public boolean ListEmpty(){
        return this.size == 0;
    }

    public void insertAtBegin(int data){
        NodeLinkList newNode = new NodeLinkList(data);

        if(ListEmpty()){
            newNode.next = newNode.prev = newNode;
            this.head = this.tail = newNode;
        }else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.head = newNode;
        }
        this.size++;
    }

    public void insertAtEnd(int data){
        NodeLinkList newNode = new NodeLinkList(data);

        if(ListEmpty()){
            newNode.next = newNode.prev = newNode;
            this.head = this.tail = newNode;
        }else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.head.prev = newNode;
            newNode.next = this.head;
            this.tail = newNode;
        }
        this.size++;
    }

    public void deleteAtBegin(){
        if(!ListEmpty()){
            if(this.head.next == this.head){
                this.head = this.tail = null;
            }else{
                this.head = this.head.next;
                this.head.prev = this.tail;
                this.tail.next = this.head;
            }
            this.size--;
        }
    }

    public void deleteAtEnd(){
        if(!ListEmpty()){
            if (this.head.next == this.head){
                this.head = this.tail = null;
            }else{
                this.tail = this.tail.prev;
                this.tail.next = this.head;
                this.head.prev = this.tail;
            }
            this.size--;
        }
    }

    public void printList(){
        if (!ListEmpty()){
            NodeLinkList current = this.head;
            do {
                System.out.print("\n"+current.data+",");
                current = current.next;
            }while (current != this.head);
        }
    }

    public void getSize(){
        System.out.print("\nUkuran node :"+this.size);
    }
}


public class Main {
    public static void main(String[] args){
        Linkedlist list = new Linkedlist();

        list.insertAtBegin(1);
        list.insertAtBegin(2);
        list.insertAtBegin(3);
//        list.printList();

        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
//        list.printList();

        list.deleteAtBegin();
        list.deleteAtBegin();
        list.deleteAtEnd();
        list.printList();

        list.getSize();
    }
}

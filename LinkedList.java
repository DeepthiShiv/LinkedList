//implementing linkedlist from scratch
public class LinkedList{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data= data;
            this.next=null;
        }
       
    }
    public static Node head;
    public static Node tail;
    int size=0;


    public void addFirst(int data){
        //1st step- create a new node
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        //2nd step- newNode next=head
        newNode.next= head;
        //3rd step- head= newNode
        head= newNode;
    }


    //add last
    public void addLast(int data){
        size++;
        Node newNode= new Node(data);
        if(head==null){
            head=tail=newNode;
        }
        tail.next=newNode;
        tail= newNode;
    }


    //add in the middle
    public void add(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode= new Node(data);
        size++;
        Node temp= head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        // i=idx-1, temp->prev
        newNode.next=temp.next;
        temp.next= newNode; 

    }



    //remove first
    public int removeFirst(){
        //special case
        if(size==0){
            System.out.print("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val= head.data;
            head= tail= null;
            size=0;
            return val;
        }

        int val= head.data;
        head = head.next;
        size--;
        return val;
    }



    //remove last
    public int removeLast(){
        if(size==0){
            System.out.print("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val= head.data;
            head=tail=null;
            size=0;
            return val;
        }

        Node prev= head;
        for(int i=0;i<size-2;i++){
            prev= prev.next;
        }

        int val= prev.next.data;
        prev.next= null;
        tail= prev;
        size--;
        return val;

    }

    public void deleteNthfromEnd(int n){
        int sz=0;
        Node temp= head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n==sz){
            head= head.next;
            return;
        }
        int i=1;
        int iToFind= sz-n;
        Node prev= head;
        while(i<iToFind){
            prev= prev.next;
            i++;
        }
        prev.next= prev.next.next;
        return;

    }
    
    // to check if the linkedlist forms a cycle
    public Boolean isCycle(Node head){
        Node slow= head;
        Node fast= head;
        while(fast!=null && fast.next!=null){
            if(slow==fast){
                return true;
            }
            slow= slow.next;
            fast= fast.next.next;
        }
        return false;
    }
    
    //print linkedlist
    public void print(){
        if(head==null){
            System.out.print("LinkedList is empty");
            return;
        }
        Node temp= head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp= temp.next;
        }
        System.out.print("null");
    }


    public static void main(String args[]){
        LinkedList ll= new LinkedList();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.add(1,4);
        ll.removeFirst();
        ll.print();
        System.out.println();
        System.out.println(ll.size);
    }
}

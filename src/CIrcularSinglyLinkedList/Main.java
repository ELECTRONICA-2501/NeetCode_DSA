package CIrcularSinglyLinkedList;

public class Main {

    public static void main(String[] args) {
        CircularSLL CSSL = new CircularSLL();
        CSSL.createCSLL(4);
        CSSL.InsertCSLL(5,0);
        CSSL.InsertCSLL(6,1);
        CSSL.InsertCSLL(7, 9);
        CSSL.traversalOfCSLL();
        //CSSL.searchingInCSSL(6);

    }


}

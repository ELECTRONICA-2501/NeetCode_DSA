package Hashing;
import java.util.LinkedList;
import java.util.ArrayList;

public class DirectChaining {
    LinkedList<String>[] hashTable;
    int maxChainSize = 5; // fixed size ll
    public DirectChaining(int size){
        hashTable = new LinkedList[size]; //initializing new hashTable with directchaining
    }

    public int modASCIIHashFunction(String word, int M){ //cell value or index
        char ch[]; // create character array
        ch = word.toCharArray(); //convert word to character array, and assign it to ch array we created, this also does the ascii shit
        int i, sum; //used for loops
        for (sum = 0, i = 0; i < word.length(); i++){
            sum = sum + ch[i];
        }
        return sum % M;
    }

    public void insertHashTable(String word){
        int newIndex = modASCIIHashFunction(word, hashTable.length); // computes index of each word
        if (hashTable[newIndex] == null){ // we dont have a value in a cell
            hashTable[newIndex] =  new LinkedList<String>(); // create a key value pair, assign it newIndex
            hashTable[newIndex].add(word); // insert that new string to the end of LinkedList
        } else {
            hashTable[newIndex].add(word); // if we have a collision once the index is computed , just .add it to the LL. [ABC|222] --> [newIndex|null];
        }
    }

    //function to display values of hashtable
    public void print(){
        if(hashTable == null){
            System.out.println("HashTable doesnt exist");
            return;
        } else {
            System.out.println("\n-------------HASHTABLE----------------");
        for (int i = 0; i < hashTable.length; i++){
            System.out.println("\nIndex " + i + ", key: " + hashTable[i]);
        }

        }
    }

}

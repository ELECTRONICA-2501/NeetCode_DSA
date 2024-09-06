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

    // ------------ Search and Delete functions using direct chaining for HT

    public boolean searchHashTable(String word){
        int newIndex = modASCIIHashFunction(word, hashTable.length); //first we need to find the index of the string in parameter
        //based on the index we will check if string exist in HT
        if(hashTable[newIndex] != null && hashTable[newIndex].contains(word)){ //check that the computed index is not in HT and that computed index has the word we want
            System.out.println("\n" + "\"" + word + "\"" + " found in HT at location: "+ newIndex );
            return true;
        } else {
            System.out.println("\n" + "\"" + word + "\"" + " not found in HT" );
            return false;
        }
    }

    public void deleteKeyHashTable(String word){
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        //check if it exist
        boolean result = searchHashTable(word);
        if (result == true){
            hashTable[newIndex].remove(word);
            System.out.println("\n" + "\"" + word + "\"" + " has been deleted from HT");
        } else {
            System.out.println("value doesnt exist");
        }
    }


}

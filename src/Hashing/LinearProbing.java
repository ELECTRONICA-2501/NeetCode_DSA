package Hashing;
import java.util.ArrayList;
import Hashing.DirectChaining;
public class LinearProbing {
    String[] hashTable;
    int usedCellNumber;

    LinearProbing(int size){
        hashTable = new String[size];
        usedCellNumber = 0;
    }
    public int modASCIIHashFunction(String word, int M){
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for (sum =0, i = 0; i < word.length(); i++){
            sum = sum + ch[i];
        }
        return sum % M;
    }

    public double getLoadFactor(){
        double loadFactor = usedCellNumber * 1.0/hashTable.length;
        return loadFactor;
    }
    public void rehashKeys(String word){
        usedCellNumber = 0;
        ArrayList<String> data = new ArrayList<String>();
        for (String s : hashTable){
            if (s != null){
                data.add(s); //moving all elements from hashTable to data.
            }
            data.add(word);
            hashTable = new String[hashTable.length * 2];
            for (String s : data){
                if(s != null){
                    data.add(s);
                }
                data.add(word);
                hashTable = new String[hashTable.length * 2];
                for (String x : data){
                    insertInHashTable(word);
                }
            }
        }
    }


    public void insertInHashTable(String word){
        double loadFactor = getLoadFactor();
        if(loadFactor >= .75){
            rehashKeys(word);
        } else {
        int index = modASCIIHashFunction(word, hashTable.length); //calc new index
            for (int i = index; i < index + hashTable.length; i++){
                int newIndex = i% (index+hashTable.length);
                if (hashTable[newIndex] == null){
                    hashTable[newIndex] = word;
                    System.out.println("The " + word + " successfully inserted at location: " + newIndex);
                    break;
                }else {
                    System.out.println(newIndex + " is already occupied, Trying next empty cell");
                }
            }
        }
        usedCellNumber++;
    }
}
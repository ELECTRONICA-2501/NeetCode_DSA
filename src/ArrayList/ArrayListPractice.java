package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ArrayListPractice {

    //setting a homogenous array list
    // ArrayList<Type> arrayListName = new ArrayList<Type>(/*parameters to pass*/);

    //setting a arraylist w different types

    // ArrayList arrayListName2 = new ArrayList();

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(20, 30, 40));
        System.out.println(numbers);
        ArrayList<String> blah = new ArrayList<String>();
        blah.add(0, "h");
        blah.add(1, "i");
        blah.add(2, "!"); // this is O(N)
        blah.add("k"); //where as this is O(1);
        System.out.println(blah);
        ArrayList<String> StringList = new ArrayList<String>();
        StringList.add("A");
        StringList.add("B");
        StringList.add("C");
        StringList.add("D");
        StringList.add("E");

//        for(String letter: StringList){
//            System.out.println(letter);
//        }
//        Iterator<String> iterator = StringList.iterator();
//        while(iterator.hasNext()) {
//            String letter = iterator.next();
//            System.out.println(letter);
//        }
//    }
        for (String letter : StringList) {
            if (letter.equals("B")) {
                System.out.println("Found");
                break;
            }

        }

        //Can also use indexof()
        int index = StringList.indexOf("B");
        System.out.println("element is found at index : " + index);

        //how to insert elements into arrayList
        //use add() method
        // can also be used as add(index, element)


    }
}

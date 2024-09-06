package Arrays;

public class SingleDimensionArray {
    int arr[] = null;

    public SingleDimensionArray(int sizeOfArray) {
        arr = new int[sizeOfArray];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public void insert(int location, int ValuetobeInserted) {
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = ValuetobeInserted;
                System.out.println("successfully inserted");
            } else {
                System.out.println("Cell is occupied");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        }
    }

    public void traverseArray(){
        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }catch (Exception e ){
            System.out.println("out of bounds");
        }
    }

    public void searchInArray(int Value2Search){
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == Value2Search){
                System.out.println("Value Found at index of " + i);
                return;
            }
        }
        System.out.println(Value2Search + " is not found");
    }

    // if you know the value you want to delete and you know that its in an array, write like this.
    // else use a for loop to find the element in an unsorted array
    public void deleteValFromArray(int Value2BeDeleted){
        try{
            arr[Value2BeDeleted] = Integer.MIN_VALUE;
            System.out.println("Deleted successfully");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("element out of bounds");
        }
    }

    public static void main(String[] args) {
        SingleDimensionArray sda = new SingleDimensionArray(4);
        sda.insert(0,0);
        sda.insert(1, 10);
        sda.insert(2, 20);

        //access elements
        var firstElement = sda.arr[0];
        System.out.println(firstElement);
        var secElement = sda.arr[1];
        System.out.println(secElement);

        sda.traverseArray();
        System.out.println("\n");
        sda.searchInArray(10);
        sda.searchInArray(30);
        sda.deleteValFromArray(1);
        System.out.println(sda.arr[1]);
    }
}


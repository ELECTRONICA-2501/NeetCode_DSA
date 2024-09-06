package Arrays;
/*
Question: Best Score
Given an array, write a function to get first, second best scores from the array and return it in new array.

Array may contain duplicates.

Example

myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0}
firstSecond(myArray) // {90, 87}
*/
public class ArraysPractice {
    public static int[] findTopTwoScores(int[] array) {

        int[] result = new int[2];

        int maxElement = Integer.MIN_VALUE;
        int maxElementPosition = Integer.MIN_VALUE;

//		First traversal:
        for (int i = 0; i < array.length; i++) {

            if (array[i] >= maxElement) {
                maxElement = array[i];
                maxElementPosition = i;
            }

        }

        int secondElement = Integer.MIN_VALUE;

//		Second traversal
        for (int i = 0; i < array.length; i++) {

            if (array[i] >= secondElement && (i != maxElementPosition)) {
                secondElement = array[i];
            }

        }

        result[0] = maxElement;
        result[1] = secondElement;

        return result;
    }
}

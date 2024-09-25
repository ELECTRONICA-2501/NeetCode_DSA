package Arrays;

public class Kadanes_Algorithm {
    //let's say the problem is asking you to return the largest sum of a non-empty sub-array
    //Input: [4,-1,2,-7,3,4]

    //unique case: what if all numbers are negative?
    //return the smallest negative number, in this case -1

    //Kadane's Algorithm overlaps with
    // -2 pointer
    // -sliding window
    //as well as being a greedy and dynamic programming algorithm

    //Here is an examples of how to solve the problem above in o(n^2) - Brute Force Method
    public int largestSum(int[] nums){
        int maxSum = nums[0];
        for(int i = 0; i < nums.length; i++){
            int currentSum = 0;
            for (int j = i; j < nums.length; j++){
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    //Here is the algorithm in o(n) time;
    public int Kadanes(int[] nums){
        int maxSum = nums[0];   // start at the beginning of the array.
        int currentSum = 0;     // also keeping track of current Sum

        for (int i = 0; i < nums.length; i++){
            currentSum = Math.max(currentSum, 0);   //
            //given a sub array like
            // [4,-1,2,-7,3,4] if we start at 4, in this first iteration, currentSum = 0. Math.max(a,b) is checking if a >= b, in this case 0 >= 0 return 0
            currentSum += nums[i];
            //  0 + 4 = 4 = currentSum
            maxSum = Math.max(maxSum, currentSum);
            //maxSum is 4 so Math.max( 4 , 4 ) 4>=4, retrun 4
        }
        /*
        2nd iteration:
            i = 1
            Input: [4,-1,2,-7,3,4]
            currentSum = 4, 4 >= 0, currentSum remains 4
            4 + -1 = 3 = currentSum
            MaxSum 4 >= 3
         */
        /*
        3rd iteration:
            i = 2
            Input: [4,-1,2,-7,3,4]
            currentSum = 3, 3 >= 0, currentSum is now 3
            3 + 2 = 5 = currentSum
            MaxSum 4 >= 5, return 5, MaxSUm is now updated to 5
         */
        /*
        4th iteration:
            i = 3
            Input: [4,-1,2,-7,3,4]
            currentSum = 5, 5 >= 0, currentSum is now 5
            5 + -7 = -2 = currentSum
            MaxSum 5 >= -2, maxSum remains 5
         */
        /*
        5th iteration:
            i = 4
            Input: [4,-1,2,-7,3,4]
            currentSum = -2, -2 >= 0, currentSum is now 0
            0 + 3 = 3 = currentSum
            MaxSum 5 >= 3, maxSum remains 5
         */
        /*
        6th iteration:
            i = 5
            Input: [4,-1,2,-7,3,4]
            currentSum = 3, 3 >= 0, currentSum is now 3
            3 + 4 = 7 = currentSum
            MaxSum 5 >= 7, maxSum is now 7. This is our Answer.
         */

        return maxSum;
    }
}

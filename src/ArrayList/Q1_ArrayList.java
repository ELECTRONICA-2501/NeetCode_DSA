package ArrayList;


import com.sun.tools.javac.Main;

public class Q1_ArrayList {
    public static void main(String[] args) {
    Q1_ArrayList main = new Q1_ArrayList();
    int[] customArray = {1,2,3,4};
            main.sumOfProd(customArray);
    }


        public void sumOfProd(int[] array){
            int sum = 0;
            int product = 1;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            for (int i = 0; i < array.length; i++) {
                product *= array[i];
            }
            System.out.println(sum + ", "+ product);
        }

}

/*
 * This program is written by Pikulkaew Boonpeng.
 */
package numofshines;

import java.util.Arrays;

/**
 *
 * @author Pikulkaew Boonpeng
 */
public class NumOfShines {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = new int[]{2, 1, 3, 5, 4};
        int[] b = new int[]{1, 3, 2, 4, 5};
        int[] c = new int[]{3, 4, 2, 1, 5};
        int[] d = new int[]{1, 2, 3, 4, 5, 9, 7, 8, 6};
        int[] e = new int[]{10, 5, 8, 4, 2, 9, 6, 18, 7, 15, 13, 11, 1, 14, 17, 19, 12, 3, 16, 20, 18};

        System.out.println("A=[2, 1, 3, 5, 4] \nNumber of shines: " + calNumOfShines(a) + "\n");
        System.out.println("B=[1, 3, 2, 4, 5] \nNumber of shines: " + calNumOfShines(b) + "\n");
        System.out.println("C=[3, 4, 2, 1, 5] \nNumber of shines: " + calNumOfShines(c) + "\n");
        System.out.println("D=[1, 2, 3, 4, 5, 9, 7, 8, 6] \nNumber of shines: " + calNumOfShines(d) + "\n");
        System.out.println("E=[10, 5, 8, 4, 2, 9, 6, 18, 7, 15, 13, 11, 1, 14, 17, 19, 12, 3, 16, 20, 18] \nNumber of shines: " + calNumOfShines(e) + "\n");
    }

    /**
     * Calculates number of shine.
     *
     * @param A array of order of turned on bulbs
     * @return number of shines
     */
    public static int calNumOfShines(int[] A) {
        int minIndex = 0; // initialize minimum value's index
        int min = A[minIndex]; // initialize minimum value

        // find minimum value and its index
        for (int i = 0; i < A.length; i++) {
            if (min > A[i]) {
                minIndex = i;
                min = A[minIndex];
            }
        }

        // if the minimum is at the last index, return 1
        if (min == A[A.length - 1]) {
            return 1;
        }

        // if not, find the next minimum value
        A = Arrays.copyOfRange(A, minIndex + 1, A.length);

        // return the answer by adding 1 everytime that it finds the next minimum value
        return 1 + calNumOfShines(A);
    }
}

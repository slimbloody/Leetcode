// Object.clone(): Object class provides clone() method and since array in java is also an Object, you can use this method to achieve full array copy. This method will not suit you if you want partial copy of the array.
// System.arraycopy(): System class arraycopy() is the best way to do partial copy of an array. It provides you an easy way to specify the total number of elements to copy and the source and destination array index positions. For example System.arraycopy(source, 3, destination, 2, 5) will copy 5 elements from source to destination, beginning from 3rd index of source to 2nd index of destination.
// Arrays.copyOf(): If you want to copy first few elements of an array or full copy of array, you can use this method. Obviously it’s not versatile like System.arraycopy() but it’s also not confusing and easy to use.
// Arrays.copyOfRange(): If you want few elements of an array to be copied, where starting index is not 0, you can use this method to copy partial array.

import java.util.Arrays;
import java.lang.Integer;

class P905_Sort_Array_By_Parity {
    public int[] sortArrayByParity(int[] A) {
        return sol1(A);
    }

    public static void main(String[] args) {
        P905_Sort_Array_By_Parity sol = new P905_Sort_Array_By_Parity();
        // int a[] = {1, 2, 3, 4, 5, 6};
        int a[] = new int[6];
        for (int i = 0; i < 6; ++i) {
            a[i] = i + 1;
        }
        System.out.println(sol.sortArrayByParity(a));
    }

    public int[] sol1(int[] A) {
        Integer[] B = new Integer[A.length];

        for (int i = 0; i < A.length; ++i) {
            B[i] = A[i];
        }

        Arrays.sort(B, (a, b) -> Integer.compare(a % 2, b % 2));

        for (int i = 0; i < A.length; ++i) {
            A[i] = B[i];
        }

        return A;
    }

    public int[] sol2(int[] A) {
        return Arrays.stream(A)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a % 2, b % 2))
                     .mapToInt(i -> i)
                     .toArray();
    }

    public int[] sol3(int[] A) {
        int []ans = new int[A.length];
        int front = 0;
        int end = A.length - 1;

        for (int i = 0; i < A.length; ++i) {
            if (A[i] % 2 == 0) {
                ans[front++] = A[i];
            }
            else {
                ans[end--] = A[i];
            }
       }

        return ans;
    }

    public int[] sol4(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            if (A[i] % 2 == 0) {
                ++i;
            }
            if (A[j] % 2 == 1) {
                --j;
            }
        }

        return A;
    }
}


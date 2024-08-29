import java.util.*;

public class Solution {

    public static boolean check_Palindrome(int n) {
        int rev = 0;
        int temp = n;
        while (temp != 0) {
            int rem = temp % 10;
            rev = rev * 10 + rem;
            temp = temp / 10;
        }

        return (rev == n);

    }

    public static int[] find_nearest_palindrome(int x) {

        int a[] = new int[2];
        a[0] = a[1] = -1;

        int p = x;
        int q = x + 1;

        while (a[0] == -1) {
            if (check_Palindrome(p--)) {
                a[0] = p + 1;
            }
        }

        while (a[1] == -1) {
            if (check_Palindrome(q++)) {
                a[1] = q - 1;
            }
        }

        return a;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int[] ans = new int[M];

        for (int i = 0; i < M; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }

            // Arrays.sort(arr);

            for (int k = 0; k < arr.length; k++) {
                for (int l = 0; l < arr.length; l++) {
                    if (arr[k] < arr[l]) {
                        int temp = arr[k];
                        arr[k] = arr[l];
                        arr[l] = temp;
                    }
                }
            }

            // int[] ans=new int[N];

            int[] b = find_nearest_palindrome(arr[N / 2]);

            int result_1 = 0;
            int result_2 = 0;

            for (int v : arr) {
                if (b[0] != -1)
                    result_1 += Math.abs(v - b[0]);
                if (b[1] != -1)
                    result_2 += Math.abs(v - b[1]);
            }

            if (b[0] != -1 && b[1] != -1)

                ans[i] = Math.min(result_1, result_2);

            else if (b[0] != -1)
                ans[i] = result_1;
            else if (b[1] != -1)
                ans[i] = result_2;

        }

        for (int i = 0; i < M; i++) {
            System.out.println(ans[i]);
        }

        sc.close();

    }
}
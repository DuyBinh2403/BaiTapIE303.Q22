import java.util.*;

public class Bai4 {

    static int countTriangles(int[] arr) {
        int n = arr.length;
        int count = 0;

        Arrays.sort(arr);

        for (int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;

            while (left < right) {
                if (arr[left] + arr[right] > arr[i]) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = countTriangles(arr);

        System.out.println("Số tam giác có thể có: " + result);

        sc.close();
    }
}
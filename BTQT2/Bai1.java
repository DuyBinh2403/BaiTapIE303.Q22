import java.util.*;

public class Bai1 {
  static int findTheFirstDigit (int number) {

    while (number >= 10) {
      number /= 10;
    }

    return number;
  }

  static boolean checkOddNumber (int number) {
    if (number == 0) return false;

    while (number > 0) {
      int lastDigit = number % 10;
      if (lastDigit % 2 == 0) return false;

      number /= 10;
    }

    return true;
  }

  static long productOfDivisors (int number) {
    long product = 1;

    for (int i = 1; i * i <= number; i++) {
        if (number % i == 0) {
            product *= i;

            if (i != number / i) { // tránh nhân trùng khi i*i = n
                product *= (number / i);
            }
        }
    }

    return product;
  }

   public static boolean isPerfectNumber(int n) {
        if (n <= 1) return false;

        int sum = 1; // 1 luôn là ước

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;

                if (i != n / i) {
                    sum += (n / i);
                }
            }
        }

        return sum == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số n: ");
        int n = sc.nextInt();

        // Test từng hàm
        System.out.println("Chữ số đầu tiên: " + findTheFirstDigit(n));

        System.out.println("Tất cả chữ số là số lẻ? " + checkOddNumber(n));

        System.out.println("Tích các ước: " + productOfDivisors(n));

        System.out.println("Có phải số hoàn thiện? " + isPerfectNumber(n));

        sc.close();
    }
}
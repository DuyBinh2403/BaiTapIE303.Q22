import java.util.*;

public class Bai2 {

    // a. Đếm ký tự
    static void countCharacters(String str) {
        int letters = 0, digits = 0, spaces = 0, others = 0;

        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters++;
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isWhitespace(ch)) {
                spaces++;
            } else {
                others++;
            }
        }

        System.out.println("Chữ cái: " + letters);
        System.out.println("Khoảng trắng: " + spaces);
        System.out.println("Số: " + digits);
        System.out.println("Ký tự khác: " + others);
    }

    // b. Ký tự xuất hiện nhiều thứ hai
    static char secondMostFrequentChar(String str) {
        int[] freq = new int[256];

        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }

        int max = 0, secondMax = 0;

        for (int f : freq) {
            if (f > max) {
                secondMax = max;
                max = f;
            } else if (f > secondMax && f < max) {
                secondMax = f;
            }
        }

        // tìm ký tự đầu tiên có tần suất = secondMax
        for (char ch : str.toCharArray()) {
            if (freq[ch] == secondMax) {
                return ch;
            }
        }

        return '\0'; // không có
    }

    // c. Tính tổng các số trong chuỗi
    static int sumNumbersInString(String str) {
        int sum = 0;
        int currentNumber = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            } else {
                sum += currentNumber;
                currentNumber = 0;
            }
        }

        // cộng số cuối nếu có
        sum += currentNumber;

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();

        // a
        System.out.println("\n--- a. Đếm ký tự ---");
        countCharacters(str);

        // b
        System.out.println("\n--- b. Ký tự xuất hiện nhiều thứ hai ---");
        char result = secondMostFrequentChar(str);
        if (result != '\0') {
            System.out.println("Ký tự: " + result);
        } else {
            System.out.println("Không tìm thấy");
        }

        // c
        System.out.println("\n--- c. Tổng các số trong chuỗi ---");
        System.out.println("Tổng: " + sumNumbersInString(str));

        sc.close();
    }
}
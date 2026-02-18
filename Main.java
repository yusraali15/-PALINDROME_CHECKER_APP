import java.util.*;

class Palindrome {
    void start() {
        System.out.println("Palindrome app is starting");
        String javaVersion = System.getProperty("java.version");
        System.out.println("Java Version: " + javaVersion);
    }

    void checkPalindrome(String s) {
        int size = s.length();
        boolean isPalindrome = true;
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) != s.charAt(size - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("The string is a palindrome");
        } else {
            System.out.println("The string is NOT a palindrome");
        }
    }

    void reverseString(String s) {
        int str_len = s.length();
        System.out.print("The string after reversing is: ");
        for (int i = str_len - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
        System.out.println();
        System.out.println("The original string is: " + s);
    }

    int str_equals(String s) {
        System.out.println(s + " is the original string");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string of your choice for comparison: ");
        String st = sc.nextLine();
        sc.close();
        if (st.equals(s)) {
            return 1;
        } else {
            return 0;
        }
    }

    void twoPointerApproach(String s) {
        char[] charArray = s.toCharArray();
        int size = charArray.length;
        int start = 0;
        int end = size - 1;
        int mid = (start + end) / 2;
        boolean isPalindrome = true;

        while (start <= mid) {
            if (charArray[start] == charArray[end]) {
                start++;
                end--;
            } else {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The string is a palindrome (checked till middle)");
        } else {
            System.out.println("The string is NOT a palindrome (checked till middle)");
        }
    }


    void stack_palindrome() {
        Deque<Character> stack = new ArrayDeque<>();
        String s = "madam";
        System.out.println(s + " is the string to be checked using stack");
        int length = s.length();


        for (int i = 0; i < length; i++) {
            stack.push(s.charAt(i));
        }


        boolean isPalindrome = true;
        for (int i = 0; i < length; i++) {
            char ch = stack.pop();
            if (ch != s.charAt(i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The string is a palindrome (stack approach)");
        } else {
            System.out.println("The string is NOT a palindrome (stack approach)");
        }
    }



    void queue_palindrome() {
        Queue<Character> q = new ArrayDeque<>();
        String s = "radar";
        System.out.println(s + " is the string to be checked using queue");

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            q.add(ch);
        }


        for (int i = 0; i < s.length(); i++) {
            char c = q.peek();
            System.out.print(c);
            q.remove();
        }

        System.out.println("\nchecked palindrome");
    }




}
public class Main {
    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        p.start();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your string: ");
        String s = sc.nextLine();

        p.reverseString(s);

        System.out.println("To check palindrome using equals(), enter 'yes': ");
        String ans = sc.nextLine();

        if (ans.equals("yes")) {
            if (p.str_equals(s) == 1) {
                System.out.println("Palindrome found");
            } else {
                System.out.println("Not a Palindrome");
            }
        } else {
            System.out.println("Since you didn’t enter 'yes', we’ll move forward with other functions.");
        }

        // You can also test the other approaches:
        p.checkPalindrome(s);
        p.twoPointerApproach(s);
        p.stack_palindrome();
        p.queue_palindrome();

        sc.close();
    }
}
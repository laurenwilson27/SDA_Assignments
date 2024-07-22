package Stack;

public class Main {
    public static void main(String[] args) {
        StackArrays stackArrays = new StackArrays(5);
        stackArrays.push(1);
        stackArrays.push(2);
        stackArrays.push(3);

        System.out.println();

        stackArrays.peek();
        stackArrays.pop();
        stackArrays.peek();
        stackArrays.pop();
        stackArrays.peek();
        stackArrays.pop();

        System.out.println();

        stackArrays.isEmpty();
        stackArrays.isFull();

        isPalindrome("racecar");
        isPalindrome("taco cat");
        isPalindrome("saippuakivikauppias");
        isPalindrome("Won’t lovers revolt now?");
        isPalindrome("Keyin College");
    }

    // 5. use the stack datastructure to check whether a word is a palindrome or not eg racecar  == racecar
    public static void isPalindrome(String word) {
        // Make the word lowercase and remove everything but letters - this is just personal preference :)
        // It also allows us to check more 'exotic' palindromes - see the main method!
        String formatted = word.toLowerCase();
        formatted = formatted.replaceAll("[^a-z]+", "");

        StackList<Character> firstHalf = new StackList<>();
        StackList<Character> secondHalf = new StackList<>();

        // Push the first half of the word onto a stack
        for (int i = 0; i < formatted.length()/2; i++) {
            firstHalf.push(formatted.charAt(i));
        }

        // Push the second half of the word onto a stack
        for (int i = formatted.length() - 1; i > formatted.length()/2; i--) {
            secondHalf.push(formatted.charAt(i));
        }

        // Keep popping both stacks until they are empty
        // If, at any point, the pops return different values, the word is not a palindrome
        while (!firstHalf.isEmpty()) {
            if (!firstHalf.pop().equals(secondHalf.pop())) {
                System.out.println(word + " is NOT a palindrome");
                break;
            }

            if (firstHalf.isEmpty())
                System.out.println(word + " is a palindrome");
        }
    }
}

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> wordReturned = new ArrayDeque<>();
        if (word == null) {
            return null;
        }
        for (int i = 0; i < word.length(); i += 1) {
            wordReturned.addLast(word.charAt(i));
        }
        return wordReturned;
    }
    public boolean isPalindrome(String word) {
        Deque<Character> wordCheck = wordToDeque(word);
        if (wordCheck == null) {
            return false;
        }
        while (wordCheck.size() > 1) {
            if (wordCheck.removeFirst() != wordCheck.removeLast()) {
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordCheck = wordToDeque(word);
        if (wordCheck == null) {
            return false;
        }
        while (wordCheck.size() > 1) {
            Character front = wordCheck.removeFirst();
            Character back = wordCheck.removeLast();
            if (!(cc.equalChars(front, back))) {
                return false;
            }
        }
        return true;
    }
}

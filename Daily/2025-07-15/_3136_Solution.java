public class _3136_Solution {

    public boolean isValid(String word) {
        int length = word.length();
        if (length < 3)
            return false;
        boolean containVowel = false;
        boolean containConsonant = false;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char ch = Character.toLowerCase(c);
                if (ch == 'a' ||
                        ch == 'e' ||
                        ch == 'i' ||
                        ch == 'o' ||
                        ch == 'u') {
                    containVowel = true;
                } else {
                    containConsonant = true;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return containVowel && containConsonant;
    }


}

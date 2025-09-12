public class Day12_3227_Solution {
    public boolean doesAliceWin(String s) {
        return s
        .chars()
        .anyMatch(c->{
            return "aeiou".indexOf(c) != -1;
        });
    }
}

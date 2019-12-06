import java.util.List;

public class Main {
    public static void main(String []args) {
        String pattern = "abb";
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};

        Solution s = new Solution();
        List<String> matches = s.findAndReplacePattern(words, pattern);
        System.out.println(matches);

        pattern = "abc";
        String[] words2 = {"def", "aaa", "123", "jjj", "zef"};

        matches = s.findAndReplacePattern(words2, pattern);
        System.out.println(matches);
    }
}

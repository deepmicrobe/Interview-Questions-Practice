import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findAndReplacePattern (String[] words, String pattern) {
        Map<String, Integer> characterMap = new HashMap<>();
        List<Integer> patternList = new ArrayList<>();
        List<String> matches = new ArrayList<>();
        int val = 0;
        for (int i = 0; i < pattern.length(); i++) {
            // If character doesn't appear in character map, add it
            if (!characterMap.containsKey(String.valueOf(pattern.charAt(i)))) {
                characterMap.put(String.valueOf(pattern.charAt(i)), val);
                val++;
            }
            // Add number corresponding with character at i
            patternList.add(characterMap.get(String.valueOf(pattern.charAt(i))));
        }
        System.out.println(characterMap);
        System.out.println(patternList);

        // Iterate through words
        for (int i = 0; i < words.length; i++) {
            // Clear out character map
            characterMap.clear();
            // Clear out val
            val = 0;
            matches.add(words[i]);
            // Iterate through letters of each word
            for (int j = 0; j < words[i].length(); j++) {
                // If character doesn't appear in character map, add it
                if (!characterMap.containsKey(String.valueOf(words[i].charAt(j)))) {
                    characterMap.put(String.valueOf(words[i].charAt(j)), val);
                    val++;
                }
                // Check map to see if value matches array list value
                // If value at character doesn't match value in list
                if (characterMap.get(String.valueOf(words[i].charAt(j))) != patternList.get(j)) {
                    matches.remove(words[i]);
                    break;
                }
            }
        }

        return matches;
    }
}

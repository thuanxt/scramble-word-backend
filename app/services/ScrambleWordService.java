package services;

import databases.MockDb;
import models.Word;

import javax.inject.Singleton;
import java.util.*;
import java.util.stream.Collectors;

@Singleton
public class ScrambleWordService implements WordService {

    public Word getData(Integer id) {
        Word word = new Word();
        if (MockDb.data.containsKey(id)) {
            word.setId(id);
            word.setWord(MockDb.data.get(id));
            word.setExpectedWords(this.getExpectedWords(word.getWord()));
        }
        return word;
    }

    private List<String> getExpectedWords(String str) {
        return this.getAllPermutation(str).stream()
                            .distinct()
                            .filter(x -> MockDb.dataSet.contains(x))
                            .collect(Collectors.toList());
    }


    private List<String> getAllPermutation(String str) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            permutation(result, "", str, i);
        }
        return result;
    }

    private void permutation(List<String> result, String prefix, String str, Integer k) {
        int n = str.length();
        if (n == k) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(result, prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), k);
            }
        }
    }
}

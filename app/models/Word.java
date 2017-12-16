package models;

import java.util.List;

public class Word {
    private Integer id;
    private String word;
    private List<String> expectedWords;

    public Word() {
    }

    public Word(Integer id, String word, List<String> expectedWords) {
        this.id = id;
        this.word = word;
        this.expectedWords = expectedWords;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getExpectedWords() {
        return expectedWords;
    }

    public void setExpectedWords(List<String> expectedWords) {
        this.expectedWords = expectedWords;
    }
}

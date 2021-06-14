import javax.swing.*;
import java.util.*;

public class WordsStatistic {
    private ArrayList<String> uniqueWords;
    private int[] numberOfOccurrences;

    public ArrayList<String> getUniqueWords() {
        return uniqueWords;
    }

    public void setUniqueWords(ArrayList<String> uniqueWords) {
        this.uniqueWords = uniqueWords;
    }

    public int[] getNumberOfOccurrences() {
        return numberOfOccurrences;
    }

    public void setNumberOfOccurrences(int[] numberOfOccurrences) {
        this.numberOfOccurrences = numberOfOccurrences;
    }

    public WordsStatistic getStatistic(String text, char[] delimiters) {
        for (int i = 0; i < delimiters.length; i++) {
            text = text.replace(delimiters[i], ' ');
        }
        String[] allWords = text.split("\\s+");
        List<String> wordsWithDuplicates = Arrays.asList(allWords);
        Set<String> uniqueWordsSet = new HashSet<>(wordsWithDuplicates);
        this.setUniqueWords(new ArrayList<>(uniqueWordsSet));
        this.numberOfOccurrences = new int[this.uniqueWords.size()];
        for (int k = 0; k < allWords.length; k++) {
            int index = uniqueWords.indexOf(allWords[k]);
            numberOfOccurrences[index]++;
        }
        return this;
    }

    @Override
    public String toString() {
        String result = new String();
        for (int i = 0; i < this.uniqueWords.size(); i++) {
            result += uniqueWords.get(i) + " " + numberOfOccurrences[i] + "\n";
        }
        return result;
    }
}


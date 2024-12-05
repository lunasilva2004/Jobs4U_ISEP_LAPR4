package jobs4u.core.jobapplicationmanagement.application.Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Analyse file.
 */
public class AnalyseFile implements Runnable {

    private String filePath;
    private final Map<String, Integer> wordFrequency = new HashMap<>();

    /**
     * Instantiates a new Analyse file.
     *
     * @param filePath the file path
     */
    public AnalyseFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()){
                        synchronized (wordFrequency){
                            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                        }
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Gets word frequency.
     *
     * @return the word frequency
     */
    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
    }
}
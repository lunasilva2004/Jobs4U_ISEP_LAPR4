package jobs4u.core.jobapplicationmanagement.application.Services;


import jobs4u.core.jobapplicationmanagement.domain.FileJobApp;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * The type Most used words service.
 */
public class MostUsedWordsService {

    /**
     * Process files map.
     *
     * @param filePaths the file paths
     * @return the map
     */
    public Map<String, Map<String, Integer>> processFiles(List<FileJobApp> filePaths) {
        int THREAD_COUNT = 10;
        if (filePaths.size() < THREAD_COUNT) {
            THREAD_COUNT = filePaths.size();
        }

        List<List<FileJobApp>> partitions = FilesDistributor.distributeFilesAmongThreads(filePaths, THREAD_COUNT);

        Map<String, Map<String, Integer>> fileTopWords = new ConcurrentHashMap<>();
        List<Thread> threads = new ArrayList<>();
        for (List<FileJobApp> partition : partitions) {
            Thread thread = new Thread(() -> {
                for (FileJobApp file : partition) {
                    AnalyseFile readFile = new AnalyseFile(file.getValue());
                    readFile.run();

                    Map<String, Integer> wordFrequency = readFile.getWordFrequency();

                    Map<String, Integer> topWords = wordFrequency.entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                                    .thenComparing(Map.Entry.comparingByKey()))
                            .limit(20)
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new
                            ));

                    fileTopWords.put(file.getValue(), topWords);
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return fileTopWords;
    }
}
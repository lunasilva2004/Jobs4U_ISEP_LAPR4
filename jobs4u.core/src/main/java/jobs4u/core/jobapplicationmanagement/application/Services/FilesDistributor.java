package jobs4u.core.jobapplicationmanagement.application.Services;

import jobs4u.core.jobapplicationmanagement.domain.FileJobApp;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Files distributor.
 */
public class FilesDistributor {
    /**
     * Distribute files among threads list.
     *
     * @param filePaths   the file paths
     * @param threadCount the thread count
     * @return the list
     */
    public static List<List<FileJobApp>> distributeFilesAmongThreads(List<FileJobApp> filePaths, int threadCount) {
        List<List<FileJobApp>> partitions = new ArrayList<>();
        int partitionSize = filePaths.size() / threadCount;
        for (int i = 0; i < filePaths.size(); i += partitionSize) {
            partitions.add(filePaths.subList(i, Math.min(i + partitionSize, filePaths.size())));
        }
        return partitions;
    }
}
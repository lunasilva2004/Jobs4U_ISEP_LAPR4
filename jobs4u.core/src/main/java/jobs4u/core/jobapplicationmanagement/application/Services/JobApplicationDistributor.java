package jobs4u.core.jobapplicationmanagement.application.Services;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Job application distributor.
 */
public class JobApplicationDistributor {
    /**
     * Distribute job applications among threads list.
     *
     * @param jobApplicationIds the job application ids
     * @param threadCount       the thread count
     * @return the list
     */
    public static List<List<Long>> distributeJobApplicationsAmongThreads(List<Long> jobApplicationIds, int threadCount) {
        List<List<Long>> partitions = new ArrayList<>();
        int partitionSize = jobApplicationIds.size() / threadCount;
        for (int i = 0; i < jobApplicationIds.size(); i += partitionSize) {
            partitions.add(jobApplicationIds.subList(i, Math.min(i + partitionSize, jobApplicationIds.size())));
        }
        return partitions;
    }
}

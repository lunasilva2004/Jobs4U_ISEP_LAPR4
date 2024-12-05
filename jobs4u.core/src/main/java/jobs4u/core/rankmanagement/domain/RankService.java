package jobs4u.core.rankmanagement.domain;

import jakarta.transaction.Transactional;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.rankmanagement.repository.RankRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Rank service.
 */
@Service
public class RankService {
    private final RankRepository rankRepository;

    /**
     * Instantiates a new Rank service.
     *
     * @param rankRepository the rank repository
     */
    public RankService(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    /**
     * Save ranking.
     *
     * @param jobOpening the job opening
     * @param orders     the orders
     */
    @Transactional
    public void saveRanking(JobOpening jobOpening, List<Order> orders) {
        Rank rank = new Rank();
        rank.setJobOpening(jobOpening);
        for (Order order : orders) {
            rank.addOrder(order);
        }
        rankRepository.save(rank);
    }
}

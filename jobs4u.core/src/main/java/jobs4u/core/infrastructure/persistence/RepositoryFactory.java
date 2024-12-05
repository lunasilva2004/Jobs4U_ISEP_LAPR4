/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package jobs4u.core.infrastructure.persistence;

import jobs4u.core.PluginManagement.InterviewModelManagement.repository.InterviewModelRepository;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.repository.RequirementRepo;
import jobs4u.core.candidateusermanagement.repositories.CandidateRepository;
import jobs4u.core.clientusermanagement.repositories.ClientUserRepository;
import jobs4u.core.clientusermanagement.repositories.SignupRequestRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import jobs4u.core.customerusermanagement.repositories.CustomerRepository;
import jobs4u.core.interviewmanagement.repository.InterviewRepository;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.rankmanagement.repository.RankRepository;

/**
 * The interface Repository factory.
 */
public interface RepositoryFactory {

    /**
     * Job openings job opening repository.
     *
     * @return the job opening repository
     */
    JobOpeningRepository jobOpenings();

    /**
     * Job openings job opening repository.
     *
     * @param tx the tx
     * @return the job opening repository
     */
    JobOpeningRepository jobOpenings(TransactionalContext tx);

    /**
     * Interview model repository interview model repository.
     *
     * @return the interview model repository
     */
    InterviewModelRepository interviewModelRepository();

    /**
     * Interview model repository interview model repository.
     *
     * @param tx the tx
     * @return the interview model repository
     */
    InterviewModelRepository interviewModelRepository(TransactionalContext tx);

    /**
     * Ranks rank repository.
     *
     * @return the rank repository
     */
    RankRepository ranks();

    /**
     * Ranks rank repository.
     *
     * @param tx the tx
     * @return the rank repository
     */
    RankRepository ranks(TransactionalContext tx);

    /**
     * Job applications job application repository.
     *
     * @return the job application repository
     */
    JobApplicationRepository jobApplications();

    /**
     * Job applications job application repository.
     *
     * @param tx the tx
     * @return the job application repository
     */
    JobApplicationRepository jobApplications(TransactionalContext tx);

    /**
     * New transactional context transactional context.
     *
     * @return the transactional context
     */
    TransactionalContext newTransactionalContext();

    /**
     * Users user repository.
     *
     * @param autoTx the auto tx
     * @return the user repository
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * Users user repository.
     *
     * @return the user repository
     */
    UserRepository users();

    /**
     * Client users client user repository.
     *
     * @param autoTx the auto tx
     * @return the client user repository
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * Client users client user repository.
     *
     * @return the client user repository
     */
    ClientUserRepository clientUsers();

    /**
     * Signup requests signup request repository.
     *
     * @param autoTx the auto tx
     * @return the signup request repository
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * Signup requests signup request repository.
     *
     * @return the signup request repository
     */
    SignupRequestRepository signupRequests();

    /**
     * Customers customer repository.
     *
     * @return the customer repository
     */
    CustomerRepository customers();

    /**
     * Customers customer repository.
     *
     * @param autoTx the auto tx
     * @return the customer repository
     */
    CustomerRepository customers(TransactionalContext autoTx);

    /**
     * Candidates candidate repository.
     *
     * @return the candidate repository
     */
    CandidateRepository candidates();

    /**
     * Candidate candidate repository.
     *
     * @param autoTx the auto tx
     * @return the candidate repository
     */
    CandidateRepository candidate(TransactionalContext autoTx);

    /**
     * Interview model interview model repository.
     *
     * @return the interview model repository
     */
    InterviewModelRepository interviewModel();

    /**
     * Interview model interview model repository.
     *
     * @param autoTx the auto tx
     * @return the interview model repository
     */
    InterviewModelRepository interviewModel(TransactionalContext autoTx);

    /**
     * Interview interview repository.
     *
     * @return the interview repository
     */
    InterviewRepository interview();

    /**
     * Interview interview repository.
     *
     * @param autoTx the auto tx
     * @return the interview repository
     */
    InterviewRepository interview(TransactionalContext autoTx);

    /**
     * Requirement requirement repo.
     *
     * @return the requirement repo
     */
    RequirementRepo requirement();

    /**
     * Requirement requirement repo.
     *
     * @param autoTx the auto tx
     * @return the requirement repo
     */
    RequirementRepo requirement(TransactionalContext autoTx);

}

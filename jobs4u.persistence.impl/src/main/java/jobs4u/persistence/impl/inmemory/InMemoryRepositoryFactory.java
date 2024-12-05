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
package jobs4u.persistence.impl.inmemory;

import jobs4u.core.PluginManagement.InterviewModelManagement.repository.InterviewModelRepository;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.repository.RequirementRepo;
import jobs4u.core.candidateusermanagement.repositories.CandidateRepository;
import jobs4u.core.clientusermanagement.repositories.ClientUserRepository;
import jobs4u.core.clientusermanagement.repositories.SignupRequestRepository;
import jobs4u.core.customerusermanagement.repositories.CustomerRepository;
import jobs4u.core.interviewmanagement.repository.InterviewRepository;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;
import jobs4u.core.rankmanagement.repository.RankRepository;
import jobs4u.infrastructure.bootstrapers.Bootstrapper;
import jobs4u.core.infrastructure.persistence.RepositoryFactory;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.inmemory.InMemoryUserRepository;

/**
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new Bootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {

        return new InMemoryClientUserRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public CustomerRepository customers() {
        return null;
    }

    @Override
    public CustomerRepository customers(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public CandidateRepository candidates() {
        return null;
    }

    @Override
    public CandidateRepository candidate(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public InterviewModelRepository interviewModel() {
        return null;
    }

    @Override
    public InterviewModelRepository interviewModel(TransactionalContext autoTx) {
        return null;
    }
    @Override
    public InterviewRepository interview() {
        return null;
    }

    @Override
    public InterviewRepository interview(TransactionalContext autoTx) {
        return null;
    }


    @Override
    public RequirementRepo requirement() {
        return null;
    }

    @Override
    public RequirementRepo requirement(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public JobOpeningRepository jobOpenings() {
        return null;
    }

    @Override
    public JobOpeningRepository jobOpenings(TransactionalContext tx) {
        return null;
    }

    @Override
    public RankRepository ranks() {
        return null;
    }

    @Override
    public RankRepository ranks(TransactionalContext tx) {
        return null;
    }


    @Override
    public JobApplicationRepository jobApplications() {
        return null;
    }

    @Override
    public JobApplicationRepository jobApplications(TransactionalContext tx) {
        return null;
    }
    @Override
    public InterviewModelRepository interviewModelRepository() {
        return null;
    }

    @Override
    public InterviewModelRepository interviewModelRepository(TransactionalContext tx) {
        return null;
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

}

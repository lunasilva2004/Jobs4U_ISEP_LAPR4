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
package jobs4u.persistence.impl.jpa;

import jobs4u.Application;
import jobs4u.core.PluginManagement.InterviewModelManagement.repository.InterviewModelRepository;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.repository.RequirementRepo;
import jobs4u.core.candidateusermanagement.repositories.CandidateRepository;
import jobs4u.core.clientusermanagement.repositories.SignupRequestRepository;
import jobs4u.core.customerusermanagement.repositories.CustomerRepository;
import jobs4u.core.infrastructure.persistence.RepositoryFactory;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.jpa.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.core.interviewmanagement.repository.InterviewRepository;

/**
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository clientUsers() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CustomerRepository customers() {
        return new CustomerJpaRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CustomerRepository customers(TransactionalContext autoTx) {
        return new CustomerJpaRepository(autoTx);    }


    @Override
    public CandidateRepository candidates() {
        return new CandidateJpaRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CandidateRepository candidate(TransactionalContext autoTx) {
        return new CandidateJpaRepository(autoTx);
    }

    @Override
    public InterviewModelRepository interviewModel() {
        return new JpaInterviewModelRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public InterviewModelRepository interviewModel(TransactionalContext autoTx) {
        return new JpaInterviewModelRepository(autoTx);
    }

    @Override
    public InterviewRepository interview() {
        return new JpaInterviewRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public InterviewRepository interview(TransactionalContext autoTx) {
        return new JpaInterviewRepository(autoTx);
    }

    @Override
    public RequirementRepo requirement() {
        return new JpaRequirementsRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public RequirementRepo requirement(TransactionalContext autoTx) {
        return new JpaRequirementsRepository(autoTx);
    }

    @Override
    public JpaJobOpeningRepository jobOpenings(final TransactionalContext autoTx) {
        return new JpaJobOpeningRepository(autoTx);
    }
    @Override
    public JpaJobOpeningRepository jobOpenings() {
        return new JpaJobOpeningRepository(Application.settings().getPersistenceUnitName());
    }


    @Override
    public JpaRankRepository ranks(final TransactionalContext autoTx) {
        return new JpaRankRepository(autoTx);
    }
    @Override
    public JpaRankRepository ranks() {
        return new JpaRankRepository(Application.settings().getPersistenceUnitName());
    }


    @Override
    public InterviewModelRepository interviewModelRepository() {
        return new JpaInterviewModelRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public InterviewModelRepository interviewModelRepository(TransactionalContext tx) {
        return new JpaInterviewModelRepository(tx);
    }

    @Override
    public JpaJobApplicationRepository jobApplications(final TransactionalContext autoTx) {
        return new JpaJobApplicationRepository(autoTx);
    }

    @Override
    public JpaJobApplicationRepository jobApplications() {
        return new JpaJobApplicationRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

}

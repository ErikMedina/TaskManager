package com.erikmedina.taskmanager.domain.interactor.registration;

import com.erikmedina.taskmanager.domain.repository.registration.RegistrationRepository;

/**
 * Created by erik on 17/12/16.
 */
public class RegistrationInteractorImpl implements RegistrationInteractor {

    private RegistrationRepository registrationRepository;

    public RegistrationInteractorImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public void execute(String username, String password, String userType, OnRegistrationListener listener) {
        registrationRepository.persistUser(username, password, userType, listener);
    }
}

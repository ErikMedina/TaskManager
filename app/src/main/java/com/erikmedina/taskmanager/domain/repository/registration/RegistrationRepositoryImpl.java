package com.erikmedina.taskmanager.domain.repository.registration;

import com.erikmedina.taskmanager.domain.interactor.registration.RegistrationInteractor;

/**
 * Created by erik on 17/12/16.
 */
public class RegistrationRepositoryImpl implements RegistrationRepository {

    @Override
    public void persistUser(String username, String password, String userType,
                            RegistrationInteractor.OnRegistrationListener listener) {

    }
}

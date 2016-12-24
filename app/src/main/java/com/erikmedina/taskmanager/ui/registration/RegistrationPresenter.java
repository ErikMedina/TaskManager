package com.erikmedina.taskmanager.ui.registration;

import java.util.List;

/**
 * Created by erik on 17/12/16.
 */

public interface RegistrationPresenter {

    void registerUser(String username, String password, String userType, List skillsSelected);

    void selectSkillsButtonClicked();
}

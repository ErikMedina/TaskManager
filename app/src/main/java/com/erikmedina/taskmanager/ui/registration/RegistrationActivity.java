package com.erikmedina.taskmanager.ui.registration;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.ui.base.BaseActivity;
import com.erikmedina.taskmanager.util.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by erik on 17/12/16.
 */

public class RegistrationActivity extends BaseActivity implements RegistrationView {

    @BindView(R.id.tiet_username_registration)
    TextInputEditText tietUsernameRegistration;
    @BindView(R.id.tiet_password_registration)
    TextInputEditText tietPasswordRegistration;
    @BindView(R.id.b_select_skills)
    Button bSelectSkills;
    @BindView(R.id.s_user_type_registration)
    Spinner sUserTypeRegistration;

    RegistrationPresenter presenter;
    List skillsSelected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.registration_name);

        presenter = new RegistrationPresenterImpl(this);
        sUserTypeRegistration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == Utils.TECHNICIAN_ID) {
                    bSelectSkills.setEnabled(true);
                } else if (i == Utils.ADMIN_ID) {
                    bSelectSkills.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_registration;
    }

    @OnClick(R.id.b_sign_in_registration)
    public void onRegisterButtonClicked() {
        presenter.registerUser(tietUsernameRegistration.getText().toString(),
                tietPasswordRegistration.getText().toString(),
                sUserTypeRegistration.getSelectedItem().toString(),
                skillsSelected);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @OnClick(R.id.b_select_skills)
    public void onSelectSkillsButtonClicked() {
        presenter.selectSkillsButtonClicked();
    }

    @Override
    public void showSkillsSelectionDialog() {
        final List<Integer> skillsSelected = new ArrayList();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.select_skills)
                .setMultiChoiceItems(R.array.array_task_type, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    skillsSelected.add(which);
                                } else if (skillsSelected.contains(which)) {
                                    skillsSelected.remove(Integer.valueOf(which));
                                }
                            }
                        })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        setSkillsSelected(skillsSelected);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        builder.create();
        builder.show();
    }

    private void setSkillsSelected(List<Integer> skillsSelected) {
        this.skillsSelected = skillsSelected;
    }
}

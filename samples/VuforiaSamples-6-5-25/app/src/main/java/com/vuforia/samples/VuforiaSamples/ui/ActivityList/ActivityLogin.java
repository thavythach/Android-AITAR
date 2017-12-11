package com.vuforia.samples.VuforiaSamples.ui.ActivityList;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.FirebaseDatabase;
import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.data.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityLogin extends AppCompatActivity {

    private static final String KEY_EMAIL = "KEY_EMAIL";
    private static final String KEY_PASSWORD = "KEY_PASSWORD";

    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        firebaseAuth = FirebaseAuth.getInstance();

        SharedPreferences sp =
                PreferenceManager.getDefaultSharedPreferences(this);
        String email = sp.getString(KEY_EMAIL, null);
        String password = sp.getString(KEY_PASSWORD, null);
        if (email != null && password != null) {
            etEmail.setText(email);
            etPassword.setText(password);
        }
    }

    @OnClick(R.id.btnRegister)
    void registerClick() {
        if (!isFormValid()) return;

        showProgressDialog();
        firebaseAuth.createUserWithEmailAndPassword(
                etEmail.getText().toString(),
                etPassword.getText().toString()).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            addUserToDatabase(task.getResult().getUser());
                            Toast.makeText(ActivityLogin.this,
                                    "Registration successful",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ActivityLogin.this,
                                    "Error: " + task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void addUserToDatabase(final FirebaseUser fbUser) {
        User newUser = new User(getNameFromEmail(fbUser.getEmail()));
        FirebaseDatabase.getInstance().getReference().
                child("users").child(fbUser.getUid()).setValue(newUser);
    }

    @OnClick(R.id.btnLogin)
    void loginClick() {
        if (!isFormValid()) {
            return;
        }
        showProgressDialog();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(KEY_EMAIL, etEmail.getText().toString());
        edit.putString(KEY_PASSWORD, etPassword.getText().toString());
        edit.apply();

        firebaseAuth.signInWithEmailAndPassword(
                etEmail.getText().toString(),
                etPassword.getText().toString()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    startActivity(new Intent(ActivityLogin.this,
                            ActivityUser.class));
                } else {
                    Toast.makeText(ActivityLogin.this, "Error: " +
                                    task.getException().getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Fetching data...");
        }
        progressDialog.show();
    }

    private boolean isFormValid() {
        if (TextUtils.isEmpty(etEmail.getText())) {
            etEmail.setError("The email cannot be empty");
            return false;
        }
        if (TextUtils.isEmpty(etPassword.getText())) {
            etPassword.setError("The password cannot be empty");
            return false;
        }
        return true;
    }

    private String getNameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }
}

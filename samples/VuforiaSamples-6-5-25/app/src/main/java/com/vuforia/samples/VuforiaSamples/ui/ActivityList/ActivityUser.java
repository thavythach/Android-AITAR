package com.vuforia.samples.VuforiaSamples.ui.ActivityList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.app.TapAR.TapAR;
import com.vuforia.samples.VuforiaSamples.app.VuMark.VuMark;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityUser extends AppCompatActivity {

    public static final int REQUEST_CODE_VUMARK = 1001;
    public static final String KEY_VUMARK = "KEY_VUMARK";

    private String vuMarkStr;

    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.tvMark)
    TextView tvMark;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_settings:
                    return true;
                case R.id.navigation_scores:
                    return true;
                case R.id.navigation_logout:
                    FirebaseAuth.getInstance().signOut();
                    finish();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed() {
        FirebaseAuth.getInstance().signOut();
        super.onBackPressed();
    }

    @OnClick(R.id.btnMark)
    void markClick() {
        Intent intent = new Intent(this, VuMark.class);
        startActivityForResult(intent, REQUEST_CODE_VUMARK);
    }

    @OnClick(R.id.btnStart)
    void startClick() {
        startActivity(new Intent(ActivityUser.this, TapAR.class));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_VUMARK) {
            if(resultCode == RESULT_OK) {
                String vuMarkStr = data.getStringExtra(KEY_VUMARK);
                this.vuMarkStr = vuMarkStr;
                tvMark.setText(vuMarkStr);
            }
        }
    }

}

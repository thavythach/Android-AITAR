package com.vuforia.samples.VuforiaSamples.ui.ActivityList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.app.TapAR.TapAR;
import com.vuforia.samples.VuforiaSamples.app.VuMark.VuMark;
import com.vuforia.samples.VuforiaSamples.ui.FragmentList.FragmentDashboard;
import com.vuforia.samples.VuforiaSamples.ui.FragmentList.FragmentRanking;
import com.vuforia.samples.VuforiaSamples.ui.FragmentList.FragmentSettings;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityUser extends AppCompatActivity {

    public static final int REQUEST_CODE_VUMARK = 1001;
    public static final String KEY_VUMARK = "KEY_VUMARK";

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private String vuMarkStr;

    public String getVuMarkStr() {
        return vuMarkStr;
    }

    public void setVuMarkStr(String vuMarkStr) {
        this.vuMarkStr = vuMarkStr;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_settings:
                    showFragment(FragmentSettings.TAG);
                    return true;
                case R.id.navigation_dashboard:
                    showFragment(FragmentDashboard.TAG);
                    return true;
                case R.id.navigation_ranking:
                    showFragment(FragmentRanking.TAG);
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
        navigation.setSelectedItemId(R.id.navigation_dashboard);
    }

    public void showFragment(String fragmentTag) {
        Fragment newFragment = getSupportFragmentManager().findFragmentByTag(fragmentTag);
        if (newFragment == null) {
            switch (fragmentTag) {
                case FragmentSettings.TAG:
                    newFragment = new FragmentSettings();
                    break;
                case FragmentDashboard.TAG:
                    newFragment = new FragmentDashboard();
                    break;
                case FragmentRanking.TAG:
                    newFragment = new FragmentRanking();
                    break;
                default:
                    newFragment = new FragmentDashboard();
                    break;
            }
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, newFragment, fragmentTag);
        ft.addToBackStack("stack");
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        FirebaseAuth.getInstance().signOut();
        super.onBackPressed();
    }

}

package com.vuforia.samples.VuforiaSamples.ui.ActivityList;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.data.User;
import com.vuforia.samples.VuforiaSamples.ui.FragmentList.FragmentDashboard;
import com.vuforia.samples.VuforiaSamples.ui.FragmentList.FragmentRanking;
import com.vuforia.samples.VuforiaSamples.ui.FragmentList.FragmentSettings;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityUser extends AppCompatActivity {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private DatabaseReference usersRef;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

        usersRef = FirebaseDatabase.getInstance().getReference().child("users");
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        usersRef.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = (User) dataSnapshot.getValue(User.class);
                navigation.setOnNavigationItemSelectedListener(
                        mOnNavigationItemSelectedListener);
                navigation.setSelectedItemId(R.id.navigation_dashboard);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                finish();
            }
        });
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

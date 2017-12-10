package com.vuforia.samples.VuforiaSamples.ui.FragmentList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.app.TapAR.TapAR;
import com.vuforia.samples.VuforiaSamples.app.VuMark.VuMark;
import com.vuforia.samples.VuforiaSamples.data.User;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Steven Ye on 12/7/2017.
 */

public class FragmentDashboard extends Fragment {

    public static final String TAG = "FragmentDashboard";

    public static final int REQUEST_CODE_VUMARK = 1001;
    public static final String KEY_VUMARK = "KEY_VUMARK";
    public static final int REQUEST_CODE_TAPAR = 1002;
    public static final String KEY_NAME = "KEY_NAME";

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvKills)
    TextView tvKills;
    @BindView(R.id.tvDeaths)
    TextView tvDeaths;
    @BindView(R.id.btnStart)
    Button btnStart;

    private User user;
    private String vuMark;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, viewRoot);

        if (vuMark == null) {
            btnStart.setVisibility(View.GONE);
        } else {

        }

        user = ((ActivityUser) getActivity()).getUser();
        tvName.setText(user.getName());
        tvKills.setText(String.valueOf(user.getKills()));
        tvDeaths.setText(String.valueOf(user.getDeaths()));

        return viewRoot;
    }

    @OnClick(R.id.btnMark)
    void markClick() {
        Intent intent = new Intent(getActivity(), VuMark.class);
        startActivityForResult(intent, REQUEST_CODE_VUMARK);
    }

    @OnClick(R.id.btnStart)
    void startClick() {
        Intent intent = new Intent(getActivity(), TapAR.class);
        intent.putExtra(KEY_NAME, user.getName());
        intent.putExtra(KEY_VUMARK, vuMark);
        startActivityForResult(intent, REQUEST_CODE_TAPAR);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_VUMARK) {
            if (resultCode == RESULT_OK) {
                String vuMarkStr = data.getStringExtra(KEY_VUMARK);
                vuMark = vuMarkStr;
                btnStart.setVisibility(View.VISIBLE);
            }
        } else if (requestCode == REQUEST_CODE_TAPAR) {
            if (resultCode == RESULT_OK) {

            }
        }
    }
}
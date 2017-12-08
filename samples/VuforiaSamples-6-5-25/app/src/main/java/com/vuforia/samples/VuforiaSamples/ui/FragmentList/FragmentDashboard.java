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
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;
import static com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityUser.KEY_VUMARK;
import static com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityUser.REQUEST_CODE_VUMARK;

/**
 * Created by Steven Ye on 12/7/2017.
 */

public class FragmentDashboard extends Fragment {

    public static final String TAG = "FragmentDashboard";

    @BindView(R.id.btnStart)
    Button btnStart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, viewRoot);

        if (((ActivityUser) getActivity()).getVuMarkStr() == null) {
            btnStart.setVisibility(View.GONE);
        } else {

        }

        return viewRoot;
    }

    @OnClick(R.id.btnMark)
    void markClick() {
        Intent intent = new Intent(getActivity(), VuMark.class);
        startActivityForResult(intent, REQUEST_CODE_VUMARK);
    }

    @OnClick(R.id.btnStart)
    void startClick() {
        startActivity(new Intent(getActivity(), TapAR.class));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_VUMARK) {
            if(resultCode == RESULT_OK) {
                String vuMarkStr = data.getStringExtra(KEY_VUMARK);
                ((ActivityUser) getActivity()).setVuMarkStr(vuMarkStr);
                btnStart.setVisibility(View.VISIBLE);
            }
        }
    }
}
package com.vuforia.samples.VuforiaSamples.ui.FragmentList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityUser;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Steven Ye on 12/7/2017.
 */

public class FragmentAbout extends Fragment {

    public static final String TAG = "FragmentAbout";

    @BindView(R.id.tvSteven)
    TextView tvSteven;

    @BindView(R.id.tvThavy)
    TextView tvThavy;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, viewRoot);

        tvSteven.setText(R.string.steven);
        tvThavy.setText(R.string.thavy);


        return viewRoot;
    }
}

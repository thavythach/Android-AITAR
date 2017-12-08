package com.vuforia.samples.VuforiaSamples.ui.FragmentList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vuforia.samples.VuforiaSamples.R;

/**
 * Created by Steven Ye on 12/7/2017.
 */

public class FragmentRanking extends Fragment {

    public static final String TAG = "FragmentRanking";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_ranking, container, false);

        return viewRoot;
    }
}

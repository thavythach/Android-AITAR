package com.vuforia.samples.VuforiaSamples.ui.FragmentList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.vuforia.samples.VuforiaSamples.Manifest;
import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.app.TapAR.TapAR;
import com.vuforia.samples.VuforiaSamples.app.VuMark.VuMark;
import com.vuforia.samples.VuforiaSamples.data.Player;
import com.vuforia.samples.VuforiaSamples.data.User;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityUser;

import java.util.ArrayList;
import java.util.List;

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
    public static final String KEY_KILLS = "KEY_KILLS";
    public static final String KEY_DEATHS = "KEY_DEATHS";

    @BindView(R.id.btnStart)
    Button btnStart;
    @BindView(R.id.pcStats)
    PieChart pcStats;

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
        drawPieChart();

        if(ContextCompat.checkSelfPermission(getContext(),android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED &&
        ContextCompat.checkSelfPermission(getContext(),android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
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
                int kills = data.getIntExtra(KEY_KILLS, 0);
                int deaths = data.getIntExtra(KEY_DEATHS, 0);
                user.setKills(user.getKills() + kills);
                user.setDeaths(user.getDeaths() + deaths);
                drawPieChart();
                ((ActivityUser) getActivity()).updateUser(user);
            }
        }
    }

    private void drawPieChart() {
        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(user.getKills(), "Kills"));
        entries.add(new PieEntry(user.getDeaths(), "Deaths"));

        IValueFormatter formatter = new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return "" + (int) value;
            }
        };

        PieDataSet pieDataSet = new PieDataSet(entries, "");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(20);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueFormatter(formatter);

        pcStats.setRotationEnabled(true);
        pcStats.setHoleRadius(50f);
        pcStats.setTransparentCircleAlpha(0);
        pcStats.setCenterText(user.getName());
        pcStats.setCenterTextSize(20);
        pcStats.setDrawEntryLabels(true);
        pcStats.setEntryLabelTextSize(20);

        Description desc = new Description();
        desc.setText("");
        pcStats.setDescription(desc);
        pcStats.getLegend().setEnabled(false);

        PieData pieData = new PieData(pieDataSet);
        pcStats.setData(pieData);
        pcStats.invalidate();
    }
}
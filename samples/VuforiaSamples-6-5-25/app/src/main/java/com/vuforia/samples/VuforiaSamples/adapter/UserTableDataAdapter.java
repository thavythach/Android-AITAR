package com.vuforia.samples.VuforiaSamples.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vuforia.samples.VuforiaSamples.data.User;

import java.util.List;

import de.codecrafters.tableview.TableDataAdapter;

/**
 * Created by Steven Ye on 12/13/2017.
 */

public class UserTableDataAdapter extends TableDataAdapter<User> {

    private Context context;

    public UserTableDataAdapter(Context context, List<User> data) {
        super(context, data);
        this.context = context;
    }

    @Override
    public View getCellView(int rowIndex, int columnIndex, ViewGroup parentView) {
        User user = getRowData(rowIndex);
        TextView renderedView = new TextView(context);
        renderedView.setTextColor(Color.WHITE);
        renderedView.setTextSize(18);

        switch (columnIndex) {
            case 0:
                renderedView.setText(user.getName());
                break;
            case 1:
                renderedView.setText(String.valueOf(user.getKills()));
                break;
            case 2:
                renderedView.setText(String.valueOf(user.getDeaths()));
                break;
        }

        return renderedView;
    }

}
package com.vuforia.samples.VuforiaSamples.ui.FragmentList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.adapter.UserTableDataAdapter;
import com.vuforia.samples.VuforiaSamples.data.User;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityUser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.codecrafters.tableview.SortableTableView;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

/**
 * Created by Steven Ye on 12/7/2017.
 */

public class FragmentRanking extends Fragment {

    public static final String TAG = "FragmentRanking";

    @BindView(R.id.stvRanking)
    SortableTableView stvRanking;
    @BindView(R.id.tvNoRanking)
    TextView tvNoRanking;

    private static final String[] TABLE_HEADERS = { "Name", "Kills", "Deaths" };
    private List<User> users;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_ranking, container, false);
        ButterKnife.bind(this, viewRoot);

        ((ActivityUser) getActivity()).getUsersRef().
                addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        users = new ArrayList<>();
                        for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                            User user = userSnapshot.getValue(User.class);
                            users.add(user);
                        }
                        createTable();
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {}
                });

        return viewRoot;
    }

    private void createTable() {
        stvRanking.setColumnComparator(0, new UserNameComparator());
        stvRanking.setColumnComparator(1, new UserKillsComparator());
        stvRanking.setColumnComparator(2, new UserDeathsComparator());
        stvRanking.setEmptyDataIndicatorView(tvNoRanking);
        stvRanking.setHeaderAdapter(new SimpleTableHeaderAdapter(getContext(), TABLE_HEADERS));
        stvRanking.setDataAdapter(new UserTableDataAdapter(getContext(), users));
    }

    private static class UserNameComparator implements Comparator<User> {
        @Override
        public int compare(User user1, User user2) {
            return user1.getName().compareTo(user2.getName());
        }
    }

    private static class UserKillsComparator implements Comparator<User> {
        @Override
        public int compare(User user1, User user2) {
            return Double.compare(user1.getKills(), user2.getKills());
        }
    }

    private static class UserDeathsComparator implements Comparator<User> {
        @Override
        public int compare(User user1, User user2) {
            return Double.compare(user1.getDeaths(), user2.getDeaths());
        }
    }
}
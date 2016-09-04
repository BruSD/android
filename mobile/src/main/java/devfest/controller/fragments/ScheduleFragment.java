package devfest.controller.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import devfest.controller.R;
import devfest.controller.model.Schedule;
import devfest.controller.model.Sessions;
import devfest.controller.model.Speaker;
import devfest.controller.utils.FB;

/**
 * Created by Brusd on 7/17/2016.
 */

public class ScheduleFragment extends Fragment {

    private static final String TAG = ScheduleFragment.class.getName();
    private View v;
    private Context mContext;
    private ArrayList<Schedule> schedules;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private FB fb;

    private ScheduleFragment.ScheduleFragmentInteractionListener mCallBack;

    public interface ScheduleFragmentInteractionListener {
        void onScheduleSelected(ImageView speakerImage, Speaker speaker, int position);
    }

//    private SpeakersAdapter.OnSpeakerClickListener mSpeakersItemClickListener = new SpeakersAdapter.OnSpeakerClickListener() {
//        @Override
//        public void onSpeakerClick(ImageView speakerImage, Speaker speaker, int position) {
//            Log.d(TAG, "onClick: pos " + position + " speaker : " + speaker);
//            mCallBack.onScheduleSelected(speakerImage, speaker, position);
//        }
//    };

    public static ScheduleFragment newInstance() {
        ScheduleFragment fragment = new ScheduleFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_schedule, container, false);
        mContext = getActivity();
        mRecyclerView = (RecyclerView) v.findViewById(R.id.schedule_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getContext());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        fb = FB.getInstance();
        getSchedule();
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mCallBack = ((ScheduleFragment.ScheduleFragmentInteractionListener) getActivity());
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement SpeakerFragmentInteractionListener");
//        }
    }

    public void getSchedule() {
        DatabaseReference myRef = fb.getScheduleRef();
        myRef.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        schedules = new ArrayList<Schedule>();
                        dataSnapshot.getChildrenCount();
                        for (DataSnapshot o : dataSnapshot.getChildren()) {
                            Schedule schedule = o.getValue(Schedule.class);
                            schedules.add(schedule);
                        }
                        initList(schedules);
                        Log.e(TAG, "Current Childe" + schedules.size());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                });
    }

    private void initList(ArrayList<Schedule> dataSnapshots) {
        // specify an adapter (see also next example)
//        SpeakersAdapter mAdapter = new SpeakersAdapter(dataSnapshots, (BaseActivity) getActivity(), mSpeakersItemClickListener);
//        mRecyclerView.setItemViewCacheSize(dataSnapshots.size());
//        mRecyclerView.setAdapter(mAdapter);
    }
}

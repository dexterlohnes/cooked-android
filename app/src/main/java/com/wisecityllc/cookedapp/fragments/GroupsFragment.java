package com.wisecityllc.cookedapp.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wisecityllc.cookedapp.R;
import com.wisecityllc.cookedapp.adapters.GroupsAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.wisecityllc.cookedapp.fragments.GroupsFragment.GroupsFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GroupsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroupsFragment extends Fragment {

    private GroupsFragmentInteractionListener mListener;

    private GroupsAdapter mGroupsAdapter;
    private ListView mGroupsListView;

    private int mAdapterMode;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GroupsFragment.
     */

    public static GroupsFragment newInstance(int mode) {
        GroupsFragment fragment = new GroupsFragment();
        Bundle argsBundle = new Bundle();
        argsBundle.putInt("mode", mode);
        fragment.setArguments(argsBundle);
        return fragment;
    }

    public GroupsFragment() {
        mAdapterMode = GroupsAdapter.ALL_GROUPS;
    }

    public void notifyGroupsDataUpdated() {
        if(mGroupsAdapter != null)
            mGroupsAdapter.loadObjects();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize main ParseQueryAdapter
        mGroupsAdapter = new GroupsAdapter(getActivity(), getArguments().getInt("mode", 0));

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(mGroupsListView == null){
            mGroupsListView = (ListView)view.findViewById(R.id.groups_frag_list_view);
        }

        mGroupsListView.setAdapter(mGroupsAdapter);

        mGroupsAdapter.loadObjects();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_groups, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mGroupsListView = null;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (GroupsFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface GroupsFragmentInteractionListener {
//        public void onFragmentInteraction(Uri uri);
    }



}

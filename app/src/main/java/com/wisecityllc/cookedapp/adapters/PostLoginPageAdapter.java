package com.wisecityllc.cookedapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wisecityllc.cookedapp.fragments.AlertsFragment;
import com.wisecityllc.cookedapp.fragments.EventsFragment;
import com.wisecityllc.cookedapp.fragments.GroupsFragment;
import com.wisecityllc.cookedapp.fragments.WellnessFragment;

/**
 * Created by dexterlohnes on 6/29/15.
 */
public class PostLoginPageAdapter extends FragmentPagerAdapter {
    private static final int GROUPS_FRAGMENT = 0;
    private static final int ALERTS_FRAGMENT = 1;
    private static final int EVENTS_FRAGMENT = 2;
    private static final int WELLNESS_FRAGMENT = 3;

    private GroupsFragment mGroupsFragment;
    private AlertsFragment mAlertsFragment;
    private EventsFragment mEventsFragment;

    public PostLoginPageAdapter (FragmentManager fm) {
        super(fm);
        mGroupsFragment = GroupsFragment.newInstance(GroupsQueryAdapter.MEMBER_AND_ADMIN_ONLY);
        mAlertsFragment = AlertsFragment.newInstance();
        mEventsFragment = new EventsFragment();
    }

    public void notifyGroupsDataUpdated(){
        mGroupsFragment.notifyGroupsDataUpdated();
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case GROUPS_FRAGMENT : return mGroupsFragment;
            case ALERTS_FRAGMENT : return mAlertsFragment;
            case EVENTS_FRAGMENT : return mEventsFragment;
            case WELLNESS_FRAGMENT : return new WellnessFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case GROUPS_FRAGMENT : return "Groups";
            case ALERTS_FRAGMENT : return "Alerts";
            case EVENTS_FRAGMENT : return "Events";
            case WELLNESS_FRAGMENT : return "Wellness";
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
package com.mancj.example.Page;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class AccountAdapter extends FragmentStatePagerAdapter {
    int TabsNumber;

    public AccountAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        TabsNumber = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                PreferencesFragment preferencesFragment = new PreferencesFragment();
                return preferencesFragment;
            case 1:
                RewardsFragment rewardsFragment = new RewardsFragment();
                return rewardsFragment;
            case 2:
                PurchaseHistoryFragment purchaseHistoryFragment = new PurchaseHistoryFragment();
                return purchaseHistoryFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TabsNumber;
    }
}

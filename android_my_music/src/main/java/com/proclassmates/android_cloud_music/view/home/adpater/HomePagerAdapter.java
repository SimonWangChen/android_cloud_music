package com.proclassmates.android_cloud_music.view.home.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.proclassmates.android_cloud_music.view.mine.MineFragment;
import com.proclassmates.android_cloud_music.view.discory.DiscoryFragment;
import com.proclassmates.android_cloud_music.view.friend.FriendFragment;
import com.proclassmates.android_cloud_music.view.home.model.CHANNEL;


/**
 * 首页ViewPger的Adpater
 */
public class HomePagerAdapter extends FragmentPagerAdapter {
    private CHANNEL[] mList;

    public HomePagerAdapter(FragmentManager fm, CHANNEL[] datas) {
        super(fm);
        mList = datas;
    }

    //初始化对应的fragment
    @Override
    public Fragment getItem(int position) {
        int type = mList[position].getValue();
        switch (type) {
            case CHANNEL.MINE_ID:
                return MineFragment.newInstance();
            case CHANNEL.DISCORY_ID:
                return DiscoryFragment.newInstance();
            case CHANNEL.FRIEND_ID:
                return FriendFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.length;
    }
}

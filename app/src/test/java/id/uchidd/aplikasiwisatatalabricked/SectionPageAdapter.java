package id.uchidd.aplikasiwisatatalabricked;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTittleList = new ArrayList<>();

    public void addfragment(Fragment fragment,String title){
        mFragmentList.add(fragment);
        mFragmentTittleList.add(title);
    }

    public SectionPageAdapter (@NonNull FragmentManager fm){
        super(fm);}

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTittleList.get(position);
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }
    @Override
    public int getCount() {
        return mFragmentTittleList.size();
    }


}

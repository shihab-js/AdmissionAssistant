package shihab.mypro.com.gridviewex.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by shihab on 11/4/2017.
 */

public class ViewPageAdapter  extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    ArrayList<String> arrayListTabTitle = new ArrayList<>();


    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    public void addFragment(Fragment fragment, String tabTitle){
        fragmentArrayList.add(fragment);
        arrayListTabTitle.add(tabTitle);
    }

    @Override
    public CharSequence getPageTitle(int position){
        return arrayListTabTitle.get(position);
    }



}

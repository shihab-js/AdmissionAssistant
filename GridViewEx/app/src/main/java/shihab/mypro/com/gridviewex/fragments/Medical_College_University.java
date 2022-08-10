package shihab.mypro.com.gridviewex.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import shihab.mypro.com.gridviewex.R;
import shihab.mypro.com.gridviewex.adapter.CustomAdapterForGeneralList;
/**
 * Created by shihab on 11/4/2017.
 */

public class Medical_College_University extends Fragment {

    View view;
    ListView listViewProduct;
    private int[] medical_university_Image = {R.drawable.ic_bsmmu,R.drawable.ic_dmc,R.drawable.ic_cmc,R.drawable.ic_rmc,R.drawable.ic_rpmc,R.drawable.ic_somc,
    R.drawable.ic_amumc,R.drawable.ic_shsmc,R.drawable.ic_ssmc,R.drawable.ic_mmc,R.drawable.ic_sbmc,R.drawable.ic_comc,R.drawable.ic_kmc,R.drawable.ic_szrmc,
    R.drawable.ic_djmc,R.drawable.ic_fmc,R.drawable.ic_pmc,R.drawable.ic_afmc,R.drawable.ic_coxmc,R.drawable.ic_jmc,R.drawable.ic_ssnimc,R.drawable.ic_kumc,
    R.drawable.ic_smc,R.drawable.ic_sskmc,R.drawable.ic_stamc,R.drawable.ic_tmc,R.drawable.ic_jpmc,R.drawable.ic_ccmc,R.drawable.ic_smmamc,R.drawable.ic_pkmc,
    R.drawable.ic_rmmc,R.drawable.ic_mumc,R.drawable.ic_ddc};
    private String[] medical_university_Name;
    CustomAdapterForGeneralList customAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.medical_college_university,container,false);

        listViewProduct = (ListView) view.findViewById(R.id.listViewProduct);

        medical_university_Name = getResources().getStringArray(R.array.medical_versity_name);

        customAdapter = new CustomAdapterForGeneralList(getContext(), medical_university_Name,medical_university_Image);
        listViewProduct.setAdapter(customAdapter);

        return view;


    }

}

package shihab.mypro.com.gridviewex.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import shihab.mypro.com.gridviewex.EngineeringVersityDetails;
import shihab.mypro.com.gridviewex.GeneralVersityDetails;
import shihab.mypro.com.gridviewex.R;
import shihab.mypro.com.gridviewex.adapter.CustomAdapterForGeneralList;

/**
 * Created by shihab on 11/4/2017.
 */

public class Engineering_University extends Fragment {

    View view;
    ListView listViewProduct;
    private int[] eng_university_Image = {R.drawable.ic_buet,R.drawable.ic_cuet,R.drawable.ic_ruet,R.drawable.ic_kuet,
            R.drawable.ic_duet,R.drawable.ic_sust,R.drawable.ic_nstu,R.drawable.ic_hstu,R.drawable.ic_pust,
            R.drawable.ic_just,R.drawable.ic_pstu,R.drawable.ic_mbstu,R.drawable.ic_bsmrstu};
    private String[] eng_university_Name;
    CustomAdapterForGeneralList customAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.engineering_university,container,false);

        listViewProduct = (ListView) view.findViewById(R.id.listViewProduct);

        eng_university_Name = getResources().getStringArray(R.array.engineer_versity_name);

        customAdapter = new CustomAdapterForGeneralList(getContext(), eng_university_Name,eng_university_Image);
        listViewProduct.setAdapter(customAdapter);


        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), EngineeringVersityDetails.class);

                intent.putExtra("position",position);

                startActivity(intent);


            }
        });


        return view;



    }
}

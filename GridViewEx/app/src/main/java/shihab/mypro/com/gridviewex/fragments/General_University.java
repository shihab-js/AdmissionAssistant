package shihab.mypro.com.gridviewex.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import shihab.mypro.com.gridviewex.GeneralVersityDetails;
import shihab.mypro.com.gridviewex.R;
import shihab.mypro.com.gridviewex.adapter.CustomAdapter;
import shihab.mypro.com.gridviewex.adapter.CustomAdapterForGeneralList;
import shihab.mypro.com.gridviewex.university_details.GeneralUniversity;

/**
 * Created by shihab on 11/4/2017.
 */

public class General_University extends Fragment {


    View view;

    ListView listViewProduct;
    private int[] university_Image = {R.drawable.ic_du,R.drawable.ic_ru,R.drawable.ic_brur,R.drawable.ic_bu,
            R.drawable.ic_cou,R.drawable.ic_cu,R.drawable.ic_iu,R.drawable.ic_jnu,R.drawable.ic_ku,R.drawable.ic_ju,R.drawable.ic_jkkniu};
    private String[] university_Name;
    CustomAdapterForGeneralList customAdapter;



    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.general_university,container,false);
        listViewProduct = (ListView) view.findViewById(R.id.listViewProduct);

        university_Name = getResources().getStringArray(R.array.general_versity_name);

        customAdapter = new CustomAdapterForGeneralList(getContext(), university_Name, university_Image);
        listViewProduct.setAdapter(customAdapter);

        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), GeneralVersityDetails.class);

                intent.putExtra("position",position);

                startActivity(intent);


            }
        });





        return view;

    }
}

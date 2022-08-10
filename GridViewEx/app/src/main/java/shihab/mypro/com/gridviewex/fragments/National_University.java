package shihab.mypro.com.gridviewex.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import shihab.mypro.com.gridviewex.R;

/**
 * Created by shihab on 11/4/2017.
 */

public class National_University extends Fragment{

    View view;
    TextView versity_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.national_university,container,false);

        versity_name =(TextView) view.findViewById(R.id.text_View_name);


        String str = "<h2>Dhaka Division</h2>"+
                "\tEden Mohila College, Dhaka<br>" +
                "\tDhaka College, Dhaka<br>" +
                "\tDhaka Commerce College, Dhaka (Private)<br>" +
                "\tLalmatia Mohila College, Dhaka (Private)<br>" +
                "\tGovernment Titumir College, Dhaka<br>" +
                "\tGovernment Bangla College, Dhaka<br>" +
                "\tDhaka City College, Dhaka (Private)<br>" +
                "\tKabi Nazrul Government College, Dhaka<br>"+

                "<h2>Chittagong Division</h2>" +
                "\tChittagong Govt College, Chittagong<br>" +
                "\tComilla Victoria Government College<br>" +
                "\tFeni Government College, Feni<br>" +
                "\tGovernment City College, Chittagong<br>" +
                "\tGovernment Mohila College, Chittagong<br>" +
                "\tGovernment Hazi Mohammad Mohsin College, Chittagong<br>" +
                "\tPatiya Govt. College Chittagong<br>" +
                "\tLakshmipur Government College, Lakshmipur<br>" +
                "\tBrahmanbaria Government College<br>" +
                "\tOmargoni MES College, Chittagong (Private)<br>"+

                "<h2>Rajshahi Division</h2>" +
                "\tRajshahi College, Rajshahi<br>" +
                "\tGovernment Azizul Haque College, Bogra<br>" +
                "\tSirajganj Government College, Sirajganj<br>" +
                "\tVobanigonj College, Rajshahi (Private)<br>" +
                "\tSayed Ahmed College, Bogra (Private)<br>" +
                "\tGovernment Women’s College Rajshahi<br>" +
                "\tNawabganj Govt. College, Chapainawabganj<br>" +
                "\tNaogaon Government College, Naogaon<br>" +
                "\tGovt Mujibur Rahman Mohila College Bogra<br>" +
                "\tNew Govt Degree College Rajshahi<br>"+

                "<h2>Khulna Division</h2>" +
                "\tGovt MM College Jessore<br>" +
                "\tKumira Mohila Degree College, Satkhira (Private)<br>" +
                "\tGovt Mohila College Jessore<br>" +
                "\tChuadanga Govt College, Chuadanga<br>" +
                "\tUposhohor Mohila Degree College, Jessore (Private)<br>" +
                "\tSatkhira City College, Satkhira (Private)<br>" +
                "\tKustia Govt. Mohila College, Kushtia<br>" +
                "\tGovt. P. C. College, Bagerhat<br>" +
                "\tGovt. Shyam Nagar Mohsin College, Satkhira<br>" +
                "\tNoapara college,Jessore (Private)<br>"+

                "<h2>Barisal Division</h2>" +
                "\tGovt. Brojomohun College, Barishal<br>" +
                "\tGovt Mohila College, Barishal<br>" +
                "\tGovt Barishal College, Barishal<br>" +
                "\tBhola Govt College, Bhola<br>" +
                "\tBarguna Govt College, Barguna<br>" +
                "\tGovt. Syed Hatem Ali College Barisal<br>" +
                "\tGovt. Suhrawardy College – Pirojpur<br>" +
                "\tCharfassion Govt. College, Bhola<br>" +
                "\tGovt. Fazlul Haque College, Barisal<br>"+


                "<h2>Sylhet Division</h2>" +
                "\tSylhet MC College, Sylhet<br>" +
                "\tBrindaban Govt College Habiganj<br>" +
                "\tGovt Mohila College, Sylhet<br>" +
                "\tMoulvibazar Govt College, Moulvibazar<br>" +
                "\tMadan Mohon College, Sylhet (Private)<br>" +
                "\tSunamganj Govt College, Sunamganj<br>" +
                "\tDakshin Surma College, Sylhet (Private)<br>" +
                "\tSreemangal Govt. College, Maulvibazar<br>"+

                "<h2>Rangpur Division</h2>" +
                "\tCarmichael College Rangpur<br>" +
                "\tDinajpur Govt College, Dinajpur<br>" +
                "\t Alimuddin College, Lalmonirhat (Private)<br>" +
                "\tGovt. Begum Rokeya College Rangpur<br>" +
                "\tKurigram Govt College, Kurigram<br>" +
                "\tUttar Bangla College Lalmonirhat(Private)<br>" +
                "\tNilphamari Govt. College, Nilphamari<br>" +
                "\tDinajpur Govt Mohila College, Dinajpur<br>" +
                "\tLalmonirhat Govt. College, Lalmonirhat<br>" +
                "\tRangpur Govt. College, Rangpur<br>"+


                "<h2>Mymensingh Division</h2>"+
                "\tGovernment Saadat College, Tangail<br>" +
                "\tAnondo Mohon College, Mymensingh<br>";

        versity_name.setText(Html.fromHtml(str));




        return view;
    }

}

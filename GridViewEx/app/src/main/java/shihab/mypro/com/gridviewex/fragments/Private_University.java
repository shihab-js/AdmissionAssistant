package shihab.mypro.com.gridviewex.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import shihab.mypro.com.gridviewex.R;
import shihab.mypro.com.gridviewex.adapter.CustomAdapterForGeneralList;

/**
 * Created by shihab on 11/4/2017.
 */

public class Private_University extends Fragment {

    View view;
    TextView versity_name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.private_university,container,false);

        versity_name =(TextView) view.findViewById(R.id.text_View_name);

        String str = "<h4>Ahsanullah Universityof Science and Technology</h4>"+
                "<h4>American International University Bangladesh (AIUB) </h4>"+
                "<h4>Anwer Khan Modern University</h4>" +
                "<h4>Army University of Engineering and Technology (BAUET), Qadirabad</h4>\n" +
                "<h4>Army University of Science and Technology(BAUST), Saidpur</h4>\n" +
                "<h4>ASA University Bangladesh (ASAUB) </h4>\n" +
                "<h4>Asian University of Bangladesh (AUB) </h4>\n" +
                "<h4>Atish Dipankar University of Science & Technology</h4>\n" +
                "<h4>Bangladesh Army International University of Science & Technology, Comilla</h4>\n" +
                "<h4>Bangladesh Islami University (BIU) </h4>\n" +
                "<h4>Bangladesh University (BU) </h4>\n" +
                "<h4>Bangladesh University of Business & Technology (BUBT) </h4>\n" +
                "<h4>Bangladesh University of Health Sciences</h4>\n" +
                "<h4>BGC Trust University Bangladesh, Chittagong</h4>\n" +
                "<h4>BGMEA University of Fashion & Technology</h4>\n" +
                "<h4>BRAC University</h4>\n" +
                "<h4>Britannia University</h4>\n" +
                "<h4>Canadian University of Bangladesh</h4>\n" +
                "<h4>CCN University of Science & Technology</h4>\n" +
                "<h4>Central University of Science and Technology</h4>\n" +
                "<h4>Central Women’s University</h4>\n" +
                "<h4>Chittagong Independent University (CIU) </h4>\n" +
                "<h4>City University</h4>\n" +
                "<h4>Coxs Bazar International University</h4>\n" +
                "<h4>Daffodil International University</h4>\n" +
                "<h4>Dhaka International University</h4>\n" +
                "<h4>East Delta University, Chittagong</h4>\n" +
                "<h4>East West University</h4>\n" +
                "<h4>Eastern University</h4>\n" +
                "<h4>European University of Bangladesh</h4>\n" +
                "<h4>Exim Bank Agricultural University, Bangladesh</h4>\n" +
                "<h4>Fareast International University</h4>\n" +
                "<h4>Feni University</h4>\n" +
                "<h4>First Capital University of Bangladesh</h4>\n" +
                "<h4>German University Bangladesh</h4>\n" +
                "<h4>Global University Bangladesh</h4>\n" +
                "<h4>Gono Bishwabidyalay</h4>\n" +
                "<h4>Green University of Bangladesh</h4>\n" +
                "<h4>Hamdard University Bangladesh</h4>\n" +
                "<h4>IBAIS University</h4>\n" +
                "<h4>Independent University, Bangladesh (IUB) </h4>\n" +
                "<h4>International Islamic University, Chittagong</h4>\n" +
                "<h4>International University of Business Agriculture & Technology</h4>\n" +
                "<h4>Ishakha International University</h4>\n" +
                "<h4>Khwaja Yunus Ali University</h4>\n" +
                "<h4>Leading University, Sylhet</h4>\n" +
                "<h4>Manarat International University</h4>\n" +
                "<h4>Metropolitan University, Sylhet</h4>\n" +
                "<h4>N.P.I University of Bangladesh</h4>\n" +
                "<h4>North Bengal International University</h4>\n" +
                "<h4>North East University Bangladesh</h4>\n" +
                "<h4>North South University (NSU) </h4>\n" +
                "<h4>North Western University, Khulna</h4>\n" +
                "<h4>Northern University Bangladesh</h4>\n" +
                "<h4>Northern University of Business & Technology, Khulna</h4>\n" +
                "<h4>Notre Dame University Bangladesh</h4>\n" +
                "<h4>Port City International University</h4>\n" +
                "<h4>Premier University,Chittagong</h4>\n" +
                "<h4>Presidency University</h4>\n" +
                "<h4>Prime University</h4>\n" +
                "<h4>Primeasia University</h4>\n" +
                "<h4>Pundro University of Science & Technology</h4>\n" +
                "<h4>Queens University</h4>\n" +
                "<h4>Rabindra Moitri University, Kushtia</h4>\n" +
                "<h4>Rajshahi Science & Technology University (RSTU), Natore</h4>\n" +
                "<h4>Ranada Prasad Shaha University</h4>\n" +
                "<h4>Royal University of Dhaka (RUD) </h4>\n" +
                "<h4>Shanto Mariam University of Creative Technology</h4>\n" +
                "<h4>Sheikh Fazilatunnesa Mujib University</h4>\n" +
                "<h4>Sonargaon University</h4>\n" +
                "<h4>Southeast University</h4>\n" +
                "<h4>Southern University of Bangladesh, Chittagong</h4>\n" +
                "<h4>Stamford University, Bangladesh</h4>\n" +
                "<h4>State University Of Bangladesh</h4>\n" +
                "<h4>Sylhet International University, Sylhet</h4>\n" +
                "<h4>The International University of Scholars</h4>\n" +
                "<h4>The Millenium University</h4>\n" +
                "<h4>The Peoples University of Bangladesh</h4>\n" +
                "<h4>The University of Asia Pacific</h4>\n" +
                "<h4>Times University Bangladesh</h4>\n" +
                "<h4>United International University (UIU) </h4>\n" +
                "<h4>University of Creative Technology, Chitagong</h4>\n" +
                "<h4>University of Development Alternative (UODA) </h4>\n" +
                "<h4>University of Information Technology & Sciences</h4>\n" +
                "<h4>University of Liberal Arts Bangladesh</h4>\n" +
                "<h4>University of Science & Technology, Chittagong</h4>\n" +
                "<h4>University of South Asia</h4>\n" +
                "<h4>Uttara University</h4>\n" +
                "<h4>Varendra University</h4>\n" +
                "<h4>Victoria University of Bangladesh</h4>\n" +
                "<h4>World University of Bangladesh</h4>\n" +
                "<h4>Z.H Sikder University of Science & Technology</h4>\n";


        versity_name.setText(Html.fromHtml(str));


        return view;
    }
}

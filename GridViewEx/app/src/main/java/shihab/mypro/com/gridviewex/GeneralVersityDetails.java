package shihab.mypro.com.gridviewex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import shihab.mypro.com.gridviewex.university_details.GeneralUniversity;

public class GeneralVersityDetails extends AppCompatActivity {

    TextView versity_details;
    GeneralUniversity generalUniversity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_versity_details);
        getSupportActionBar().setTitle("Versity Details");


        versity_details = (TextView) findViewById(R.id.versity_details);

        generalUniversity = new GeneralUniversity();

        int position = getIntent().getExtras().getInt("position");

        String generalInfo =  generalUniversity.getGeneralInformation(position);
        String faclityInfo = generalUniversity.getFacultyAndDepartment(position);
        String hallInfo = generalUniversity.getHallinfo(position);
        String admissionInfo = generalUniversity.getAdminssionUnit(position);

        String details = generalInfo+faclityInfo+hallInfo+admissionInfo;

        versity_details.setText(Html.fromHtml(details));

    }
}

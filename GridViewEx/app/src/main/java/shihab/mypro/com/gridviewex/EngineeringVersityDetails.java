package shihab.mypro.com.gridviewex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import shihab.mypro.com.gridviewex.university_details.EngineeringUniversity;

public class EngineeringVersityDetails extends AppCompatActivity {

    TextView versity_details;
    EngineeringUniversity engineeringUniversity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.engineering_versity_details);
        getSupportActionBar().setTitle("Versity Details");

        versity_details = (TextView) findViewById(R.id.versity_details);

        engineeringUniversity = new EngineeringUniversity();

        int position = getIntent().getExtras().getInt("position");

        String generalInfo =  engineeringUniversity.getGeneralInfo(position);
        String faclityInfo = engineeringUniversity.getDeptInfo(position);
        String hallInfo = engineeringUniversity.getHallInfo(position);
        String admissionInfo = engineeringUniversity.getUnitInfo(position);

        String details = generalInfo+faclityInfo+hallInfo+admissionInfo;

        versity_details.setText(Html.fromHtml(details));


    }
}

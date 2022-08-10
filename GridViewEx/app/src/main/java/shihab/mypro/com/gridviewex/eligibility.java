package shihab.mypro.com.gridviewex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.util.ArrayList;

import static com.nightonke.boommenu.ButtonEnum.TextOutsideCircle;

public class eligibility extends AppCompatActivity {

    BoomMenuButton bmb;
    TextView versity_name;
    ArrayList<Integer> icons;
    ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility);
        getSupportActionBar().setTitle("Eligibility");

        versity_name =(TextView)findViewById(R.id.versity_name);

        icons = new ArrayList<>();
        titles = new ArrayList<>();
        setInitialize();

        //Floting point action button for boom menu
        bmb = (BoomMenuButton) findViewById(R.id.bmbMenu);
        bmb.setButtonEnum(TextOutsideCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_5_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_5_1);


        //set icon of boom menu
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {

            int position = i;
            TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                    .normalImageRes(icons.get(position))
                    .normalText(titles.get(position))
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {

                            if(index==0){
                                Intent intent = new Intent(getApplicationContext(), UniversityCatagoryActivity.class);
                                startActivity(intent);


                            }
                            if(index==1){

                                Intent intent = new Intent(getApplicationContext(), eligibility.class);
                                startActivity(intent);

                            }
                            if(index==2){

                                Intent intent = new Intent(getApplicationContext(), preparation.class);
                                startActivity(intent);

                            }
                            if(index==3){

                                Intent intent = new Intent(getApplicationContext(), student_forum.class);
                                startActivity(intent);

                            }
                            if(index==4){

                                Intent intent = new Intent(getApplicationContext(), google_mate.class);
                                startActivity(intent);

                            }


                        }
                    });


            bmb.addBuilder(builder);
        }


        String str = getData();

        versity_name.setText(Html.fromHtml(str));




    }

    private String getData() {

        String str = "<h2>Public Universities:- </h2>" +
                "<h4>University of Dhaka (DU): </h4>" +
                "A (Science):- <br>" +
                "\tTotal-8.0 (SSC-3.5, HSC-3.5) With 4th, Both Science <br>" +
                "B (Arts):- <br>" +
                "\tTotal-7.0 (SSC-3.0, HSC-3.0) With 4th, Arts <br>" +
                "C (Business Studies):- <br>" +
                "\tTotal-7.50 (SSC-3.5, HSC-3.5) With 4th, Business <br>" +
                "D (Transfer):- Which is eligible for Unit A, B, C <br>" +
                "F (Charukola):- <br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) With 4th, All Group <br>"+



                "<h4>University of Chittagong (CU): </h4>" +
                "A (Science & Engineering):- <br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) With 4th, Both Science <br>" +
                "B (Arts):- <br>" +
                "\tTotal-6.0 (SSC-2.75, HSC-2.75) With 4th, Both Science<br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) With 4th, Business<br>" +
                "\tTotal-5.5 (SSC-2.25, HSC-2.25) With 4th, Arts <br>" +
                "C (Business Studies):- <br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) With 4th, Business <br>" +
                "D (Social Science, Law & Others):- <br>" +
                "\tTotal-5.5 (SSC-2.25, HSC-2.25) With 4th, All Group <br>"+




                "<h4>University of Rajshahi (RU): </h4>" +
                "B, C, E, F, G, H, I :- Total-8.0 (SSC-3.5, HSC-3.5) With 4th, HSC Science <br>" +
                "B, D, E, G, I :- Total-7.50 (SSC-3.5, HSC-3.5) With 4th, HSC Business <br>" +
                "A, B, E, F, G, I :- Total-7.0 (SSC-3.0, HSC-3.0) With 4th, HSC Arts A (Arts), <br>" +
                "B (Law), C (Science), D (Business Studies), E (Social Science), <br>" +
                "F (Zoology & Geography), G (Agriculture), H (Engineering), I (Charukola) <br>"+



                "<h4>Jahangirnagar University (JU): </h4>" +
                "A (Math & Physics):- <br>" +
                "\tTotal-7.5 (SSC-3.5, HSC-3.5) With 4th, Both Science <br>" +
                "B (Social Science):- <br>" +
                "\tTotal-7.0 (SSC-3.5, HSC-3.5) With 4th, All Group <br>" +
                "C (Arts):- <br>" +
                "\tTotal-7.0 (SSC-3.0, HSC-3.0) With 4th, All Group <br>" +
                "D (Zoology):- <br>" +
                "\tTotal-7.5 (SSC-3.5, HSC-3.5) With 4th, Both Science <br>" +
                "E (Business Studies): <br>" +
                "\tTotal-7.5 (SSC-3.5, HSC-3.5) With 4th, Both Science<br>" +
                "\tTotal-7.0 (SSC-3.5, HSC-3.5) With 4th, Arts & Business <br>" +
                "F (Law): <br>" +
                "\tTotal-8.0 (SSC-3.5, HSC-3.5) With 4th, All Group <br>" +
                "G (IBA):- <br>" +
                "\tTotal-8.5 (SSC-4.0, HSC-4.0) With 4th, Both Science<br>" +
                "\tTotal-8.0 (SSC-4.0, HSC-4.0) With 4th, Arts & Business <br>" +
                "H (IIT):- <br>" +
                "\tTotal-8.0 (SSC-3.5, HSC-3.5) With 4th, Both Science <br>"+




                "<h4>Jagannath University (JNU): </h4>" +
                "A (Science):- <br>" +
                "\tTotal-8.5 with 4th, Both Science <br>" +
                "B (Arts):- <br>" +
                "\tTotal-8.0 (SSC-3.5, HSC-3.5) With 4th, Both Arts <br>" +
                "C (Business Studies):- <br>" +
                "\tTotal-8.5 with 4th, Business <br>" +
                "D (Social Science, Law, Others):- <br>" +
                "\tWhich is eligible for Unit A, B, C <br>" +
                "E (Charukola):-<br>"+
                "\tTotal-7.0 (SSC-3.0, HSC-3.0) With 4th, All Group <br>"+




                "<h4>Khulna University (KU): </h4>" +
                "A (Science, Engineering & Zoology):- <br>" +
                "\tTotal-9.0 (SSC-4.5, HSC-4.5) With 4th, Both Science <br>" +
                "B (Arts, Law & Charukola):- <br>" +
                "\t-7.0 (SSC-3.5, HSC-3.5) With 4th, All Group <br>" +
                "C (Business Studies & Social Science):- <br>" +
                "\tTotal-8.5 (SSC-4.25, HSC-4.25) With 4th, All Group <br>"+



                "<h4>Comilla University (COU): </h4>" +
                "A (Science & Engineering):- <br>" +
                "\tTotal-6.5 With 4th, Both Science <br>" +
                "B (Arts, Law & Social Science):- <br>" +
                "\tTotal-6.0 With 4th, All Group <br>" +
                "C (Business Studies):- <br>" +
                "\tTotal-6.0 With 4th, All Group <br>"+




                "<h4>University of Barisal (BU): </h4>" +
                "A (Science, Engineering & Zoology):- <br>" +
                "\tTotal-7.0 (SSC-3.0, HSC-3.0) With 4th, Both Science <br>" +
                "B (Arts, Social Science & Low):- <br>" +
                "\tTotal-6.0 (SSC-3.0, HSC-3.0) With 4th, All Group <br>" +
                "C (Business Studies):- <br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) With 4th, All Group <br>"+



                "<h4>Begum Rokeya University, Rangpur (BRUR): </h4>" +
                "A (Arts):- <br>" +
                "\tTotal-6.0 (SSC-3.0, HSC-3.0) With 4th, All Group <br>" +
                "B (Social Science):- <br>" +
                "\tTotal-7.5 (SSC-3.5, HSC-3.5) With 4th, Science & Business<br>" +
                "\tTotal-7.0 (SSC-3.5, HSC-3.0) With 4th, Arts <br>" +
                "C (Business Studies):- <br>" +
                "\tTotal-7.5 (SSC-3.5, HSC-3.5) With 4th, Both Science<br>" +
                "\tTotal-7.0 (SSC-3.0, HSC-3.5) With 4th, Business & Arts<br>" +
                "D (Science):- <br>" +
                "\tTotal-7.5 (SSC-4.0, HSC-3.5) With 4th, Both Science<br>" +
                "E (Engineering & Technology):- <br>" +
                "\tTotal-7.5 (SSC-4.0, HSC-3.5) With 4th, Both Science<br>" +
                "F (Geography):-<br>" +
                "\tTotal-7.5 (SSC-4.0, HSC-3.5) With 4th, Both Science<br>" +
                "\tTotal-7.0 (SSC-3.5, HSC-3.0) With 4th, Business & Arts <br>"+


                "<h4>Jatiya Kabi Kazi Nazrul IslamUniversity (JKKNIU): </h4>" +
                "AL (Arts):- <br>" +
                "\tTotal-7.5 (SSC-3.5, HSC-3.5) With 4th, Both Science<br>" +
                "\tTotal-7.0 (SSC-3.5, HSC-3.5) With 4th, Business & Arts <br>" +
                "AP (Charukola):- <br>" +
                "\tTotal-6.0 (SSC-3.0, HSC-3.0) With 4th, All Group<br>" +
                "B (Engineering):- <br>" +
                "\tTotal-7.0 (SSC-3.0, HSC-3.0) With 4th, Both Science <br>" +
                "C (Business Studies):- <br>" +
                "\tTotal-7.0 (SSC-3.0, HSC-3.0) With 4th, Both Science<br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) With 4th, Business & Arts <br>" +
                "D (Social Science, Law, Others):-<br>" +
                "\tTotal-8.0 (SSC-3.5, HSC-3.5) With 4th, Both Science<br>" +
                "\tTotal-7.5 (SSC-3.25, HSC-3.25) With 4th, Business<br>" +
                "\tTotal-7.0 (SSC-3.0, HSC-3.0) With 4th, Arts<br>"+



                "<h4>Islamic University, Kustia (IU): </h4>" +
                "A (Islamic Studies), B (Social Science), C (Arts),  H (Law, Shariah):-  <br>" +
                "\tTotal-7.0 (SSC-3.25, HSC-3.25) With 4th, Science   <br>" +
                "\tTotal-6.75 (SSC-3.25, HSC-3.25) With 4th, Business   <br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) With 4th, <br>" +
                "Arts D (Applied Technology), E (Engineering), F (Applied Science):-  <br>" +
                "\tTotal-7.5 (SSC-3.5, HSC-3.5) With 4th, Both Science <br>" +
                "G (Business Studies):-  <br>" +
                "\tTotal-7.25 (SSC-3.5, HSC-3.5) With 4th, Science   <br>" +
                "\tTotal-6.75 (SSC-3.25, HSC-3.25) With 4th, Business <br>"+





                "<h2>Science & Technology Universities:- </h2>" +
                "<h4>Shahjalal University of Science and Technology (SUST): </h4>"+
                "A (Social Science & Business):- <br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) With 4th, All Group <br>" +
                "B (Science & Engineering):- <br>" +
                "\tTotal-7.0 (SSC-3.0, HSC-3.0) With 4th, Both Science <br>"+



                "<h4>Noakhali Science and Technology University (NSTU):</h4>" +
                "A (Engineering), B (Science):- <br>" +
                "\tTotal-7.0 (SSC-3.0, HSC-3.0) With 4th, Both Science <br>" +
                "C (Social Science), D (Business Studies):- <br>" +
                "\tTotal-6.0 (SSC-3.0, HSC-3.0) With 4th, All Group <br>"+



                "<h4>Hajee Mohammad Danesh Science and Technology University (HSTU):</h4>" +
                "A (Agriculture), B (CSE), D (Engineering), E (Architecture), F (Science):-<br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) With 4th, Science <br>" +
                "C (Business Studies):- <br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) With 4th, All Group <br>" +
                "G (Social Science):- <br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) With 4th, Science & Business<br>" +
                "\tTotal-6.0 (SSC-2.75, HSC-2.75) With 4th, Arts <br>"+




                "<h4>Mawlana Bhashani Science and Technology University (MBSTU):</h4>" +
                "A (Engineering), B (Life Science), C (Science):- <br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) Without 4th, Science <br>" +
                "D (Business Studies & Social Science):- <br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) Without 4th, All Group <br>"+


                "<h4>Patuakhali Science and Technology University (PSTU):</h4>" +
                "A (Science), B (Business Studies), C (Engineering):-<br>" +
                "\tTotal-6.0 (SSC-2.5 HSC-2.5) Without 4th, All Group<br>"+



                "<h4>Jessore University of Science and Technology (JUST):</h4>" +
                "A (Engineering), B (Zoology), C (Applied Science):-<br>" +
                "\tTotal-6.5, With 4th, Both Science <br>" +
                "D (Arts & Social Science), E (Health Science), F (Business Administration):-<br>" +
                "\tTotal-6.5, With 4th, All Group<br>"+


                "<h4>Pabna University of Science and Technology (PUST):</h4>" +
                "A1, A2 (Engineering & Technology):-<br>" +
                "\tTotal-8.0 (SSC-3.5, HSC-3.5) With 4th, Science<br>" +
                "B (Science):-<br>" +
                "\tTotal-7.5 (SSC-3.5, HSC-3.5) With 4th, Science<br>" +
                "C (Business Studies, Arts & Social Science):-<br>" +
                "\tTotal-7.5 (SSC-3.5, HSC-3.5) With 4th Science <br>" +
                "\tTotal-7.0 (SSC-3.0, HSC-3.0) With, 4th, All Group<br>"+



                "<h4>Bangabandu Sheikh Mujibur Rahman Science and Technology University (BSMRSTU):</h4>" +
                "A (Engineering):-<br>" +
                "\tTotal-7.0 (SSC-3.0, HSC-3.0) With 4th, Science B (Science),H (Agriculture):- <br>" +
                "\tTotal-6.5 With 4th, Science <br>" +
                "C (Zoology), D (Arts), E (Social Science), F (Business Studies), G (Law):-<br>" +
                "\tTotal-7.0 With 4th, All Group <br>"+




                "<h4>Rangamati Science and Technology University (RMSTU):</h4>" +
                "A (Engineering):- <br>" +
                "\tTotal-6.5 (SSC-3.0, HSC-3.0) With 4th, Science<br>" +
                "B (Business Studies):- <br>" +
                "\tTotal-5.5 (SSC-2.5, HSC-2.5) With 4th, All Group <br>"+




                "<h2>Engineering Universities: - </h2>" +
                "<h4>Bangladesh University of Engineering and Technology (BUET):</h4><br>" +
                "SSC-4.0 HSC-4.0; Both Science <br>" +
                "Bangla, English, Math, Physics, Chemistry Total number can be minimum 23 <br>"+


                "<h4>Chittagong University of Engineering and Technology (CUET):</h4>" +
                "SSC-4.0 HSC-4.0; Both Science<br>" +
                "English, Math, Physics, Chemistry Total number can be minimum 18.5<br>"+



                "<h4>Rajshahi University of Engineering and Technology (RUET):</h4>" +
                "SSC-4.0 HSC-4.0; Both Science<br>" +
                "Math, Physics, Chemistry every subject number can be minimum 4 English can be minimum 3.5<br>"+



                "<h4>Khulna University of Engineering and Technology (KUET):</h4>" +
                "SSC-4.0 HSC-4.0; Both Science<br>" +
                "English, Math, Physics, Chemistry Total number can be minimum 18.5 <br>";

        return str;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        setIcomInMenu(menu,R.id.menu_login,R.string.menu_item1,R.drawable.login);
        setIcomInMenu(menu,R.id.menu_exit,R.string.menu_item4,R.drawable.exit);



        return super.onCreateOptionsMenu(menu);


    }

    private void setInitialize() {

        icons.add(R.drawable.ic_all_university);
        icons.add(R.drawable.ic_eligibility);
        icons.add(R.drawable.ic_admission_preparation);
        icons.add(R.drawable.ic_forum);
        icons.add(R.drawable.ic_google_mate);
        icons.add(R.drawable.ic_forum);


        titles.add("University Catagory");
        titles.add("Eligibility");
        titles.add("Admission Preparetion");
        titles.add("Student Forum");
        titles.add("Googlr Mate");
        titles.add("About Us");

    }

    private void setIcomInMenu(Menu menu, int menuItemId, int labelId, int iconId){

        MenuItem item = menu.findItem(menuItemId);
        SpannableStringBuilder builder = new SpannableStringBuilder(" "+getResources().getString(labelId));
        builder.setSpan(new ImageSpan(this,iconId), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        item.setTitle(builder);
    }



}

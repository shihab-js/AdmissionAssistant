package shihab.mypro.com.gridviewex;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.util.ArrayList;

import shihab.mypro.com.gridviewex.adapter.ViewPageAdapter;
import shihab.mypro.com.gridviewex.fragments.Agricultural_University;
import shihab.mypro.com.gridviewex.fragments.Engineering_University;
import shihab.mypro.com.gridviewex.fragments.General_University;
import shihab.mypro.com.gridviewex.fragments.Medical_College_University;
import shihab.mypro.com.gridviewex.fragments.National_University;
import shihab.mypro.com.gridviewex.fragments.Private_University;

import static com.nightonke.boommenu.ButtonEnum.TextOutsideCircle;

public class UniversityCatagoryActivity extends AppCompatActivity {

    BoomMenuButton bmb;
    TabLayout tabLayout;
    ViewPager viewPager;

    ArrayList<Integer> icons;
    ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.university_catagory);
        getSupportActionBar().setTitle("University Catagories");

        //toolbar = (Toolbar) findViewById(R.id.toolBar);
        //setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setDataToViewPager();

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);



        icons = new ArrayList<>();
        titles = new ArrayList<>();
        setInitialize();

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        setIcomInMenu(menu,R.id.menu_login,R.string.menu_item1,R.drawable.login);
        setIcomInMenu(menu,R.id.menu_share,R.string.menu_item2,R.drawable.share);
        setIcomInMenu(menu,R.id.menu_comment,R.string.menu_item3,R.drawable.comment);
        setIcomInMenu(menu,R.id.menu_exit,R.string.menu_item4,R.drawable.exit);

        return super.onCreateOptionsMenu(menu);


    }

    private void setDataToViewPager() {

        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new General_University(),"General");
        adapter.addFragment(new Engineering_University(),"Engineering");
        adapter.addFragment(new Medical_College_University(),"Medical");
        adapter.addFragment(new Agricultural_University(),"Agricultural");
        adapter.addFragment(new Private_University(),"Private");
        adapter.addFragment(new National_University(),"National");

        viewPager.setAdapter(adapter);

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

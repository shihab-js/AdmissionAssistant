package shihab.mypro.com.gridviewex;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import shihab.mypro.com.gridviewex.database_setup.Url_Helper;

import static com.nightonke.boommenu.ButtonEnum.TextOutsideCircle;

public class student_forum extends AppCompatActivity {

    BoomMenuButton bmb;

    EditText uName,uPassword;
    Button logIn,register;
    TextView sms;

    ArrayList<Integer> icons;
    ArrayList<String> titles;

    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_forum);
        getSupportActionBar().setTitle("Student Forum");


        uName = (EditText) findViewById(R.id.edit_text_name);
        uPassword = (EditText) findViewById(R.id.edit_text_pass);
        logIn = (Button) findViewById(R.id.btn_login);
        register = (Button) findViewById(R.id.new_account);
        sms = (TextView) findViewById(R.id.sms);


        sharedpreferences = getSharedPreferences("userPreference",
                Context.MODE_PRIVATE);

        final SharedPreferences.Editor editor =  sharedpreferences.edit();

        String uname =  sharedpreferences.getString("name","");
        String pass = sharedpreferences.getString("password","");



        if(uname.equals("") || pass.equals(""))
        {
            logIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String USER_NAME = uName.getText().toString().trim();
                    final String USER_PASS = uPassword.getText().toString().trim();

                    if (USER_NAME.equals("")) {
                        uName.setError("Please enter user name!");
                    } else {
                        if (USER_PASS.equals("")) {
                            uPassword.setError("Please enter password!");
                        } else {

                            RequestQueue queue = Volley.newRequestQueue(student_forum.this);

                            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Url_Helper.FORUM_USER_URL, new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray jsonArray) {

                                    int length = jsonArray.length();
                                    for (int i = 0; i < length; i++) {
                                        try {
                                            String name = jsonArray.getJSONObject(i).getString("Name");
                                            String pass = jsonArray.getJSONObject(i).getString("Password");

                                            if (name.equals(USER_NAME) && pass.equals(USER_PASS)) {
                                                editor.putString("name",name);
                                                editor.putString("pass",pass);
                                                editor.commit();
                                                Intent intent = new Intent(student_forum.this, Forum.class);
                                                intent.putExtra("name", name);
                                                intent.putExtra("password", pass);
                                                sms.setVisibility(View.INVISIBLE);
                                                startActivity(intent);
                                            }else {
                                                sms.setError("User name or Password is not correct!");
                                                sms.setVisibility(View.VISIBLE);
                                            }


                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }


                                }
                            }, new Response.ErrorListener() {


                                @Override
                                public void onErrorResponse(VolleyError error) {



                                }
                            });

                            queue.add(jsonArrayRequest);


                        }
                    }

                }
            });

        }else {
            Intent intent = new Intent(student_forum.this, Forum.class);
            startActivity(intent);
        }








            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(student_forum.this, UserRegistration.class);
                    startActivity(intent);

                }
            });



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

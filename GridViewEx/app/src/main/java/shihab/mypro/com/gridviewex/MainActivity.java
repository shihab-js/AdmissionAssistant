package shihab.mypro.com.gridviewex;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import shihab.mypro.com.gridviewex.adapter.CustomAdapter;
import shihab.mypro.com.gridviewex.model.menuItem;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton main_menu,menu_sub_item1,menu_sub_item2,menu_sub_item3,menu_sub_item4,menu_sub_item5;
    TextView main_menu_title,menu_sub_item1_title,menu_sub_item2_title,menu_sub_item3_title,menu_sub_item4_title,menu_sub_item5_title;

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_menu = (FloatingActionButton) findViewById(R.id.menu_main);

        menu_sub_item1 = (FloatingActionButton) findViewById(R.id.sub_menu_item1);
        menu_sub_item2 = (FloatingActionButton) findViewById(R.id.sub_menu_item2);
        menu_sub_item3 = (FloatingActionButton) findViewById(R.id.sub_menu_item3);
        menu_sub_item4 = (FloatingActionButton) findViewById(R.id.sub_menu_item4);
        menu_sub_item5 = (FloatingActionButton) findViewById(R.id.sub_menu_item5);

        main_menu_title = (TextView) findViewById(R.id.menu_main_title);

        menu_sub_item1_title = (TextView) findViewById(R.id.sub_menu_item1_title);
        menu_sub_item2_title = (TextView) findViewById(R.id.sub_menu_item2_title);
        menu_sub_item3_title = (TextView) findViewById(R.id.sub_menu_item3_title);
        menu_sub_item4_title = (TextView) findViewById(R.id.sub_menu_item4_title);
        menu_sub_item5_title = (TextView) findViewById(R.id.sub_menu_item5_title);


        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag){

                    menu_sub_item1.setVisibility(View.INVISIBLE);
                    menu_sub_item2.setVisibility(View.INVISIBLE);
                    menu_sub_item3.setVisibility(View.INVISIBLE);
                    menu_sub_item4.setVisibility(View.INVISIBLE);
                    menu_sub_item5.setVisibility(View.INVISIBLE);

                    menu_sub_item1_title.setVisibility(View.INVISIBLE);
                    menu_sub_item2_title.setVisibility(View.INVISIBLE);
                    menu_sub_item3_title.setVisibility(View.INVISIBLE);
                    menu_sub_item4_title.setVisibility(View.INVISIBLE);
                    menu_sub_item5_title.setVisibility(View.INVISIBLE);

                    flag = false;




                }else {
                    menu_sub_item1.setVisibility(View.VISIBLE);
                    menu_sub_item2.setVisibility(View.VISIBLE);
                    menu_sub_item3.setVisibility(View.VISIBLE);
                    menu_sub_item4.setVisibility(View.VISIBLE);
                    menu_sub_item5.setVisibility(View.VISIBLE);

                    menu_sub_item1_title.setVisibility(View.VISIBLE);
                    menu_sub_item2_title.setVisibility(View.VISIBLE);
                    menu_sub_item3_title.setVisibility(View.VISIBLE);
                    menu_sub_item4_title.setVisibility(View.VISIBLE);
                    menu_sub_item5_title.setVisibility(View.VISIBLE);



                    flag = true;

                }

            }
        });


        menu_sub_item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UniversityCatagoryActivity.class);
                startActivity(intent);
            }
        });


        menu_sub_item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,eligibility.class);
                startActivity(intent);
            }
        });


        menu_sub_item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,preparation.class);
                startActivity(intent);
            }
        });


        menu_sub_item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,google_mate.class);
                startActivity(intent);
            }
        });


        menu_sub_item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,student_forum.class);
                startActivity(intent);
            }
        });




    }
}

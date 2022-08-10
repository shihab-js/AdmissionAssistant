package shihab.mypro.com.gridviewex;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import shihab.mypro.com.gridviewex.database_setup.BackgroundTask;
import shihab.mypro.com.gridviewex.database_setup.Url_Helper;

public class Forum extends AppCompatActivity {

    TextView name;
    EditText comment;
    Button post;

    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList;

    SharedPreferences myprefer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        getSupportActionBar().setTitle("Forum");

        listView = (ListView) findViewById(R.id.list_View);
        name = (TextView) findViewById(R.id.txt_name);
        comment = (EditText) findViewById(R.id.txt_comment);
        post = (Button) findViewById(R.id.btn_post);

        myprefer = getSharedPreferences("userPreference",MODE_PRIVATE);

        final String uname = myprefer.getString("name",null);
        String pass = myprefer.getString("name",null);
        name.setText(uname);

        arrayList = new ArrayList<>();

        arrayAdapter = new ArrayAdapter<String>(Forum.this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        GetAllComments();

        comment.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                listView.setVisibility(View.INVISIBLE);
                return false;
            }
        });



        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = uname;
                String user_comment = comment.getText().toString().trim();
                String method = "comment_post";

                if (user_comment.equals("")){
                    comment.setError("Enter your comments!");
                }else{

                    BackgroundTask backgroundTask = new BackgroundTask(Forum.this);
                    backgroundTask.execute(method,user_name,user_comment);
                    arrayList.clear();
                    GetAllComments();
                }



            }
        });

    }

    private void GetAllComments() {


        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Url_Helper.FORUM_DATA_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                int length = jsonArray.length();
                for (int i=0; i<length; i++){
                    try {
                        String name = jsonArray.getJSONObject(i).getString("Name");
                        String comment = jsonArray.getJSONObject(i).getString("Comment");
                        arrayList.add("@"+name+"\n"+"\t"+comment);
                        arrayAdapter.notifyDataSetChanged();
                        listView.setVisibility(View.VISIBLE);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


            }
        }, new Response.ErrorListener(){


            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(jsonArrayRequest);


    }
}

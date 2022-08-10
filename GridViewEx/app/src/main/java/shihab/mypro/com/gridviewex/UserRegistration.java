package shihab.mypro.com.gridviewex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.logging.ErrorManager;

import shihab.mypro.com.gridviewex.database_setup.BackgroundTask;

public class UserRegistration extends AppCompatActivity {


    EditText uName,uPassword;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        getSupportActionBar().setTitle("Registration");

        uName = (EditText) findViewById(R.id.edit_text_name);
        uPassword = (EditText) findViewById(R.id.edit_text_pass);
        register = (Button) findViewById(R.id.new_account);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = uName.getText().toString().trim();
                String pass = uPassword.getText().toString().trim();

                String method = "register";


                if(name.equals("")){
                    uName.setError("Please enter user name!");

                }else {

                    if(pass.equals("")){
                        uPassword.setError("Please enter a password!");
                    }

                    else {

                        BackgroundTask backgroundTask = new BackgroundTask(UserRegistration.this);
                        backgroundTask.execute(method,name,pass);
                        finish();
                    }
                }

            }
        });


    }
}

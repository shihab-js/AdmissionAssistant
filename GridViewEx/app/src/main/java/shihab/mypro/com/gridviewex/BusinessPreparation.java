package shihab.mypro.com.gridviewex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import shihab.mypro.com.gridviewex.questionset.BusinessStudy;

public class BusinessPreparation extends AppCompatActivity {

    Button option1,option2,option3,option4;
    TextView score, question,showAns;

    private BusinessStudy questionSet = new BusinessStudy();

    private String answer;
    private int myScore = 0;
    private int questionSetLength = questionSet.mQuestion.length;

    int startNumber = 0;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_preparation);
        getSupportActionBar().setTitle("Business Preparation");

        r = new Random();

        score = (TextView) findViewById(R.id.text_1);
        question = (TextView) findViewById(R.id.text_2);
        showAns = (TextView) findViewById(R.id.show_ans);


        option1 = (Button) findViewById(R.id.option_1);
        option2 = (Button) findViewById(R.id.option_2);
        option3 = (Button) findViewById(R.id.option_3);
        option4 = (Button) findViewById(R.id.option_4);
        score.setText("Your Score: "+myScore);
        updateQuestion(r.nextInt(questionSetLength));


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answer.equals("A")){
                    myScore++;
                    updateQuestion(r.nextInt(questionSetLength));
                    score.setText("Your Score: "+myScore);
                    Toast.makeText(getApplicationContext(),"Right Answer! Good Job.",Toast.LENGTH_SHORT).show();

                }else {
                    showAns.setText("Your ans is wrong! Try again.");
                    showAns.setVisibility(View.VISIBLE);
                }

            }
        });


        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answer.equals("B")){
                    myScore++;
                    updateQuestion(r.nextInt(questionSetLength));
                    score.setText("Your Score: "+myScore);
                    Toast.makeText(getApplicationContext(),"Right Answer! Good Job.",Toast.LENGTH_SHORT).show();


                }else {
                    showAns.setText("Your ans is wrong! Try again.");
                    showAns.setVisibility(View.VISIBLE);
                }



            }
        });



        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answer.equals("C")){
                    myScore++;
                    updateQuestion(r.nextInt(questionSetLength));
                    score.setText("Your Score: "+myScore);
                    Toast.makeText(getApplicationContext(),"Right Answer! Good Job.",Toast.LENGTH_SHORT).show();


                }else {
                    showAns.setText("Your ans is wrong! Try again.");
                    showAns.setVisibility(View.VISIBLE);
                }


            }
        });


        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answer.equals("D")){
                    myScore++;
                    updateQuestion(r.nextInt(questionSetLength));
                    score.setText("Your Score: "+myScore);
                    Toast.makeText(getApplicationContext(),"Right Answer! Good Job.",Toast.LENGTH_SHORT).show();


                }else {
                    showAns.setText("Your ans is wrong! Try again.");
                    showAns.setVisibility(View.VISIBLE);
                }

            }
        });



    }

    private void updateQuestion(int index) {

        if(startNumber != index) {

            question.setText(questionSet.getQustion(index));

            option1.setText(questionSet.getChoice(index));
            option2.setText(questionSet.getChoice1(index));
            option3.setText(questionSet.getChoice2(index));
            option4.setText(questionSet.getChoice3(index));

            answer = questionSet.getCorrectAns(index);
            showAns.setVisibility(View.INVISIBLE);

            startNumber = index;

        }else {

            updateQuestion(r.nextInt(questionSetLength));

        }

    }
}

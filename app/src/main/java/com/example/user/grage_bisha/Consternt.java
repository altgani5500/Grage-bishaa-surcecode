package com.example.user.grage_bisha;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Consternt extends Activity {
Switch a,b,c;
    int an=0;

    int bn=0;

    int cn=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consternt);





        a  = (Switch) findViewById(R.id.switch3);
        b = (Switch) findViewById(R.id.switch2);
        c  = (Switch) findViewById(R.id.switch1);


        a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(an==1){
                    an=0;
                    a.setText("اوافق علي المعاهدة");
                }else  if(an==0){
a.setText("لا اوافق علي المعاهدة");
                    an=1;
                }




            }
        });

        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                if(bn==1){
                    bn=0;
                   b.setText("اوافق علي المعاهدة");
                }else  if(bn==0){
                  b.setText("لا اوافق علي المعاهدة");
                    bn=1;
                }
            }
        });

        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cn==1){
                    cn=0;
                    c.setText("اوافق علي المعاهدة");
                }else  if(cn==0){
                   c.setText("لا اوافق علي المعاهدة");
                   cn=1;
                }

            }
        });


        Button etUserName23 = (Button) findViewById(R.id.button4);
        etUserName23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {


                if(an==1 && bn==1 && cn==1){
                    String phone=getIntent().getStringExtra("phone");
                    String pass=getIntent().getStringExtra("pass");

                    Intent alvvwefrerxx = new Intent(Consternt.this, Tibe_add.class);
                    alvvwefrerxx.putExtra("phone", phone);
                    alvvwefrerxx.putExtra("pass", pass);
                    startActivity(alvvwefrerxx);
                    // overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                    //  finish();
                }else{

                    Toast.makeText(Consternt.this, "الرجاء الموافقة علي جميع المعاهدات ", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}

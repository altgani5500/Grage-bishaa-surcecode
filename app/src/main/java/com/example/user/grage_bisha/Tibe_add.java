package com.example.user.grage_bisha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Tibe_add extends AppCompatActivity {



String typ_p="0";
    ListView listView;

    // Define string array.
    String[] listValue = new String[] {

            "سيارات",
            "اثاث منزلي",
            "عقارات",
            "اجهزة وهواتف",
            "اغراض اخري"

};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tibe_add);



        listView = (ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2, android.R.id.text1, listValue);

        listView.setAdapter(adapter);

        // ListView on item selected listener.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
               // Toast.makeText(Town2.this, listValue[position], Toast.LENGTH_SHORT).show();
                String a=listValue[position];

                String phone=getIntent().getStringExtra("phone");
                String pass=getIntent().getStringExtra("pass");




                if(position==0){



    Intent mIntent = new Intent(Tibe_add.this, Upload_prudect.class);
//                mIntent.putExtra("sr", a);
//
    typ_p="1";
               mIntent.putExtra("prudectt", typ_p);
    mIntent.putExtra("phone", phone);
    mIntent.putExtra("pass", pass);
//                mIntent.putExtra("go2", bb);

  // Toast.makeText(Tibe_add.this, a, Toast.LENGTH_SHORT).show();

    startActivity(mIntent);

}else if(position==1){
    typ_p="2";
    Intent mIntent = new Intent(Tibe_add.this, Upload_prudect.class);
//                mIntent.putExtra("sr", a);
//
    mIntent.putExtra("prudectt", typ_p);
                    mIntent.putExtra("phone", phone);
                    mIntent.putExtra("pass", pass);
//                mIntent.putExtra("go2", bb);

  //  Toast.makeText(Tibe_add.this, a, Toast.LENGTH_SHORT).show();
                    startActivity(mIntent);
}else if(position==2){
    typ_p="3";
    Intent mIntent = new Intent(Tibe_add.this, Upload_prudect.class);
//                mIntent.putExtra("sr", a);
//
                    mIntent.putExtra("prudectt", typ_p);
                    mIntent.putExtra("phone", phone);
                    mIntent.putExtra("pass", pass);
//                mIntent.putExtra("go2", bb);

  //  Toast.makeText(Tibe_add.this, a, Toast.LENGTH_SHORT).show();
                    startActivity(mIntent);
}else if(position==3){
    typ_p="4";
    Intent mIntent = new Intent(Tibe_add.this, Upload_prudect.class);
//                mIntent.putExtra("sr", a);
//
                    mIntent.putExtra("prudectt", typ_p);
                    mIntent.putExtra("phone", phone);
                    mIntent.putExtra("pass", pass);
//                mIntent.putExtra("go2", bb);

    //Toast.makeText(Tibe_add.this, a, Toast.LENGTH_SHORT).show();
                    startActivity(mIntent);
}else if(position==4){

    typ_p="5";
    Intent mIntent = new Intent(Tibe_add.this, Upload_prudect.class);
//                mIntent.putExtra("sr", a);
//
                    mIntent.putExtra("prudectt", typ_p);
                    mIntent.putExtra("phone", phone);
                    mIntent.putExtra("pass", pass);
//                mIntent.putExtra("go2", bb);

   // Toast.makeText(Tibe_add.this, a, Toast.LENGTH_SHORT).show();
                    startActivity(mIntent);
}

//                Intent mIntent = new Intent(Tibe_add.this, MainActivity.class);
////                mIntent.putExtra("sr", a);
////
////                mIntent.putExtra("go1", aa);
////                mIntent.putExtra("go2", bb);
//
//                //Toast.makeText(Tibe_add.this, "", Toast.LENGTH_SHORT).show();
//                startActivity(mIntent);
////                finish();
////               // overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
//            //    Toast.makeText(Tibe_add.this, ""+a, Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
      //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }
}

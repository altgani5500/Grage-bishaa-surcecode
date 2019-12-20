package com.example.user.grage_bisha;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Register extends Activity {
EditText name,pass,passv;
    private ProgressDialog mProgressDialog;
    String names,passs,code;
    private static final int MY_SOCKET_TIMEOUT_MS = 400000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        name = (EditText) findViewById(R.id.editText3);
        pass = (EditText) findViewById(R.id.editText);
        passv = (EditText) findViewById(R.id.editText7);





        Button etUserName232 = (Button) findViewById(R.id.button5);
        etUserName232.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

signup();
            }
        });
    }
    public void signup() {

   names = name.getText().toString();
      passs = pass.getText().toString();
        String passvs = passv.getText().toString();

        if (TextUtils.isEmpty(names))
        {
            name.setError("الرجاء مل الحقل");
            return;
        }
        else if (TextUtils.isEmpty(passs)) {

            pass.setError("الرجاء مل الحقل");

            return;
        }
//            }else if (TextUtils.isEmpty(passvs))
//            {
//                passv.setError("الرجاء مل الحقل");
//
//                return;
//            }else if (!passs.equals(passvs))
//        {
//            passv.setError("كلمة المرور غير متطابقة");
//
//            return;
//        }
            else
        {
            dothis();
        }
//
//           MainActivity.phone_temp=phone1;
//            MainActivity.name_temp=name1;
//
//

          //      new Register.SignupActivityda(this).execute(names,passs);


        }







//
//    public class SignupActivityda extends AsyncTask<String, Void, String> {
//
//
//        private Context context;
//
//
//        public SignupActivityda(Context context) {
//            this.context = context;
//        }
//
//        protected void onPreExecute()
//        {
//            super.onPreExecute();
//            mProgressDialog = ProgressDialog.show(Register.this,
//                    "جاري ...","ارسال البيانات", false, false);
//        }
//
//        @Override
//        protected String doInBackground(String... arg0) {
//            String name = arg0[0];
//            String pass = arg0[1];
//
//
//
//            String link;
//            String data;
//            BufferedReader bufferedReader;
//            String result;
//
//            try {
//                data = "?phone_number=" + URLEncoder.encode(name, "UTF-8");
//              //  data += "&pass=" + URLEncoder.encode(pass, "UTF-8");
//
//
//
//
//
//                link = "https://sultantec.com/bisha/regster.php" + data;
//
//                URL url = new URL(link);
//                HttpURLConnection con = (HttpURLConnection) url.openConnection();
//
//                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//                result = bufferedReader.readLine();
//                return result;
//            } catch (Exception e) {
//                return new String("Exception: " + e.getMessage());
//            }
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            String jsonStr = result;
//            if (jsonStr != null) {
//                try {
//                    JSONObject jsonObj = new JSONObject(jsonStr);
//                    String query_result = jsonObj.getString("query_result");
//                    if (query_result.equals("SUCCESS")) {
//
//                        buclickd();
//
//
//                    } else if (query_result.equals("FOUND")) {
//                        buclickdf();
//                    } else if (query_result.equals("FAILURE")) {
//                        buclickdd();
//                    } else {
//                        buclickdd();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    buclickdd();
//                }
//            } else {
//
//
//                buclickdd();
//            }
//
//        }}




























//
//    public void buclickdd() {
//
//        mProgressDialog.dismiss();
//        android.support.v7.app.AlertDialog.Builder builder =new android.support.v7.app.AlertDialog.Builder(this);
//        builder.setMessage("هل تريد اعادة المحاولة ؟")
//                .setIcon(R.drawable.error)
//                .setTitle("فشل الاتصال تاكد من خدمة البيانات")
//                .setPositiveButton("اعادة محاولة", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        mProgressDialog.dismiss();
//
//
//                        String names = name.getText().toString();
//                        String passs = pass.getText().toString();
//                        String passvs = passv.getText().toString();
//
//                        if (TextUtils.isEmpty(names))
//                        {
//                            name.setError("الرجاء مل الحقل");
//                            return;
//                        }
//                        else if (TextUtils.isEmpty(passs)) {
//
//                            pass.setError("الرجاء مل الحقل");
//
//                            return;
//                        }else if (TextUtils.isEmpty(passvs))
//                        {
//                            passv.setError("الرجاء مل الحقل");
//
//                            return;
//                        }else if (!passs.equals(passvs))
//                        {
//                            passv.setError("كلمة المرور غير متطابقة");
//
//                            return;
//                        }
//                        else
//
//                            new Register.SignupActivityda(getApplicationContext()).execute(names,passs);
//
//
//                    }
//                }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                mProgressDialog.dismiss();
//
//                name.setText(null);
//                pass.setText(null);
//                passv.setText(null);
//
//
//            }
//
//        }).show();
//
//    }








    public void buclickdf() {
        mProgressDialog.dismiss();




        android.support.v7.app.AlertDialog.Builder builder =new android.support.v7.app.AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.sym_action_call)
                .setTitle("عفوا الرقم المدخل مستخدم من قبل")
                .setCancelable(false)
                .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mProgressDialog.dismiss();
                        //onBackPressed();
                        onBackPressed();
                        //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

                    }
                }).setNegativeButton("رجوع", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                mProgressDialog.dismiss();
                onBackPressed();
            }

        }).show();
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();



      //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }








    public  void  dothis(){

        mProgressDialog = ProgressDialog.show(Register.this,
                "جاري ...", "التحقق من رقم التفعيل", false, false);

        //  String aa1 = getIntent().getStringExtra("phone");
        //String bb1 = getIntent().getStringExtra("loha");



        String url = "http://sultantec.com/haraj_bishah/Verification_Code.php";


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {




                try {

//
                    JSONObject jsonObj = new JSONObject(s);
                    String mtlob = jsonObj.getString("Status");
                    String mtlob2 = jsonObj.getString("Message");
                    if(mtlob.equals("Success")){
                        mProgressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "تمت عملية التسجيل بنجاح", Toast.LENGTH_LONG).show();

code=mtlob2;

                       // Toast.makeText(Register.this, code, Toast.LENGTH_SHORT).show();

                        buclickd();
                    }else {
                        mProgressDialog.dismiss();
                Toast.makeText(Register.this, "لم تتم عملية التسجيل", Toast.LENGTH_LONG).show();
//buclickd();
                    }
                    // Toast.makeText(Count.this, mtlob+plance, Toast.LENGTH_SHORT).show();
//




//                Log.e("order_id",or);
//

                } catch (JSONException e) {
                    // rdr2.setVisibility(View.GONE);
                    mProgressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "حدث خطاء ما اعد الحاولة", Toast.LENGTH_SHORT).show();

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {


                //     en4();
                mProgressDialog.dismiss();


                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "تاكد من اتصالك يالانترنت", Snackbar.LENGTH_INDEFINITE)
                        .setAction("اعاة المحاولة", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                dothis();

                            }
                        })
                        .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                        .show();
            }
        }) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("phone_number", names);
              //  params.put("password", password);
                //  params.put("phone_number", code);
                // params.put("domain", "http://itsalif.info");

                return params;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);

    }













    public void buclickd() {
        mProgressDialog.dismiss();


        name.setText(null);
        pass.setText(null);
       // passv.setText(null);
        mProgressDialog.dismiss();
        //onBackPressed();
//onBackPressed();
        //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

        Intent al = new Intent(Register.this, V_code.class);

        al.putExtra("phone", names);al.putExtra("pass", passs);
        al.putExtra("code", code);

        startActivity(al);
finish();
//        android.support.v7.app.AlertDialog.Builder builder =new android.support.v7.app.AlertDialog.Builder(this);
//        builder.setIcon(R.drawable.wwe2)
//                .setTitle("تم ارسال البيانات بنجاح")
//                .setCancelable(false)
//                .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        mProgressDialog.dismiss();
//                        //onBackPressed();
////onBackPressed();
//                      //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
//
//                        Intent al = new Intent(Register.this, V_code.class);
//
//                        startActivity(al);
//
//                     //   Register.startActivity(al);
//
//                    }
//                }).setNegativeButton("رجوع", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//
//                mProgressDialog.dismiss();
//                onBackPressed();
//            }
//
//        }).show();
    }


}














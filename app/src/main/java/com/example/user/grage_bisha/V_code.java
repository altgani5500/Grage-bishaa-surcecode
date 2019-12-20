package com.example.user.grage_bisha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class V_code extends AppCompatActivity {
    private static final int MY_SOCKET_TIMEOUT_MS = 10000;
    EditText pass;
    private ProgressDialog mProgressDialog;

    SharedPreferences settings = null;
    private String mUsername;
    private String mUsername2;
    SharedPreferences settings2;

String phone,password,code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_code);


//        settings = getSharedPreferences("BISC", 0);
//
//        mUsername=settings.getString("phone", "44");
//        mUsername2=settings.getString("name", "44");

         phone=getIntent().getStringExtra("phone");
        password=getIntent().getStringExtra("pass");
        code=getIntent().getStringExtra("code");




        pass = (EditText) findViewById(R.id.editText20);


        Button etUserName234 = (Button) findViewById(R.id.button16);


        etUserName234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {


                String bb1 = pass.getText().toString();


                if(TextUtils.isEmpty(bb1)) {
                    pass.setError("الرجاء مل الحقل");
                 }
        else if (!bb1.equals(code))
        {
            pass.setError("تاكد من صحة الكود المدخل");

        } else{

                    dothis();

                }





            }
        });









            }





            public  void  dothis(){

                mProgressDialog = ProgressDialog.show(V_code.this,
                        "جاري ...", "التحقق من رقم التفعيل", false, false);

                //  String aa1 = getIntent().getStringExtra("phone");
                //String bb1 = getIntent().getStringExtra("loha");

//                String bb1 = pass.getText().toString();
//                String aa12 = getIntent().getStringExtra("phone");
//




                String url = "http://sultantec.com/haraj_bishah/User_Register.php";
               // String URL_PRODUCTS = "http://sultantec.com/haraj_elbel/MyFavorites.php";
//        Log.e("url", aa12);
//        Log.e("url", bb1);

                // Toast.makeText(mContext, url, Toast.LENGTH_LONG).show();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {




                        try {
//                JSONObject jsonObj = new JSONObject(myJSON);
//                peoples = jsonObj.getJSONArray(TAG_RESULTS);
//


//
//                    JSONObject jsonObject = new JSONObject(s);
//                    //JSONArray array_1 = jsonObject.getJSONArray("locations");
//                    JSONArray array_2 = jsonObject.getJSONArray("result");
//
//                    JSONObject no = array_2.getJSONObject(0);
//
//                    final String mtlob = no.getString("query_result");
//
//
                            JSONObject jsonObj = new JSONObject(s);
                            String mtlob = jsonObj.getString("Status");

                            if(mtlob.equals("Success")){
                                mProgressDialog.dismiss();
                             Toast.makeText(getApplicationContext(), "تمت عملية التسجيل بنجاح", Toast.LENGTH_LONG).show();


//                        AlertDialog.Builder builder =new AlertDialog.Builder(Vcode_user.this);
//                        builder.setIcon(R.drawable.wwe2)
//                                .setTitle("تمت العملية بنجاح ")
//                                .setCancelable(false)
//                                .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int id) {
//                                        mProgressDialog.dismiss();
//                                        onBackPressed();
//
//                                    }
//                                }).show();




onBackPressed();



                            }else {
                                mProgressDialog.dismiss();
                                Toast.makeText(V_code.this, "لم تتم عملية التسجيل", Toast.LENGTH_LONG).show();

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
                        // rdr2.setVisibility(View.GONE);
                        // Toast.makeText(mContext, "Error vo 1 " + volleyError, Toast.LENGTH_SHORT).show();
                        //finish();


                        View parentLayout = findViewById(android.R.id.content);
                        Snackbar.make(parentLayout, "تاكد من اتصالك يالانترنت", Snackbar.LENGTH_INDEFINITE)
                                .setAction("اعاة المحاولة", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        dothis();
//                                onBackPressed();

//                                finish();
//                                moveTaskToBack(true);
//                                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
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
                        params.put("phone_number", phone);
                        params.put("password", password);
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

        }













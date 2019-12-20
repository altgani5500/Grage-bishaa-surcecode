package com.example.user.grage_bisha;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.androidquery.util.AQUtility.getContext;

public class Login extends Activity {

    String error;

    public static String mUsername;
    public static String mUsername2;


    private EditText mUsernameET;
    private EditText mPasswordET;

    private Button mSigninBtn;
    private Button mRegisterBtn;

    private JSONParse jsonParse = new JSONParse();

    private String LOGIN_URL =
            "http://sultantec.com/haraj_bishah/User_Login.php";
    private String REGISTER_URL =
            "http://sultantec.com/haraj_bishah/User_Login.php";
    String logs;
    SharedPreferences settingslogin;
    CheckBox simpleCheckBox;
    static Boolean check23;
    SharedPreferences settings = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //  buclick();
        logs = getIntent().getStringExtra("logs");


        settings = getSharedPreferences("BISC", 0);

        mUsername = settings.getString("go1", "44");

        mUsername2 = settings.getString("go2", "44");


        settingslogin = getSharedPreferences("NAMELOGIN", 0);


        check23 = settingslogin.getBoolean("checklogin", false);

        String bb0 = getIntent().getStringExtra("logout");

        if (bb0 != null && bb0.equals("logout")) {

            // buclickdlogout();

            ///settingslogin = getSharedPreferences("NAMELOGIN", 0);
            SharedPreferences.Editor editor2 = settingslogin.edit();


            editor2.putBoolean("checklogin", false);


            editor2.apply();

        }


        if (check23) {


            if (logs.equals("fev")) {
                Intent i = new Intent(Login.this, My_Fevort.class);
                i.putExtra("phone", mUsername);
                i.putExtra("pass", mUsername2);
                startActivity(i);
                finish();
            } else if (logs.equals("adv")) {
                Intent i = new Intent(Login.this, My_adv.class);
                i.putExtra("phone", mUsername);
                i.putExtra("pass", mUsername2);
                startActivity(i);
                finish();
            } else if (logs.equals("newadd")) {
                Intent i = new Intent(Login.this, Consternt.class);
                i.putExtra("phone", mUsername);
                i.putExtra("pass", mUsername2);
                startActivity(i);
                finish();
            }

        }


        simpleCheckBox = (CheckBox) findViewById(R.id.checkBox2);

        mUsernameET = (EditText) findViewById(R.id.editText3);
        mUsernameET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_NEXT || i == EditorInfo.IME_ACTION_DONE) {
                    mPasswordET.requestFocus();
                }
                return false;
            }
        });

        mPasswordET = (EditText) findViewById(R.id.editText);
        mPasswordET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_NEXT || i == EditorInfo.IME_ACTION_DONE) {
                    attempLogin(0);
                }
                return false;
            }
        });

        mSigninBtn = (Button) findViewById(R.id.button5);
        mSigninBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attempLogin(0);
            }
        });


        Button etUserName23 = (Button) findViewById(R.id.button6);
        etUserName23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {


                Intent alvvwefrerxx = new Intent(Login.this, Register.class);


                startActivity(alvvwefrerxx);
                // overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                //  finish();

            }
        });

//        TextView wwww22 =(TextView)findViewById(R.id.textView2);
//        wwww22.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View vv) {
//             /*   Intent mIntent = new Intent(Login.this, Driver.class);
//                startActivity(mIntent);
//              finish();
//                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);*/
//                try {
//
//
//                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
//                    callIntent.setData(Uri.parse("tel:" + "0507772800"));
//                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(callIntent);
//                } catch (ActivityNotFoundException activityException) {
//                    Log.e("Calling a Phone Number", "Call failed", activityException);
//                }
//            }
//        });

//        Button wwww2 =(Button)findViewById(R.id.button88);
//        wwww2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View vv) {
//                info2();
//            }
//        });
    }

    private void attempLogin(int btn) {
        String Username = mUsernameET.getText().toString();
        String Password = mPasswordET.getText().toString();

        if (TextUtils.isEmpty(Username)) {
            mUsernameET.setError("الحقل مطلوب");
            return;
        } else if (TextUtils.isEmpty(Password)) {
            mPasswordET.setError("الحقل مطلوب");
            return;
        }

        if (btn == 0)
            new LoginUserTask(Username, Password).execute();
        else
           // new RegisterUserTask(Username, Password).execute();
            Toast.makeText(this, "nooooooo", Toast.LENGTH_SHORT).show();
    }

    private class LoginUserTask extends AsyncTask<Void, Void, Boolean> {
        private ProgressDialog mProgressDialog;

        private JSONObject jsonObjectResult = null;

        private String Username;
        private String Password;


        private LoginUserTask(String username, String password) {
            Username = username;
            Password = password;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(Login.this,
                    "جاري ...", "التحقق من اسم المستخدم وكلمة المرور", false, false);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
            pairs.add(new BasicNameValuePair("phone_number", Username));
            pairs.add(new BasicNameValuePair("password", Password));

            jsonObjectResult = jsonParse.makeHttpRequest(LOGIN_URL, pairs);

          //  Toast.makeText(Login.this, jsonObjectResult.toString(), Toast.LENGTH_SHORT).show();

            //Log.d("a",jsonObjectResult.toString()) ;
            if (jsonObjectResult == null) {
                error = "لايوجد اتصال بالانترنت";
                return false;
            }

            try {
                if (jsonObjectResult.getString("Status").equals("Success")) {
                    return true;
                } else if (jsonObjectResult.getString("Status").equals("Failed")) {
                    error = "تاكد من البيانات المدخله";
                    //  Toast.makeText(Login.this,"تاكد من البيانات المدخله", Toast.LENGTH_SHORT).show();
                    //return false;
                }

            } catch (Exception ex) {

            }

            return false;
        }





        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            mProgressDialog.dismiss();

            if (aBoolean && simpleCheckBox.isChecked()) {
                buclickdl();
            } else if (aBoolean) {
               // buclickdl2();
                buclickdl();

            }else if (!aBoolean) {
               //Toast.makeText(Login.this, jsonObjectResult.toString(), Toast.LENGTH_SHORT).show();
                // Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
              Toast.makeText(Login.this, "تاكد  صحة البيانات المدخلة", Toast.LENGTH_SHORT).show();
            }

        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //   overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }


//    public void info2() {
//
//        final Dialog dialog = new Dialog(Login.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.custom_singup3);
//        // dialog.setTitle("خروج من التطبيق");
//        // set the custom dialog components - text, image and button
//        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
//        //  image.setImageResource(R.drawable.ic_launcher);
//
//        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
//        // if button is clicked, close the custom dialog
//        dialogButtonc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
//
//
//    }


//    public void info2a() {
//
//        final Dialog dialog = new Dialog(Login.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.custom_abouac);
//        // dialog.setTitle("خروج من التطبيق");
//        // set the custom dialog components - text, image and button
//        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
//        //  image.setImageResource(R.drawable.ic_launcher);
//
//        Button dialogButtonc = (Button) dialog.findViewById(R.id.me);
//        // if button is clicked, close the custom dialog
//        dialogButtonc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
//
//
//    }

    public void buclickdl2() {

        settingslogin = getSharedPreferences("NAMELOGIN", 0);


        SharedPreferences.Editor editor2 = settingslogin.edit();


        SharedPreferences.Editor editor3 = settings.edit();


        String phoneNumber = mUsernameET.getText().toString();
        String name3 = mPasswordET.getText().toString();

        editor2.putBoolean("checklogin", false);

        editor2.putString("go1", phoneNumber);
        editor2.putString("go2", name3);


        editor3.putString("go1", phoneNumber);
        editor3.putString("go2", name3);


        editor2.apply();

        editor3.apply();


        if (logs.equals("fev")) {
            Intent i = new Intent(Login.this, My_Fevort.class);
            i.putExtra("phone", phoneNumber);
            i.putExtra("pass", name3);

            startActivity(i);
            finish();
        } else if (logs.equals("adv")) {
            Intent i = new Intent(Login.this, My_adv.class);
            i.putExtra("phone", phoneNumber);
            i.putExtra("pass", name3);
            startActivity(i);
            finish();
        } else if (logs.equals("newadd")) {
            Intent i = new Intent(Login.this, Consternt.class);
            i.putExtra("phone", phoneNumber);
            i.putExtra("pass", name3);
            startActivity(i);
            finish();
        }

//        Intent i1 = new Intent(Login.this,Consternt.class);
//        startActivity(i1);
//        //overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
//        finish();


    }

    public void buclickdl() {

        settingslogin = getSharedPreferences("NAMELOGIN", 0);
        SharedPreferences.Editor editor2 = settingslogin.edit();

        SharedPreferences.Editor editor3 = settings.edit();

        String phoneNumber = mUsernameET.getText().toString();
        String name3 = mPasswordET.getText().toString();

        editor2.putBoolean("checklogin", true);


        editor3.putString("go1", phoneNumber);
        editor3.putString("go2", name3);

        editor2.apply();
        editor3.apply();

        if (logs.equals("fev")) {
            Intent i = new Intent(Login.this, My_Fevort.class);
            i.putExtra("phone", phoneNumber);
            i.putExtra("pass", name3);
            startActivity(i);
            finish();
        } else if (logs.equals("adv")) {
            Intent i = new Intent(Login.this, My_adv.class);
            i.putExtra("phone", phoneNumber);
            i.putExtra("pass", name3);
            startActivity(i);
            finish();
        } else if (logs.equals("newadd")) {
            Intent i = new Intent(Login.this, Consternt.class);
            i.putExtra("phone", phoneNumber);
            i.putExtra("pass", name3);
            startActivity(i);
            finish();
        }


//        Intent i1 = new Intent(Login.this,Consternt.class);
//        startActivity(i1);
//       // overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
//        finish();

    }


    public void buclickdlogout() {

        settingslogin = getSharedPreferences("NAMELOGIN", 0);
        SharedPreferences.Editor editor2 = settingslogin.edit();


        String phoneNumber = mUsernameET.getText().toString();
        String name3 = mPasswordET.getText().toString();

        editor2.putBoolean("checklogin", false);

        editor2.putString("go1", phoneNumber);
        editor2.putString("go2", name3);

        editor2.apply();


    }


    public void buclickdlogout2() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://sultantec.com/haraj_elbel/All_Product.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //        Toast.makeText(mCtx, "Reponse : " + response, Toast.LENGTH_SHORT).show();
                        try {
//"https://sultantec.com/bisha/prudectall.php",


                            JSONObject jsonObject = new JSONObject(response);
                            //JSONArray array_1 = jsonObject.getJSONArray("locations");
                            JSONArray array_2 = jsonObject.getJSONArray("Product");

                            //
                            JSONObject jo = array_2.getJSONObject(0);
                            //    Log.d("f",jo.toString());

                            //  Toast.makeText(mCtx, "Reponse : " + array_2, Toast.LENGTH_SHORT).show();

                            //  Toast.makeText(mCtx, "Reponse : " + array_2, Toast.LENGTH_SHORT).show();

                            //  JSONArray array = new JSONArray(response);

                           // JSONObject product = array_2.getJSONObject(i);

                            //adding the product to product list

//                            productList.add(new ProductMain(
//                                    product.getInt("product_id"),
//
//                                    product.getString("product_title"),


                            //  traversing through all the object


                            //creating adapter object and setting it to recyclerview
//                            ProductsAdapter adapter = new ProductsAdapter(getContext(), productList);
//
//
//                            recyclerView.setAdapter(adapter);
//
//
//                            // recyclerView.setVisibility(View.VISIBLE);
//
//                            Pbar.setVisibility(View.GONE);
//
//
//                            //  etUserName.setVisibility(View.GONE);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            // Log.e("erroer res",e);
                          //  mSwipeRefreshLayout.setRefreshing(false);

                            Toast.makeText(getContext(), "" + e, Toast.LENGTH_LONG).show();

                            //etUserName.setVisibility(View.GONE);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //      Log.e("erroer res",error);
                        //Toast.makeText(getContext(),""+error, Toast.LENGTH_LONG).show();

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }


}


































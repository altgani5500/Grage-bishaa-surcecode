package com.example.user.grage_bisha;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class Upload_prudect extends AppCompatActivity {
    Bitmap bitmap,bitmap2,bitmap3,bitmap4,bitmap5,bitmap6;
    String image_test1,image_test2,image_test3,image_test4,image_test5,image_test6;

    boolean check = true;

    ImageView SelectImageGallery,SelectImageGallery2,SelectImageGallery3,SelectImageGallery4,SelectImageGallery5,SelectImageGallery6;
    Button UploadImageServer;

    ImageView imageView;

    EditText imageName;
    String name1;
    String phone1;
    String pass,passr;
    String kh_no1;
    String tips1 ;
    String tips22 ;
    TextView al,al2;
    ProgressDialog progressDialog ;

    String GetImageNameEditText;

    String ImageName = "image_name" ;

    String ImagePath = "image_path" ;


    String ServerUploadPath ="http://sultantec.com/haraj_bishah/upload_prudect.php" ;

//https://tagogx.000webhostapp.com/files/upload_prudect.php
    //https://sultantec.com/haraj_elbel/upload_prudect.php

    int image_num;

String type_p;
    String u_phone;

    private EditText p_name, p_desc, kh_no,tips,tips2,passe,passer;
    private ProgressDialog mProgressDialog;
    RelativeLayout r;
    CheckBox simpleCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_prudect);

       // type_p="1";
        type_p=getIntent().getStringExtra("prudectt");
        u_phone=Login.mUsername;


      //  Toast.makeText(this, type_p+u_phone, Toast.LENGTH_LONG).show();




     // r = (RelativeLayout) findViewById(R.id.w);

//
//                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//                setSupportActionBar(toolbar);
//
//                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//                fab.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        //     .setAction("Action", null).show();
//                        onBackPressed();
//                    }
//                });




        //   simpleCheckBox = (CheckBox) findViewById(R.id.checkBox);


//        TextView mm = (TextView) findViewById(R.id.button8);
//        mm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View vvv) {
//                //  info();
//
//            }
//        });


        p_name = (EditText) findViewById(R.id.editText9);
        p_desc = (EditText) findViewById(R.id.editText10);

//        kh_no = (EditText) findViewById(R.id.editText7);
//        tips = (EditText) findViewById(R.id.editText8);
//
//        tips2= (EditText) findViewById(R.id.editText10);
//
//        passe= (EditText) findViewById(R.id.editText10);
//
//        passer= (EditText) findViewById(R.id.editText844);


//        al=(TextView)findViewById(R.id.textView4);
//
//        al2=(TextView)findViewById(R.id.button8);



        //imageView = (ImageView)findViewById(R.id.button1);

        //imageName = (EditText)findViewById(R.id.editTextImageName);

        SelectImageGallery = (ImageView)findViewById(R.id.button1);
        SelectImageGallery2 = (ImageView)findViewById(R.id.button2);
        SelectImageGallery3 = (ImageView)findViewById(R.id.button3);
        SelectImageGallery4 = (ImageView)findViewById(R.id.button4);
        SelectImageGallery5 = (ImageView)findViewById(R.id.button5);
        SelectImageGallery6 = (ImageView)findViewById(R.id.button6);


        UploadImageServer = (Button)findViewById(R.id.button18);





        SelectImageGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                image_num=1;

                Intent intent = new Intent();

                intent.setType("image/*");

                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "اختر صورة الناقلة  "), 1);

            }
        });


        SelectImageGallery2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_num=2;
                Intent intent = new Intent();

                intent.setType("image/*");

                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "اختر صورة الناقلة  "), 1);

            }
        });

        SelectImageGallery3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_num=3;
                Intent intent = new Intent();

                intent.setType("image/*");

                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "اختر صورة الناقلة  "), 1);

            }
        });




        SelectImageGallery4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_num=4;
                Intent intent = new Intent();

                intent.setType("image/*");

                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "اختر صورة الناقلة  "), 1);

            }
        });




        SelectImageGallery5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_num=5;
                Intent intent = new Intent();

                intent.setType("image/*");

                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "اختر صورة الناقلة  "), 1);

            }
        });



        SelectImageGallery6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_num=6;
                Intent intent = new Intent();

                intent.setType("image/*");

                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "اختر صورة الناقلة  "), 1);

            }
        });




        UploadImageServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetImageNameEditText = "image nmae";

                // imageName.getText().toString();


                name1 = p_name.getText().toString();
                phone1 = p_desc.getText().toString();
                // String passWord = etPassword.toString();

//                kh_no1 = kh_no.getText().toString();
//                tips1 = tips.getText().toString();
//
//
//                tips22 = tips2.getText().toString();
//
//                pass = passe.getText().toString();
//
//                passr = passer.getText().toString();

                if (TextUtils.isEmpty(name1)) {


                    p_name.setError("الرجاء مل الحقل");
                    return;
                } else if (TextUtils.isEmpty(phone1)) {

                    p_desc.setError("الرجاء مل الحقل");
                    return;
                } else {
                    // int a=120;
                    // int b=120;
                    //r.setLayoutParams(new RelativeLayout.LayoutParams(a,b));

                    if (SelectImageGallery.getDrawable() == null) {


                        image_test1 ="0";
//                    al.setError("الرجاء اختيار صورة للناقلة");
//
//                    al.setTextColor(0xffcc0000);
                        bitmap = BitmapFactory.decodeResource( getResources(), R.drawable.cucode);


                        //    bitmap = MediaStore.Images.Media.getBitmap( getContentResolver(),uri);

                        // SelectImageGallery.setImageResource(R.drawable.cucode);

                        // return;

                    }
                    if (SelectImageGallery2.getDrawable() == null) {

                        image_test2 ="0";
                        bitmap2 = BitmapFactory.decodeResource( getResources(), R.drawable.cucode);
                        //  SelectImageGallery2.setImageResource(R.drawable.cucode);

                        // return;

                    }
                    if (SelectImageGallery3.getDrawable() == null) {

                        image_test3 ="0";
                        bitmap3 = BitmapFactory.decodeResource( getResources(), R.drawable.cucode);
                        //  SelectImageGallery3.setImageResource(R.drawable.cucode);

                        //  return;

                    }
                    if (SelectImageGallery4.getDrawable() == null) {

                        image_test4 ="0";
                        bitmap4 = BitmapFactory.decodeResource( getResources(), R.drawable.cucode);
                        // SelectImageGallery4.setImageResource(R.drawable.cucode);

                        // return;

                    }
                    if (SelectImageGallery5.getDrawable() == null) {
                        image_test5 ="0";
                        bitmap5 = BitmapFactory.decodeResource( getResources(), R.drawable.cucode);
                        // SelectImageGallery5.setImageResource(R.drawable.cucode);

                        //  return;

                    }
                    if (SelectImageGallery6.getDrawable() == null) {

                        image_test6 ="0";
                        bitmap6 = BitmapFactory.decodeResource( getResources(), R.drawable.cucode);
                        //   SelectImageGallery6.setImageResource(R.drawable.cucode);

                        // return;

                    }
                ImageUploadToServerFunction();

                 //  Log.d("loog",""+image_test1+image_test2+image_test3+image_test4+image_test5+image_test6);



                }

            }
        });

        //  info();
    }





    @Override
    protected void onActivityResult(int RC, int RQC, Intent I) {

        super.onActivityResult(RC, RQC, I);

        if (RC == 1 && RQC == RESULT_OK && I != null && I.getData() != null) {

            Uri uri = I.getData();

            try {


                if(image_num==1){

//                    imageView.getLayoutParams().height=200;
//                    imageView.getLayoutParams().width=200;

                    image_test1="1";
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                    SelectImageGallery.setImageBitmap(bitmap);
                    SelectImageGallery.setBackgroundResource(R.color.colorAccent2);

                }else if(image_num==2){

                    image_test2="1";
//                    imageView.getLayoutParams().height=200;
//                    imageView.getLayoutParams().width=200;


                    bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                    SelectImageGallery2.setImageBitmap(bitmap2);
                    SelectImageGallery2.setBackgroundResource(R.color.colorAccent2);

                }else  if(image_num==3){
                    image_test3="1";
//                    imageView.getLayoutParams().height=200;
//                    imageView.getLayoutParams().width=200;


                    bitmap3 = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                    SelectImageGallery3.setImageBitmap(bitmap3);
                    SelectImageGallery3.setBackgroundResource(R.color.colorAccent2);

                }else if(image_num==4){
                    image_test4="1";
                    bitmap4 = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    SelectImageGallery4.setImageBitmap(bitmap4);
                    SelectImageGallery4.setBackgroundResource(R.color.colorAccent2);

                }else  if(image_num==5){

//                    imageView.getLayoutParams().height=200;
//                    imageView.getLayoutParams().width=200;

                    image_test5="1";
                    bitmap5 = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                    SelectImageGallery5.setImageBitmap(bitmap5);
                    SelectImageGallery5.setBackgroundResource(R.color.colorAccent2);

                }else if(image_num==6){

                    image_test6="1";
//                    imageView.getLayoutParams().height=200;
//                    imageView.getLayoutParams().width=200;


                    bitmap6 = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                    SelectImageGallery6.setImageBitmap(bitmap6);
                    SelectImageGallery6.setBackgroundResource(R.color.colorAccent2);


                }






            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    public void ImageUploadToServerFunction(){




        ByteArrayOutputStream byteArrayOutputStreamObject ;

        byteArrayOutputStreamObject = new ByteArrayOutputStream();

        ByteArrayOutputStream byteArrayOutputStreamObject2 ;

        byteArrayOutputStreamObject2 = new ByteArrayOutputStream();

        ByteArrayOutputStream byteArrayOutputStreamObject3 ;

        byteArrayOutputStreamObject3 = new ByteArrayOutputStream();


        ByteArrayOutputStream byteArrayOutputStreamObject4 ;

        byteArrayOutputStreamObject4 = new ByteArrayOutputStream();

        ByteArrayOutputStream byteArrayOutputStreamObject5 ;

        byteArrayOutputStreamObject5 = new ByteArrayOutputStream();

        ByteArrayOutputStream byteArrayOutputStreamObject6 ;

        byteArrayOutputStreamObject6 = new ByteArrayOutputStream();


        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject);

        byte[] byteArrayVar = byteArrayOutputStreamObject.toByteArray();

        final String ConvertImage = Base64.encodeToString(byteArrayVar, Base64.DEFAULT);


        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject2);

        byte[] byteArrayVar2 = byteArrayOutputStreamObject2.toByteArray();

        final String ConvertImage2 = Base64.encodeToString(byteArrayVar2, Base64.DEFAULT);





        bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject3);

        byte[] byteArrayVar3 = byteArrayOutputStreamObject3.toByteArray();

        final String ConvertImage3 = Base64.encodeToString(byteArrayVar3, Base64.DEFAULT);




        bitmap4.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject4);

        byte[] byteArrayVar4 = byteArrayOutputStreamObject4.toByteArray();

        final String ConvertImage4 = Base64.encodeToString(byteArrayVar4, Base64.DEFAULT);







        bitmap5.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject5);

        byte[] byteArrayVar5 = byteArrayOutputStreamObject5.toByteArray();

        final String ConvertImage5 = Base64.encodeToString(byteArrayVar5, Base64.DEFAULT);





        bitmap6.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject6);

        byte[] byteArrayVar6 = byteArrayOutputStreamObject6.toByteArray();

        final String ConvertImage6 = Base64.encodeToString(byteArrayVar6, Base64.DEFAULT);







        class AsyncTaskUploadClass extends AsyncTask<Void,Void,String> {

            @Override
            protected void onPreExecute() {

                super.onPreExecute();

                progressDialog = ProgressDialog.show(Upload_prudect.this," جاري ارسال البيانات  "," الرجاء الانتظار",false,false);
            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);

                // Dismiss the progress dialog after done uploading.
                progressDialog.dismiss();


                p_name.setText(null);
                p_desc.setText(null);

               // imageView.setImageDrawable(null);

             //    Printing uploading success message coming from server on android app.
                        Toast.makeText(Upload_prudect.this,string1,Toast.LENGTH_LONG).show();

//                        Intent al = new Intent(Singup.this, Vcode.class);
//                        String p=phone.getText().toString();
//                        al.putExtra("phone", p);
//                        phone.setText(null);
//                        startActivity(al);
//                        finish();
//                        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

                // Setting image as transparent after done uploading.
                //  imageView.setImageResource(android.R.color.transparent);

                onBackPressed();
            }
            @Override
            protected String doInBackground(Void... params) {

                ImageProcessClass imageProcessClass = new ImageProcessClass();

                HashMap<String,String> HashMapParams = new HashMap<String,String>();

                HashMapParams.put(ImageName, GetImageNameEditText);

                HashMapParams.put("p_title",phone1);
                HashMapParams.put("p_desc",name1);
                HashMapParams.put("u_phone", u_phone);
                HashMapParams.put("p_type", type_p);
                HashMapParams.put("photo1", ConvertImage);
                HashMapParams.put("photo2", ConvertImage2);
                HashMapParams.put("photo3", ConvertImage3);
                HashMapParams.put("photo4", ConvertImage4);
                HashMapParams.put("photo5", ConvertImage5);
                HashMapParams.put("photo6", ConvertImage6);
                HashMapParams.put("imaeg_test1", image_test1);
                HashMapParams.put("imaeg_test2", image_test2);
                HashMapParams.put("imaeg_test3", image_test3);
                HashMapParams.put("imaeg_test4", image_test4);
                HashMapParams.put("imaeg_test5", image_test5);
                HashMapParams.put("imaeg_test6", image_test6);


                //////////////////////////////////////////////


                String FinalData = imageProcessClass.ImageHttpRequest(ServerUploadPath, HashMapParams);
                return FinalData;






            }
        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();

        AsyncTaskUploadClassOBJ.execute();
    }

    public class ImageProcessClass{

        public String ImageHttpRequest(String requestURL,HashMap<String, String> PData) {

            StringBuilder stringBuilder = new StringBuilder();

            try {

                URL url;
                HttpURLConnection httpURLConnectionObject ;
                OutputStream OutPutStream;
                BufferedWriter bufferedWriterObject ;
                BufferedReader bufferedReaderObject ;
                int RC ;

                url = new URL(requestURL);

                httpURLConnectionObject = (HttpURLConnection) url.openConnection();

                httpURLConnectionObject.setReadTimeout(19000);

                httpURLConnectionObject.setConnectTimeout(19000);

                httpURLConnectionObject.setRequestMethod("POST");

                httpURLConnectionObject.setDoInput(true);

                httpURLConnectionObject.setDoOutput(true);

                OutPutStream = httpURLConnectionObject.getOutputStream();

                bufferedWriterObject = new BufferedWriter(

                        new OutputStreamWriter(OutPutStream, "UTF-8"));

                bufferedWriterObject.write(bufferedWriterDataFN(PData));

                bufferedWriterObject.flush();

                bufferedWriterObject.close();

                OutPutStream.close();

                RC = httpURLConnectionObject.getResponseCode();

                if (RC == HttpsURLConnection.HTTP_OK) {

                    bufferedReaderObject = new BufferedReader(new InputStreamReader(httpURLConnectionObject.getInputStream()));

                    stringBuilder = new StringBuilder();

                    String RC2;

                    while ((RC2 = bufferedReaderObject.readLine()) != null){

                        stringBuilder.append(RC2);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();



                // Toast.makeText(Singup.this,"ddd"+e,Toast.LENGTH_LONG).show();



            }
            return stringBuilder.toString();
        }

        private String bufferedWriterDataFN(HashMap<String, String> HashMapParams) throws UnsupportedEncodingException {

            StringBuilder stringBuilderObject;

            stringBuilderObject = new StringBuilder();

            for (Map.Entry<String, String> KEY : HashMapParams.entrySet()) {

                if (check)

                    check = false;
                else
                    stringBuilderObject.append("&");

                stringBuilderObject.append(URLEncoder.encode(KEY.getKey(), "UTF-8"));

                stringBuilderObject.append("=");

                stringBuilderObject.append(URLEncoder.encode(KEY.getValue(), "UTF-8"));
            }

            return stringBuilderObject.toString();
        }

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ///  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }





    }


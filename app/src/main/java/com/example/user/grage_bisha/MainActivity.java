package com.example.user.grage_bisha;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageBase64;
import com.kosalgeek.android.photoutil.PhotoLoader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {
    public static final String NOTE_ACTION_VIEW = "jason.wei.custom.intent.action.NOTE_VIEW";
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE =0000 ;
    ImageView ivGallery;
    TextView ivGallery2;
Button  ivUpload;
    GalleryPhoto galleryPhoto;
    private ProgressDialog mProgressDialog;
    final int GALLERY_REQUEST = 1200;

    String names ;
    String passs ;

   String response_go="insert";
    String type_p;
    String phone;
    String pass;



    final String TAG = this.getClass().getSimpleName();

    LinearLayout linearMain;

    ArrayList<String> imageList = new ArrayList<>();
EditText name,des;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        name = (EditText) findViewById(R.id.editText5);
        des = (EditText) findViewById(R.id.editText6);


        phone=getIntent().getStringExtra("phone");


         pass=getIntent().getStringExtra("pass");
        type_p=getIntent().getStringExtra("prudectt");






        if(type_p.equals("4")){

         des.setHint("وصف المفقودة");

        }
     //   Toast.makeText(this,phone, Toast.LENGTH_SHORT).show();

        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (shouldShowRequestPermissionRationale(
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // Explain to the user why we need to read the contacts
            }

            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);

            // MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE is an
            // app-defined int constant that should be quite unique

            return;
        }





        linearMain = (LinearLayout)findViewById(R.id.linearMain);

        galleryPhoto = new GalleryPhoto(getApplicationContext());
        ivGallery2 = (TextView) findViewById(R.id.textView12);
        ivGallery = (ImageView)findViewById(R.id.ivGallery);
        ivUpload = (Button) findViewById(R.id.ivUpload);

        ivGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent in = galleryPhoto.openGalleryIntent();
                startActivityForResult(in, GALLERY_REQUEST);
            }
        });



        ivGallery2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent in = galleryPhoto.openGalleryIntent();
                startActivityForResult(in, GALLERY_REQUEST);
            }
        });

        final MyCommand myCommand = new MyCommand(getApplicationContext());

        ivUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                names = name.getText().toString();

           passs = des.getText().toString();

                if (TextUtils.isEmpty(names))
                {
                    name.setError("الرجاء مل الحقل");
                    return;
                }
                else if (TextUtils.isEmpty(passs)) {

                    des.setError("الرجاء مل الحقل");








                    return;
                }

                else



                    mProgressDialog = ProgressDialog.show(MainActivity.this,
                            "جاري ...","ارسال البيانات", false, false);



                for(final String imagePath: imageList){
                    try {
                        final Bitmap bitmap = PhotoLoader.init().from(imagePath).requestSize(512, 512).getBitmap();
                        final String encodedString = ImageBase64.encode(bitmap);
                   //   Toast.makeText(getApplicationContext(), ""+names+passs+response_go+type_p+phone, Toast.LENGTH_SHORT).show();
                        String url = "https://sultantec.com/pic/upload.php";
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {


                                mProgressDialog.dismiss();
                                response_go=response;
                                sucsess();



                            //   Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();


//                               if(equals(imageList.lastIndexOf(imagePath))){
//
//sucsess();
//                               }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                mProgressDialog.dismiss();
                                fillar();
                        //  Toast.makeText(getApplicationContext(), ""+error, Toast.LENGTH_SHORT).show();
                             //   Toast.makeText(getApplicationContext(), ""+names+passs+response_go+type_p+phone, Toast.LENGTH_SHORT).show();
                            }
                        }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {

                                Map<String, String> params = new HashMap<>();
                                params.put("adress", names);
                                params.put("des", passs);
                                params.put("response",response_go);
                                params.put("image", encodedString);
                                params.put("type", type_p);
                                params.put("user_phone",phone);




                                return params;
                            }
                        };

                        myCommand.add(stringRequest);

                    } catch (FileNotFoundException e) {
                     //   Toast.makeText(getApplicationContext(), "a"+e, Toast.LENGTH_SHORT).show();
                        fillar();
                    }
                }


                myCommand.execute();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){


            if(requestCode == GALLERY_REQUEST){
                galleryPhoto.setPhotoUri(data.getData());
                String photoPath = galleryPhoto.getPath();
                imageList.add(photoPath);
                Log.d(TAG, photoPath);
                try {
                    Bitmap bitmap = PhotoLoader.init().from(photoPath).requestSize(512, 512).getBitmap();

                    ImageView imageView = new ImageView(getApplicationContext());



                    LinearLayout.LayoutParams layoutParams =
                            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.MATCH_PARENT);




                    imageView.setLayoutParams(layoutParams);


                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setPadding(0, 0, 0,5);
                    imageView.setAdjustViewBounds(true);
                    imageView.setImageBitmap(bitmap);
                    imageView.getLayoutParams().height=150;
                    imageView.getLayoutParams().width=100;
                    linearMain.addView(imageView);
                    ivGallery2.setText("اضافة صورة اخري");
                    ivGallery2.setTextColor(Color.parseColor("#0d684f"));

                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Error while loading image", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }








    public void sucsess() {
        mProgressDialog.dismiss();


        name.setText(null);
        des.setText(null);



        android.support.v7.app.AlertDialog.Builder builder =new android.support.v7.app.AlertDialog.Builder(this);
        builder.setIcon(R.drawable.wwe2)
                .setTitle("تمت اضافة الاعلان بنجاح")
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









    public void fillar() {
        mProgressDialog.dismiss();




        android.support.v7.app.AlertDialog.Builder builder =new android.support.v7.app.AlertDialog.Builder(this);
        builder.setIcon(R.drawable.error)
                .setTitle("فشل الاتصال الشبكي اعد المحاولة ")
                .setCancelable(false)
                .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mProgressDialog.dismiss();
                        //onBackPressed();
                     //   onBackPressed();
                        //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

                    }
                }).setNegativeButton("رجوع", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                mProgressDialog.dismiss();
                onBackPressed();
            }

        }).show();
    }



}

package com.example.user.grage_bisha;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class ProductsAdapter3 extends RecyclerView.Adapter<ProductsAdapter3.ProductViewHolder> {

public  static String text;
    public  static String date;
    public  static String adress;
    public  static String image1;
    private ProgressDialog mProgressDialog;
    private static final int MY_SOCKET_TIMEOUT_MS = 400000;

    String con;

    public  static String content;
    public  static int  id;
    private Context mCtx;
    private List<ProductMain> productList;
   // Context mContxt;

    public ProductsAdapter3(Context mCtx, List<ProductMain> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.product_list3, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
     final ProductMain product = productList.get(position);
       // final Product product2 = productList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);


        holder.textViewTitle.setText(product.getTitle());


        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));


        //loading the image
        Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);


        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getPrice());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));



        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProductMain product = productList.get(position);
                image1=product.getImage().toString();
                text= holder.textViewShortDesc.getText().toString();
                date= holder.textViewRating.getText().toString();
                adress= holder.textViewTitle.getText().toString();
                id=product.getId();
                date= holder.textViewRating.getText().toString();

                con=product.getShortdesc().toString();


                del();






            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;
//RelativeLayout onclik;
Button del,upd;


        public ProductViewHolder(View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = (TextView) itemView.findViewById(R.id.textView62);
            textViewRating = (TextView) itemView.findViewById(R.id.textViewRating);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
           del=(Button) itemView.findViewById(R.id.button2221);
            upd=(Button) itemView.findViewById(R.id.button441);
        }




    }



















    private void del() {

        String in =Integer.toString(id);



        mProgressDialog = ProgressDialog.show(mCtx,
                "جاري ...","عملية التفريغ", false, false);


//
//        try {
//
//
//            data ="&note=" + URLEncoder.encode(coment, "UTF-8");
//
//
////
//        } catch (Exception e) {
//            // return new String("Exception: " + e.getMessage());
//
//            Toast.makeText(mCtx, "theexption"+e, Toast.LENGTH_SHORT).show();
//        }

//        String a = adress.replaceAll(" ", "%20");
//        String b= con.replaceAll(" ", "%20");
//

        // Toast.makeText(mCtx, in+a+text+date+image1+b, Toast.LENGTH_SHORT).show();


        String url = "https://sultantec.com/bisha/del_pro.php?a="+in;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                //   Toast.makeText(mContext, " [runing " + s, Toast.LENGTH_SHORT).show();

                try {

                    JSONObject jsonObject = new JSONObject(s);
                    //JSONArray array_1 = jsonObject.getJSONArray("locations");
                    String query_result = jsonObject.getString("query_result");


                    //   Toast.makeText(mContext, "Reponse : " + array_2, Toast.LENGTH_SHORT).show();
                    if (query_result.equals("SUCCESS")) {
                        Toast.makeText(mCtx, "تم حذف الاعلان" , Toast.LENGTH_LONG).show();
                        mProgressDialog.dismiss();


//
//                        Intent al = new Intent(mCtx, My_adv.class);
//
//                        mCtx.startActivity(al);

//                        My_adv cls = new My_adv();
//                        cls.loadProducts();


                    } else if (query_result.equals("FAILURE")) {
                        mProgressDialog.dismiss();
                        Toast.makeText(mCtx, "لم يتم حذف الاعلان" +query_result, Toast.LENGTH_LONG).show();

                    }


                } catch (JSONException e) {
                    //  rdr2.setVisibility(View.GONE);
                    mProgressDialog.dismiss();
                    Toast.makeText(mCtx, "لم يتم حذف الاعلان"+e , Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mProgressDialog.dismiss();
                Toast.makeText(mCtx, "لم يتم حذف الاعلان"+volleyError , Toast.LENGTH_LONG).show();
            }
        }) {
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(mCtx).add(stringRequest);
    }







}
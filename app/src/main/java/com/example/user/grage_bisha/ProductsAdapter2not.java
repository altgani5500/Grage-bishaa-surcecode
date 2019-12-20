package com.example.user.grage_bisha;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class ProductsAdapter2not extends RecyclerView.Adapter<ProductsAdapter2not.ProductViewHolder> {
    public  static int id;
public  static String text;
    public  static String date;
    public  static String adress;
    public  static String image1;
    int up=0;
    String p_id,p_title,p_desc,p_date,p_image,image11,image2,image3,image4,image5;
    private static final int MY_SOCKET_TIMEOUT_MS = 400000;
    String con;

    private Context mCtx;
    private List<ProductMain> productList;
   // Context mContxt;

    public ProductsAdapter2not(Context mCtx, List<ProductMain> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.product_list_noti, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
     final ProductMain product = productList.get(position);
       // final Product product2 = productList.get(position);

        //loading the image
//        Glide.with(mCtx)
//                .load(product.getImage())
//                .into(holder.imageView);
//

        holder.textViewRating.setText("0"+product.getRating());
        holder.textViewPrice.setText("علق صاحب الرقم اعلاه على اعلان لك");
        
//        holder.textViewRating.setText(String.valueOf(product.getRating()));
//        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
//
//
//        holder.textViewTitle.setText(product.getuser());
//        holder.textViewShortDesc.setText(product.getBody());



        holder.onclik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//text=product.getImage();
                // text=product.getImage().toString();

//                ProductMain product = productList.get(position);
//                image1=product.getImage().toString();
//                text= holder.textViewShortDesc.getText().toString();
//                date= holder.textViewRating.getText().toString();
//                adress= holder.textViewTitle.getText().toString();
//                id=product.getId();
//                date= holder.textViewRating.getText().toString();
//
//                con=product.getShortdesc().toString();
//
//                Intent al = new Intent(mCtx, Show_adv.class);
//
//
//                al.putExtra("g1", text); al.putExtra("g2", image1); al.putExtra("g3", date); al.putExtra("g4", adress);
//
//                al.putExtra("g5", id);al.putExtra("g6", con);
//
//
//                mCtx.startActivity(al);



//int p_id2=product.getId();
// p_title=product.getTitle();
//                p_desc=product.getShortdesc();
//                p_date=product.getRating();
//

                image11=product.getImage1();
                image2=product.getImage2();
                image3=product.getImage3();
                image4=product.getImage4();
                image5=product.getImage5();

            //  ProductMain product = productList.get(position);
                image1=product.getImage().toString();
                text=product.getTitle();
                date= product.getRating();
                adress=product.getPrice();
                id=product.getId();
              //  date= holder.textViewRating.getText().toString();
                con=product.getShortdesc().toString();

                Intent al = new Intent(mCtx, Show_adv.class);

                al.putExtra("g1", adress); al.putExtra("g2", image1); al.putExtra("g3", date); al.putExtra("g4", text);

                al.putExtra("g5", id);al.putExtra("g6", con);


                al.putExtra("g7", image11);al.putExtra("g8", image2);
                al.putExtra("g9", image3);al.putExtra("g10", image4);
                al.putExtra("g11", image5);



                mCtx.startActivity(al);

                //overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

                //  Toast.makeText(mCtx, "تمت الاضافة الي المفضلة" , Toast.LENGTH_LONG).show();

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
RelativeLayout onclik;



        public ProductViewHolder(View itemView) {
            super(itemView);
//            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
//            textViewShortDesc = (TextView) itemView.findViewById(R.id.textView62);
//            textViewRating = (TextView) itemView.findViewById(R.id.textViewRating);
//            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
//            imageView = (ImageView) itemView.findViewById(R.id.imageView);
//            onclik=(RelativeLayout)itemView.findViewById(R.id.onclik2);




//            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
//            textViewShortDesc = (TextView) itemView.findViewById(R.id.textView38);
            textViewRating = (TextView) itemView.findViewById(R.id.textView3);
            textViewPrice = (TextView) itemView.findViewById(R.id.textView19);
//            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            onclik=(RelativeLayout)itemView.findViewById(R.id.onclik2);

        }




    }

}
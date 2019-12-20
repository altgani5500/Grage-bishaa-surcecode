package com.example.user.grage_bisha;


import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;


public class ProductsAdapter4 extends RecyclerView.Adapter<ProductsAdapter4.ProductViewHolder> {

public  static String text;
    public  static String date;
    public  static String adress;
    public  static String image1;

    private static final float ROTATE_FROM = 0.0f;
    private static final float ROTATE_TO = -10.0f * 360.0f;


    private Context mCtx;
    private List<Product> productList;
   // Context mContxt;

    public ProductsAdapter4(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.product_list4, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
     final Product product = productList.get(position);
       // final Product product2 = productList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);


        holder.textViewTitle.setText(product.getTitle());


        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));


//        RotateAnimation r = new RotateAnimation(ROTATE_FROM, ROTATE_TO, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//
//        holder.imageView.startAnimation(r);
//
//
//// Get the background, which has been compiled to an AnimationDrawable object.
//        AnimationDrawable frameAnimation = (AnimationDrawable) holder.imageView.getDrawable();
//
//// Start the animation (looped playback by default).
//        frameAnimation.start();

        holder.onclik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//text=product.getImage();
                //text=product2.getImage().toString();

                //Product product = productList.get(position);
//                image1=product.getImage().toString();
//                text= holder.textViewShortDesc.getText().toString();
//
//                date= holder.textViewRating.getText().toString();
//                adress= holder.textViewTitle.getText().toString();
//
//                Intent al = new Intent(mCtx, News_content.class);
//
//                al.putExtra("g1", text); al.putExtra("g2", image1); al.putExtra("g3", date); al.putExtra("g4", adress);
//
//                mCtx.startActivity(al);



              //overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

    //   Toast.makeText(mCtx, "good job" +text, Toast.LENGTH_LONG).show();

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
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = (TextView) itemView.findViewById(R.id.textView62);
            textViewRating = (TextView) itemView.findViewById(R.id.textViewRating);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            onclik=(RelativeLayout)itemView.findViewById(R.id.onclik2);
        }




    }

}
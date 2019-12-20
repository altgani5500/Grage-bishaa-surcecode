package com.example.user.grage_bisha;


public class ProductMain {
    private int id;
    private String title;
    private String shortdesc;
    private String rating;
    private String price;
    private String image;

    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;

    public ProductMain(int id, String title, String shortdesc, String rating, String price, String image, String image1, String image2,
                       String image3, String image4, String image5) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.price = price;
        this.image = image;

        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;


    }

    public int getId() {
        return id;
    }

    public String getTitle() { return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public String getRating() {
        return rating;
    }

    public String getPrice() {
        return price;
    }

    public  String getImage() {
        return image;
    }





    public  String getImage1() {
        return image1;
    }
    public  String getImage2() {
        return image2;
    }
    public  String getImage3() {
        return image3;
    }
    public  String getImage4() {
        return image4;
    }
    public  String getImage5() {
        return image5;
    }
}
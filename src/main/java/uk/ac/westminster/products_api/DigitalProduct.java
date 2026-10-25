package uk.ac.westminster.products_api;

public class DigitalProduct extends Product {
    private String downloadUrl;
    private double fileSizeMb;

    public  DigitalProduct(){

    }
    public DigitalProduct(Long id,String name,double price,
                          String downloadUrl,double fileSizeMb ){
        super(id,name,price);
        this.downloadUrl= downloadUrl;
        this.fileSizeMb=fileSizeMb;

    }
    public String getDownloadUrl(){
        return downloadUrl;
    }
    public double getFileSizeMb(){
        return fileSizeMb;
    }
}

package jlgzz.basic_crawl;

import java.math.BigDecimal;

public class Offer {

    private String title;
    private String url;
    private String sku;
    private String mpn;
    private String priceRaw;
    private BigDecimal price;
    private String availabilityRaw;
    private String brand;
    private String delivery_timeRaw;
    private Integer deliveryTime;

    public Offer() {
    }

    public Offer(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getSku() {
        return sku;
    }

    public String getMpn() {
        return mpn;
    }

    public String getPriceRaw() {
        return priceRaw;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getAvailabilityRaw() {
        return availabilityRaw;
    }

    public String getBrand() {
        return brand;
    }

    public String getDelivery_timeRaw() {
        return delivery_timeRaw;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public Offer withTitle(String title) {
        this.title = title;
        return this;
    }

    public Offer withUrl(String url) {
        this.url = url;
        return this;
    }

    public Offer withSku(String sku){
        this.sku = sku;
        return this;
    }

    public Offer withMpn(String mpn){
        this.mpn = mpn;
        return this;
    }

    public Offer withPriceRaw(String priceRaw){
        this.priceRaw = priceRaw;
        return this;
    }

    public Offer withPrice(BigDecimal price){
        this.price = price;
        return this;
    }

    public Offer withAvailabilityRaw(String availabilityRaw){
        this.availabilityRaw = availabilityRaw;
        return this;
    }

    public Offer withBrand(String brand){
        this.brand = brand;
        return this;
    }

    public Offer withDelivery_timeRaw(String delivery_timeRaw){
        this.delivery_timeRaw = delivery_timeRaw;
        return this;
    }

    public Offer withDeliveryTime(Integer deliveryTime){
        this.deliveryTime = deliveryTime;
        return this;
    }


}

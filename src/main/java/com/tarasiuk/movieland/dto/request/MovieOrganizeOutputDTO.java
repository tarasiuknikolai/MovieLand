package com.tarasiuk.movieland.dto.request;

public class MovieOrganizeOutputDTO {

    private String ratingOrder;
    private String priceOrder;
    private Integer pageNumber;

    public String getRatingOrder() {
        return ratingOrder;
    }

    public void setRatingOrder(String ratingOrder) {
        this.ratingOrder = ratingOrder;
    }

    public String getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(String priceOrder) {
        this.priceOrder = priceOrder;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "MovieOrganizeOutputDTO{" +
                "ratingOrder='" + ratingOrder + '\'' +
                ", priceOrder='" + priceOrder + '\'' +
                ", pageNumber=" + pageNumber +
                '}';
    }
}


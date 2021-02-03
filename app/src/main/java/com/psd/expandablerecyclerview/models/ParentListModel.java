package com.psd.expandablerecyclerview.models;

import java.util.ArrayList;

public class ParentListModel {
    String ProductNumber, sku, mobile;
    public boolean isExpandable;
    ArrayList<ExpandableChildListModel> childList;

    public ArrayList<ExpandableChildListModel> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<ExpandableChildListModel> childList) {
        this.childList = childList;
    }

    public ParentListModel() {
        this.isExpandable = false;
    }

    public String getProductNumber() {
        return ProductNumber;
    }

    public void setProductNumber(String productNumber) {
        ProductNumber = productNumber;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean extamble) {
        isExpandable = extamble;
    }
}

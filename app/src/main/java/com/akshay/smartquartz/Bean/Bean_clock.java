package com.akshay.smartquartz.Bean;

public class Bean_clock {

    int TID;
    int CID;
    String Model_No;
    int Size_l;
    int Size_b;
    int Size_h;
    String Image;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public String getModel_No() {
        return Model_No;
    }

    public void setModel_No(String model_No) {
        Model_No = model_No;
    }

    public int getSize_l() {
        return Size_l;
    }

    public void setSize_l(int size_l) {
        Size_l = size_l;
    }

    public int getSize_b() {
        return Size_b;
    }

    public void setSize_b(int size_b) {
        Size_b = size_b;
    }

    public int getSize_h() {
        return Size_h;
    }

    public void setSize_h(int size_h) {
        Size_h = size_h;
    }
}

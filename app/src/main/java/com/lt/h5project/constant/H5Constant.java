package com.lt.h5project.constant;

import com.lt.h5project.bean.AddressBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project
 * @class describe
 * @time 2019-06-18 10:25
 * @change
 * @chang time
 * @class describe
 */
public class H5Constant {
    //1
    public List<AddressBean> ReadList = new ArrayList<>();
    //2
    public static List<AddressBean> AggregationList = new ArrayList<>();
    //3
    public static List<AddressBean> PicList = new ArrayList<>();
    //4
    public static List<AddressBean> VideoList = new ArrayList<>();
    //5
    public static List<AddressBean> CookBookList = new ArrayList<>();
    //6
    public static List<AddressBean> CartoonList = new ArrayList<>();
    //7
    public static List<AddressBean> PicContextList = new ArrayList<>();
    //8
    public static List<AddressBean> BeautyList = new ArrayList<>();
    //9
    public static List<AddressBean> CarList = new ArrayList<>();
    //10
    public static List<AddressBean> GoldList = new ArrayList<>();
    //11
    public static List<AddressBean> NewPicList = new ArrayList<>();
    //12

    public H5Constant() {
        //1
        if (ReadList != null && ReadList.size() > 0) {
            return;
        }
        //2
        if (AggregationList != null && AggregationList.size() > 0) {
            return;
        }
        //3
        if (PicList != null && PicList.size() > 0) {
            return;
        }
        //4
        if (VideoList != null && VideoList.size() > 0) {
            return;
        }
        //5
        if (CookBookList != null && CookBookList.size() > 0) {
            return;
        }
        //6
        if (CartoonList != null && CartoonList.size() > 0) {
            return;
        }
        //7
        if (PicContextList != null && PicContextList.size() > 0) {
            return;
        }
        //8
        if (BeautyList != null && BeautyList.size() > 0) {
            return;
        }
        //9
        if (CarList != null && CarList.size() > 0) {
            return;
        }
        //10
        if (GoldList != null && GoldList.size() > 0) {
            return;
        }
        //11
        if (NewPicList != null && NewPicList.size() > 0) {
            return;
        }
        //12
    }
}

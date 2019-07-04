package com.lt.h5project;

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
public class H5AggregationAddressConstant {
    public static List<AddressBean> AggregationList = new ArrayList<>();

    public H5AggregationAddressConstant() {
        AggregationList.add(new AddressBean(1, "时间链", "时间链", "http://t.channel.45xie.com/api/api?action=showpage&page=index&appid=D9372F3FA907D1199BF5440F95982514&_pos=home"));
        AggregationList.add(new AddressBean(2, "爱尚天气", "爱尚天气", "http://t.channel.45xie.com/api/api?action=showpage&page=index&appid=A0E65217F194E9FEBFBD0FECAC1BB6D9&_pos=home"));



    }
}

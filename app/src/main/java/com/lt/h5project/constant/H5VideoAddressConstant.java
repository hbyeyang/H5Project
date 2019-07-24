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
public class H5VideoAddressConstant {
    public static List<AddressBean> VideoList = new ArrayList<>();

    public H5VideoAddressConstant() {
        if (VideoList != null && VideoList.size() > 0) {
            return;
        }
        VideoList.add(new AddressBean(1, "爆米花01", "爆米花01", "http://t.channel.45xie.com/api/api?action=showpage&page=videolist&appid=5F963A4CFF18B38CAC7762A78FC13850&_pos=home&guest=s"));
    }
}

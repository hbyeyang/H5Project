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
public class H5CarConstant {
    public static List<AddressBean> CarList = new ArrayList<>();

    public H5CarConstant() {
        if (CarList != null && CarList.size() > 0) {
            return;
        }
        CarList.add(new AddressBean(1, "未知", "未知", "www.baidu.com"));
    }
}

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
public class H5CookBookAddressConstant {
    public static List<AddressBean> CookBookList = new ArrayList<>();

    public H5CookBookAddressConstant() {
        if (CookBookList != null && CookBookList.size() > 0) {
            return;
        }
        CookBookList.add(new AddressBean(1, "未知", "未知", "www.baidu.com"));
    }
}

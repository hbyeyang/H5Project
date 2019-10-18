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
public class H5BeautyConstant {
    public static List<AddressBean> BeautyList = new ArrayList<>();

    public H5BeautyConstant() {
        if (BeautyList != null && BeautyList.size() > 0) {
            return;
        }
        BeautyList.add(new AddressBean(1, "未知", "未知", "www.baidu.com"));
    }
}

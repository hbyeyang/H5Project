package com.lt.h5project;

import java.io.Serializable;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project
 * @class describe
 * @time 2019-06-18 10:29
 * @change
 * @chang time
 * @class describe
 */
public class AddressBean implements Serializable {
    /**
     * 编号
     */
    public int number;

    /**
     * 域名
     */
    public String domainame;
    /**
     * 渠道名称
     */
    public String ChannelName;
    /**
     * 渠道地址
     */
    public String ChannelAddress;

    public AddressBean(int number, String domainame, String channelName, String channelAddress) {
        this.number = number;
        this.domainame = domainame;
        ChannelName = channelName;
        ChannelAddress = channelAddress;
    }
}

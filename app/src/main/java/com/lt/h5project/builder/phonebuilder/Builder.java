package com.lt.h5project.builder.phonebuilder;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project.build
 * @class describe
 * @time 2019-12-15 11:38
 * @change
 * @chang time
 * @class describe
 */
public abstract class Builder {

    public abstract void setPhoneNumber(String phoneNumber);
    public abstract void setBrand(String brand);
    public abstract void setVersion(String version);
    public abstract Phone create();
}
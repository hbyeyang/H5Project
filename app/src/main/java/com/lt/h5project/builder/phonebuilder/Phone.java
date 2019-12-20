package com.lt.h5project.builder.phonebuilder;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project.build
 * @class describe
 * @time 2019-12-15 11:36
 * @change
 * @chang time
 * @class describe
 */
public class Phone {
    private String phoneNumber;
    private String brand;
    private String version;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}

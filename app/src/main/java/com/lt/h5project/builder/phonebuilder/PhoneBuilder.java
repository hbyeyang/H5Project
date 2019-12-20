package com.lt.h5project.builder.phonebuilder;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project.build
 * @class describe
 * @time 2019-12-15 11:50
 * @change
 * @chang time
 * @class describe
 */
public class PhoneBuilder extends Builder {
    Phone mPhone = new Phone();

    @Override
    public void setPhoneNumber(String phoneNumber) {
        mPhone.setPhoneNumber(phoneNumber);
    }

    @Override
    public void setBrand(String brand) {
        mPhone.setBrand(brand);
    }

    @Override
    public void setVersion(String version) {
        mPhone.setVersion(version);
    }

    @Override
    public Phone create() {
        return mPhone;
    }
}

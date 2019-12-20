package com.lt.h5project.builder;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project.builder
 * @class describe
 * @time 2019-12-15 15:13
 * @change
 * @chang time
 * @class describe
 */
public class Cat {

    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat(CatBuilder catBuilder){
        this.name = catBuilder.name;
        this.color = catBuilder.color;
    }

    public static class CatBuilder{
        String name;
        String color;

        public CatBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CatBuilder color(String color) {
            this.color = color;
            return this;
        }

        public Cat build(){
            return new Cat(this);
        }

    }
}

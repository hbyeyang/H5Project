package com.lt.h5project.builder.dogbuilder;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project.builder.dogbuilder
 * @class describe
 * @time 2019-12-15 14:22
 * @change
 * @chang time
 * @class describe
 */
public class Dog {

    private String name;
    private int age;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private Dog(DogBuilder dogBuilder) {
        this.name = dogBuilder.name;
        this.age = dogBuilder.age;
        this.color = dogBuilder.color;
    }

    public static class DogBuilder {
        private String name;
        private int age;
        private String color;

        public DogBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DogBuilder age(int age) {
            this.age = age;
            return this;
        }

        public DogBuilder color(String color) {
            this.color = color;
            return this;
        }

        public Dog build(){
            return new Dog(this);
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}

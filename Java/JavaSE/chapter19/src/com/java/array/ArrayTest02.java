package com.java.array;
/*
    向数组中存储引用数据类型
 */
public class ArrayTest02 {
    public static void main(String[] args) {
    //创建一个Animal类型的数组
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        Animal[] animals = {a1, a2};

        //遍历Animal数组
//        for (int i = 0; i < animals.length; i++) {
//            animals[i].move();
//        }

        //引用数据类型中可以存放子类对象
        Cat c = new Cat();
        Animal[] animals1 = new Animal[2];//动态初始化一个Animal数组
        Bird b = new Bird();
        animals1[0] = c;
        animals1[1] = b;//可以存入多个不同子类对象

    }
}

class Animal{
    public void move(){
        System.out.println("Animal move.");
    }

}

class Cat extends Animal{
    @Override
    public void move() {
        System.out.println("Cat move.");
    }
}

class Bird extends Animal{
    @Override
    public void move() {
        System.out.println("Bird move.");
    }
}

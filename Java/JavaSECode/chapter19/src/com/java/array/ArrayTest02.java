package com.java.array;
/*
    �������д洢������������
 */
public class ArrayTest02 {
    public static void main(String[] args) {
    //����һ��Animal���͵�����
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        Animal[] animals = {a1, a2};

        //����Animal����
//        for (int i = 0; i < animals.length; i++) {
//            animals[i].move();
//        }

        //�������������п��Դ���������
        Cat c = new Cat();
        Animal[] animals1 = new Animal[2];//��̬��ʼ��һ��Animal����
        Bird b = new Bird();
        animals1[0] = c;
        animals1[1] = b;//���Դ�������ͬ�������

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

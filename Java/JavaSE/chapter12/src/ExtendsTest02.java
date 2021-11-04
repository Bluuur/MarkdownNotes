public class ExtendsTest02 {
}
class A{

}
class B{

}
class C extends A{

}

//语法错误
//Java只允许单继承,不允许多继承.Java是简单的,C++支持多重继承
//class D extends A,B{
//
//}

class X{

}

class Y extends X{

}
//这样也说明了Z是继承X和Y的
//这样描述:Z直接继承了Y,Z间接继承了X
class Z extends Y{

}
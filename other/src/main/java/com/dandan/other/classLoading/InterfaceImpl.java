package com.dandan.other.classLoading;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-13
 */
public class InterfaceImpl implements Sub{

    public static void main(String[] args) {
        System.out.println("miaomiao");

    }

    @Override
    public void print(String name) {

    }

    @Override
    public void sout() {

    }

}

interface Super1{
    int sum(int a, int b);
}
interface Super2{
    int sum(int a, int b);

    void sout();
}

interface Sub extends Super1,Super2{

    @Override
    default int sum(int a, int b) {
        return 0;
    }

    void print(String name);

}

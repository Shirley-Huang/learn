package com.dandan.other.keywords.TransientKey;

import java.io.*;

/**
 * @Description
 * @Author dandan
 * @Date 2021/2/20
 */
public class TransientTest {

    public static void main(String[] args){

        //写入
        ObjectOutputStream oos = null;
        User user = new User("凉风风","abc123",26,'M',true,System.currentTimeMillis(),24.12);
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("transientFile")));
            oos.writeObject(user);
            System.out.println(user.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != oos){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //读取
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("transientFile")));
            User user2 = (User)ois.readObject();
            System.out.println(user2.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != ois){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

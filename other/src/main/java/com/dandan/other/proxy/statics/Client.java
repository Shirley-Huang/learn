package com.dandan.other.proxy.statics;

import com.dandan.other.proxy.impl.UserManager;
import com.dandan.other.proxy.impl.UserManagerImpl;

import java.util.Date;

/**
 * Created by dandan On 九月 03 2019
 */
public class Client {

    public static void main(String[] args) {
        UserManager userManager = new UserManagerProxy(new UserManagerImpl());
        userManager.addUser();


        String date="2019-09-04 19:17:05";
        Date date1 = new Date(date);
        System.out.println(date);
    }

}

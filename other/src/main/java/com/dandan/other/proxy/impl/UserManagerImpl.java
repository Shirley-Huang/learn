package com.dandan.other.proxy.impl;

/**
 * Created by dandan On 九月 03 2019
 */
public class UserManagerImpl implements UserManager {

    public void addUser() {
        System.out.println("UserManagerImpl.addUser");
    }

    public void deleteUser() {
        System.out.println("UserManagerImpl.deleteUser");
    }

    public String findUser(String userId) {
        System.out.println("UserManagerImpl.findUser");
        return "黄丹丹";
    }

    public void modifyUser(String userId, String userName) {
        System.out.println("UserManagerImpl.modifyUser");
    }

}

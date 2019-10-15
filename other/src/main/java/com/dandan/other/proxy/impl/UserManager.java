package com.dandan.other.proxy.impl;

/**
 * Created by dandan On 九月 03 2019
 */
public interface UserManager {

    public void addUser();

    public void deleteUser();

    public String findUser(String userId);

    public void modifyUser(String userId, String userName);


}

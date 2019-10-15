package com.dandan.other.proxy.statics;

import com.dandan.other.proxy.impl.UserManager;
import com.dandan.other.proxy.impl.UserManagerImpl;

/**
 * Created by dandan On 九月 03 2019
 */
public class UserManagerProxy implements UserManager {

    //目标对象
    private UserManagerImpl userManager;

    //通过构造方法传入目标对象
    public UserManagerProxy(UserManagerImpl userManager) {
        this.userManager = userManager;
    }

    public void addUser() {

        try{

            //添加打印日志功能
            //添加用户
            System.out.println("start---->addUser()");
            userManager.addUser();
            System.out.println("successed---->addUser()");

        }catch (Exception e){
            //添加用户失败
            System.out.println("error---->addUser()");
        }


    }

    public void deleteUser() {
        userManager.deleteUser();
    }

    public String findUser(String userId) {
        return userManager.findUser("1");
    }

    public void modifyUser(String userId, String userName) {
        userManager.modifyUser(userId,userName);
    }

}

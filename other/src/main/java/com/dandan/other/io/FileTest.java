package com.dandan.other.io;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description
 * @Author dandan
 * @Date 2020/11/7
 */
public class FileTest {

    public void test001() throws Exception {

//        String currentProjectPath = System.getProperty("user.dir");

        String currentProjectPath = "/data/data/com.tencent.mm";
        System.out.println(currentProjectPath);

//        File file = new File("io.txt");
        File file = new File(currentProjectPath);
        System.out.println(file.exists());

        if(file.exists()){
            //如果文件存在就打印文件内容
            InputStream reader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            reader.read(bytes);
            reader.close();
            System.out.println(new String(bytes));
        }else{
            //如果文件不存在，就创建文件并写入内容
            file.createNewFile();
            Writer writer = new FileWriter(file);
            writer.write("hello 大家好");
            writer.write("欢迎来到 java 程序猿社区");
            writer.append("\n谢谢，欢迎下次光临");
            writer.close();
        }
    }

    @Test
    public void FilesTest() throws IOException {
        switch ("A"){
            case "A":
            case   "B":
                break;
        }
        System.out.println(Files.size(Paths.get("/Users/dandan/WorkSpace/myProjects/Shirley03/learn/io.txt")));
    }

    static {
        System.out.println("静态代码块");
    }
    {
        System.out.println("代码块");
    }

    public FileTest(){
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        System.out.println("main方法");
        new FileTest();
    }

}

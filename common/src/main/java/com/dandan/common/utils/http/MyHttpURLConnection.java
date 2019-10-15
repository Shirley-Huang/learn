package com.dandan.common.utils.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author : HuangDandan
 * @CreateTime : 2019/5/31
 * @Desciption :java原生的HttpURLConnnection
 */
public class MyHttpURLConnection {


    public static void main(String[] args) {


        String get = doGet("https://cbs-admin.jiangyunshouhou.com/services/common/cd/resource/data/merchant/tag/types");
        System.out.println(get);


    }

    public static String doGet(String httpUrl){
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;
        try{

            //创建远程url连接对象
            URL url = new URL(httpUrl);

            //通过远程url连接对象打开一个连接，强转成httpUrlConnection类
            connection = (HttpURLConnection)url.openConnection();

            //设置连接方式：GET
            connection.setRequestMethod("GET");

            //设置连接主机服务器的超时时间（15000毫秒）
            connection.setConnectTimeout(15000);

            //设置读取远程返回的数据时间（60000毫秒）
            connection.setReadTimeout(60000);

            //发送请求
            connection.connect();

            if(connection.getResponseCode() == 200){
                //通过connection连接获取输入流
                is = connection.getInputStream();

                //封装输入流is，并制定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while( (temp = br.readLine()) != null ){
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();

            }


        }catch (Exception e){
            e.printStackTrace();
        }finally{
            //关闭资源
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();//关闭远程连接
        }


        return result;
    }

    public static String doPost(String httpUrl, String param) throws Exception{

        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;

        try{
            URL url = new URL(httpUrl);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(60000);

            //默认值：false， 当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            //默认值：false，当前向远程服务器读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);
            //设置传入参数的格式：请求参数应该是name1=value1&name2=value2的形式
            connection.setRequestProperty("Content-Type","applicant/x-www-form-urlencoded");
            //设置鉴权
            connection.setRequestProperty("Authorization", "XXXXXXXXXXXXXXXXXXXXXXXX");

            //通过连接对象获取一个输出流
            os= connection.getOutputStream();
            //通过输出流对象将参数写出去/传输出去，它是通过字节数组写出的
            os.write(param.getBytes());

            connection.connect();

            if(connection.getResponseCode() == 200){

                is = connection.getInputStream();
                //对输入流对象进行包装：charset根据工作项目组的要求来设置
                br = new BufferedReader(new InputStreamReader(is));

                StringBuffer sbf = new StringBuffer();
                String temp = null;

                while((temp = br.readLine()) != null){
                    sbf.append(temp);
                    sbf.append("\n");
                }
                result = sbf.toString();

            }

        }catch (Exception e){

        }finally {
            if(null != is){
                is.close();
            }
            if(null != os){
                os.close();
            }
            connection.disconnect();
        }

        return result;
    }


}

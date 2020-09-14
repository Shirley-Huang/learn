package com.dandan.common.utils.http;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author : HuangDandan
 * @CreateTime : 2019/5/31
 * @Desciption :
 */
public class MyHttpClient {

    @Test
    public void test() throws Exception{

        String result = doGet("https://cbs-admin.jiangyunshouhou.com/services/common/cd/resource/data/merchant/tag/types");
        System.out.println(result);
    }

    public static String doGet(String httpUrl) throws Exception{

        InputStream is = null;
        BufferedReader br = null;
        String result = null;

        //创建httpClient实例
        HttpClient httpClient = new HttpClient();

        //设置http连接主机服务超时时间：15000
        //先获取连接管理器对象，再获取参数对象，再进行参数的赋值
        HttpConnectionManager httpConnectionManager = httpClient.getHttpConnectionManager();
        HttpConnectionManagerParams params = httpConnectionManager.getParams();
        params.setConnectionTimeout(15000);

        //创建一个GET方法实例对象
        GetMethod getMethod = new GetMethod(httpUrl);

        //设置请求重试机制，默认重试次数：3次，参数设置为true，重试机制可用，false相反
        HttpMethodParams httpMethodParams = getMethod.getParams();
        httpMethodParams.setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, true));

        try{

            //执行get方法
            int statusCode = httpClient.executeMethod(getMethod);

            //判断状态码
            if(statusCode != HttpStatus.SC_OK){
                //如果状态码返回的不是ok说明失败了，打印错误信息
                System.err.println("Method faild:" + getMethod.getStatusLine());
            }else{

                //通过getMethod实例，获取远程的一个输入流
                is = getMethod.getResponseBodyAsStream();

                //包装输入流
                br = new BufferedReader(new InputStreamReader(is));

                StringBuffer sbf = new StringBuffer();
                String temp = null;

                while ((temp = br.readLine()) != null){
                    sbf.append(temp);
                    sbf.append("\r\n");
                }

                result = sbf.toString();
            }

        }catch (Exception e){

        }finally {
            if(null != is){
                is.close();
            }

            if(null != br){
                br.close();
            }
            //释放连接
            getMethod.releaseConnection();
        }


        return result;

    }


}

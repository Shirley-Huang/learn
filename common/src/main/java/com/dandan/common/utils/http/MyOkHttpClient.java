package com.dandan.common.utils.http;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.concurrent.TimeUnit;

/**
 * @Author : HuangDandan
 * @CreateTime : 2019/5/28
 * @Desciption :
 */
public class MyOkHttpClient {

    //创建OkHttpClient对象
    private OkHttpClient client = new OkHttpClient();

    //GET request
    public void sendRequest(){
        String url = "https://cbs-admin.jiangyunkeji.com/services/common/cd/resource/data/merchant/tag/types";

        //构造Request对象
        Request request = new Request.Builder().url(url).get().build();

        try{

            //通过okHttpClient对象和request对象创建Call对象
            Call call = client.newCall(request);

            //通过Call（Callback）方法来提交异步请求
            Response response = call.execute();

            //异步发起的请求会被加入到Dispatcher中的runningAsyncCalls双端队列中通过线程池来执行

            String responseStr = response.body().string();
            System.out.println(responseStr);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void setProperties(){

        OkHttpClient client2 = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10,TimeUnit.SECONDS)
            .writeTimeout(10,TimeUnit.SECONDS).build();
    }

    class A{
        private Integer id;
        private String name;
        public A(Integer id, String name){
            this.id = id;
            this.name = name;
        }

        public A(){

        }
    }
}

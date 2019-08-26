package com.dandan.common.model.filter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dandan On 八月 25 2019
 */
public class OrderByBuilder implements ResourceLoaderAware, InitializingBean {

    private static final Map<String, Map<String, String >> MAPPINGS;

    private ResourceLoader resourceLoader;
    private String configFile;



    /**
     * 先初始化该类，在执行相关初始化方法afterPropertiesSet、init-method
     */
    static {
        System.out.println(OrderByBuilder.class.getName()+"  execute InitializingBean static method-----");
        MAPPINGS = new HashMap<String, Map<String, String>>();
    }

    {
        System.out.println(OrderByBuilder.class.getName()+"  execute InitializingBean code method-----");
    }

    public void afterPropertiesSet(){
        System.out.println(OrderByBuilder.class.getName()+"  execute InitializingBean afterPropertiesSet method-----");
        try{

            Resource resource = resourceLoader.getResource(configFile);

            InputStream is = resource.getInputStream();
            if(is == null){
                return;
            }

            init();
        }catch (Exception e){

        }
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {

    }

    public void init() throws Exception{
        System.out.println(OrderByBuilder.class.getName()+"  execute InitializingBean init method-----");
    }

}

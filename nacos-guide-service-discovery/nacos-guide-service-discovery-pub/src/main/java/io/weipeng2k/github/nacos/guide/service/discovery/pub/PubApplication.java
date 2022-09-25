package io.weipeng2k.github.nacos.guide.service.discovery.pub;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

/**
 * @author weipeng2k 2022年09月25日 下午16:05:10
 */
@SpringBootApplication
public class PubApplication implements CommandLineRunner, InitializingBean {

    private NamingService namingService;

    public static void main(String[] args) {
        SpringApplication.run(PubApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Instance instance = new Instance();
        instance.setInstanceId("192.168.50.177:8080");
        instance.setIp("192.168.50.177");
        instance.setPort(8080);
        namingService.registerInstance("io.github.weipeng2k.scheduler.works", instance);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.SERVER_ADDR, "192.168.50.102:8848");
        properties.setProperty(PropertyKeyConst.NAMESPACE, "public");
        properties.setProperty(PropertyKeyConst.USERNAME, "nacos");
        properties.setProperty(PropertyKeyConst.PASSWORD, "nacos");
        namingService = NacosFactory.createNamingService(properties);
    }
}
package com.overstar.elasticsearch;

import com.overstar.elasticsearch.service.field.ProductNameZhHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticsearchApplication.class)
@ActiveProfiles(value = "test")
public class ElasticsearchApplicationTests {

    @Autowired
    private ProductNameZhHandler zhHandler;
    @Test
    public void contextLoads() {
//        List<Map<String, Object>> asdfg = zhHandler.configFieldAnalyzeCustomMap("[]【今天在工作过程中遇到了一个很奇怪的mysql查询问题，" +
//                "当作为查询条件的字符串末尾有空格时，可以查到数据库中末尾不含空格的值。经过多次查阅资料，】最后找到三种解决的方法，现在分享给大家");

        List<Map<String, Object>> asdfg = zhHandler.configFieldAnalyzeCustomMap("中华人民共和国国歌");
//        List<Map<String, Object>> asdfg = zhHandler.configFieldAnalyzeCustomMap("今天在工作过程中遇到了一个很奇怪的mysql查询问题");
        System.out.println(asdfg);
    }



}

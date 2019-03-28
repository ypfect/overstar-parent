package com.overstar.elasticsearch.service;

import com.overstar.elasticsearch.utils.ElasticsearchOpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/28 23:26
 */
@Service
public class YouKnow4SearchService {

    public static final Logger logger = LoggerFactory.getLogger("es");

    @Autowired
    private ElasticsearchOpService opService;

    public void initEsIndex(){
        long time = System.currentTimeMillis();
        logger.info("根据别名获取索引集合..");
        List<String> es = opService.getIndexesByAliases("es");
//        int indexed = initService.reIndex(Index.PRODUCT_ALL, inputDocumentDao.queryAll(Constant.INDEX_STATUS.get(Index.PRODUCT_ALL)));
//        logger.info(" RefreshAllIndex success, indexed [{}] documents, spend {}ms.", indexed,
//                (System.currentTimeMillis() - time));
    }
}

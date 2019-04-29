package com.overstar.elasticsearch.constant;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/28 21:33
 */
public interface ProductSearchConstant {

    //线上单独售卖状态
    Set<Integer> ONLINE_STATUS = Sets.newHashSet(200);
    //默认最多国家个数
    Integer COUNTRIES_MAX = 100;
    //默认最多城市个数
    Integer CITIES_MAX = 300;
    //最低分数
    float MIN_SCORE = 500f;
    String TYPE = "_doc";
    String INDEX_OVERSTAR = "overstar";
    String INDEX_YPFECT = "ypfect";


    // ~ es-settings & mapping
    // ====================================================================================================================
    interface Index {
        String SETTINGS ="{\n" +
                "        \"index\" : {\n" +
                "            \"number_of_shards\" : 5,\n" +
                "            \"number_of_replicas\" : 1\n" +
                "        },\n" +
                "        \"analysis\": {\n" +
                "\t\t\t\"analyzer\": {\n" +
                "\t\t        \"autocomplete\": {\n" +
                "\t\t\t\t\t\"tokenizer\": \"keyword\",\n" +
                "\t\t\t\t\t\"filter\": [\n" +
                "\t\t\t            \"pinyin\",\n" +
                "\t\t\t            \"lowercase\",\n" +
                "\t\t\t            \"cjk_width\"\n" +
                "\t\t\t\t\t]\n" +
                "\t\t        },\n" +
                "\t\t        \"first_py_letter_analyzer\": {\n" +
                "                    \"tokenizer\": \"first_py_letter\",\n" +
                "\t\t\t\t\t\"filter\":\"edgeNGram\"\n" +
                "                },\n" +
                "                \"full_pinyin_letter_analyzer\": {\n" +
                "                    \"tokenizer\": \"full_pinyin_letter\",\n" +
                "                    \"filter\":\"edgeNGram\"\n" +
                "                },\n" +
                "                \"full_pinyin_letter_analyzer-test\": {\n" +
                "                   \"tokenizer\": \"keyword\",\n" +
                "                   \"filter\":[\"edgeNGram\", \"lowercase\"]\n" +
                "                },\n" +
                "                \"ik_smart_synonym\" : {\n" +
                "                \t\"tokenizer\": \"ik_smart\",\n" +
                "                \t\"filter\" : \"graph_synonyms\"\n" +
                "                },\n" +
                "                \"ik_maxword_synonym\" : {\n" +
                "                \t\"tokenizer\": \"ik_max_word\",\n" +
                "                \t\"filter\" : \"graph_synonyms\"\n" +
                "                }\n" +
                "\t\t\t},\n" +
                "\t\t\t\"tokenizer\" : {\n" +
                "                \"first_py_letter\": {\n" +
                "                    \"type\" : \"pinyin\",\n" +
                "                    \"keep_first_letter\" : true,\n" +
                "                    \"keep_full_pinyin\" : false,\n" +
                "                    \"keep_original\" : false,\n" +
                "                    \"limit_first_letter_length\" : 16,\n" +
                "                    \"lowercase\" : true,\n" +
                "                    \"trim_whitespace\" : true,\n" +
                "                    \"keep_none_chinese_in_first_letter\": false,\n" +
                "                    \"none_chinese_pinyin_tokenize\": false,\n" +
                "                    \"keep_none_chinese\": true,\n" +
                "                    \"keep_none_chinese_in_joined_full_pinyin\": true\n" +
                "                },\n" +
                "                \"full_pinyin_letter\": {\n" +
                "                    \"type\" : \"pinyin\",\n" +
                "                    \"keep_first_letter\" : false,\n" +
                "                    \"keep_full_pinyin\" : true,\n" +
                "                    \"keep_none_chinese\" : true,\n" +
                "                    \"keep_separate_first_letter\" : true,\n" +
                "                    \"keep_original\" : false,\n" +
                "                    \"limit_first_letter_length\" : 16,\n" +
                "                    \"lowercase\" : true,\n" +
                "                    \"trim_whitespace\" : true,\n" +
                "                    \"keep_none_chinese_in_first_letter\" : true\n" +
                "                }\n" +
                "            },\n" +
                "            \"filter\":{\n" +
                "\t\t\t\t\"edgeNGram\":{\n" +
                "\t\t\t\t\t\"type\": \"edgeNGram\",\n" +
                "\t\t\t\t\t\"min_gram\": 2,\n" +
                "\t\t\t\t\t\"max_gram\": 15,\n" +
                "\t\t\t\t\t\"token_chars\": [\"letter\", \"digit\"]\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"graph_synonyms\": {\n" +
                "\t\t\t\t\t\"type\": \"synonym_graph\",\n" +
                "            \t\t\"synonyms_path\": \"synonym.txt\"\n" +
                "\t\t\t\t}\t\t\t\t\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "    }";

        String MAPPINGS = "{\n" +
                "\t    \"_doc\" : {\n" +
                "\t\t\t\"properties\" : {\n" +
                "\t\t\t\t\"productNameZh\" : {\n" +
                "\t\t\t\t\t\"type\" :   \"keyword\",\n" +
                "\t\t\t\t\t\"index\": true,\n" +
                "\t\t\t\t\t\"fields\": {\n" +
                "                        \"ik\": {\n" +
                "                            \"type\": \"text\",\n" +
                "                            \"analyzer\": \"ik_maxword_synonym\",\n" +
                "\t\t\t\t\t\t\t\"search_analyzer\": \"ik_smart_synonym\"\n" +
                "                        },\n" +
                "                        \"pinyin\": {\n" +
                "                            \"type\": \"text\",\n" +
                "                            \"analyzer\": \"full_pinyin_letter_analyzer\"\n" +
                "                        },\n" +
                "                        \"first_py\": {\n" +
                "                            \"type\": \"text\",\n" +
                "                            \"analyzer\": \"first_py_letter_analyzer\"\n" +
                "                        }\n" +
                "                    }\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"productNameZhPy\" : {\n" +
                "\t\t\t\t\t\"type\" :   \"text\",\n" +
                "\t\t\t\t\t\"analyzer\": \"full_pinyin_letter_analyzer-test\",\n" +
                "\t\t\t\t\t\"search_analyzer\": \"full_pinyin_letter_analyzer-test\"\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"productNameEn\" : {\n" +
                "\t\t\t\t\t\"type\" :   \"text\",\n" +
                "\t\t\t\t\t\"analyzer\": \"ik_max_word\",\n" +
                "\t\t\t\t\t\"search_analyzer\": \"ik_max_word\"\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"productNameEnNotAnalyzed\" : {\n" +
                "\t\t\t\t\t\"type\" :   \"keyword\",\n" +
                "\t\t\t\t\t\"index\" : true\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"tagNamesZh\" : {\n" +
                "\t\t\t\t\t\"type\" : \"keyword\",\n" +
                "\t\t\t\t\t\"index\" : true\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"tagNamesPy\" : {\n" +
                "\t\t\t\t\t\"type\" : \"keyword\",\n" +
                "\t\t\t\t\t\"index\" : true\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"countryNameZh\" : {\n" +
                "\t\t\t\t\t\"type\" :   \"keyword\",\n" +
                "\t\t\t\t\t\"index\" : true\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"countryNamePy\" : {\n" +
                "\t\t\t\t\t\"type\" :   \"keyword\",\n" +
                "\t\t\t\t\t\"index\" : true\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"countryNameEn\" : {\n" +
                "\t\t\t\t\t\"type\" :   \"keyword\",\n" +
                "\t\t\t\t\t\"index\" : true\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"cityNameZh\" : {\n" +
                "\t\t\t\t\t\"type\" :   \"keyword\",\n" +
                "\t\t\t\t\t\"index\" : true\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"cityNamePy\" : {\n" +
                "\t\t\t\t\t\"type\" :   \"keyword\",\n" +
                "\t\t\t\t\t\"index\" : true\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"cityNameEn\" : {\n" +
                "\t\t\t\t\t\"type\" :   \"keyword\",\n" +
                "\t\t\t\t\t\"index\" : true\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"viewspotsZh\" : {\n" +
                "\t\t\t\t\t\"type\" :   \"keyword\",\n" +
                "\t\t\t\t\t\"index\" : true\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"viewspotsPy\" : {\n" +
                "\t\t\t\t\t\"type\" :   \"keyword\",\n" +
                "\t\t\t\t\t\"index\" : true\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"supplierName\" : {\n" +
                "\t\t\t\t\t\"type\" :   \"keyword\",\n" +
                "\t\t\t\t\t\"index\" : true\n" +
                "\t\t\t    },\n" +
                "\t\t\t    \"suggestText\": {\n" +
                "\t\t\t    \t\"type\": \"completion\",\n" +
                "                    \"analyzer\": \"autocomplete\",\n" +
                "\t\t\t\t\t\"search_analyzer\": \"autocomplete\",\n" +
                "\t\t\t\t\t\"preserve_separators\": true\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t    }\n" +
                "\t}";
    }
}

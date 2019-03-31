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


    // ~ settings & mapping
    // ====================================================================================================================
    interface Index {
        String SETTINGS = "{\r\n" +
                "        \"index\" : {\r\n" +
                "            \"number_of_shards\" : 5,\r\n" +
                "            \"number_of_replicas\" : 1\r\n" +
                "        },\r\n" +
                "        \"analysis\": {\r\n" +
                "			\"analyzer\": {\r\n" +
                "		        \"autocomplete\": {\r\n" +
                "					\"tokenizer\": \"keyword\",\r\n" +
                "					\"filter\": [\r\n" +
                "			            \"pinyin\",\r\n" +
                "			            \"lowercase\",\r\n" +
                "			            \"cjk_width\"\r\n" +
                "					]\r\n" +
                "		        },\r\n" +
                "		        \"first_py_letter_analyzer\": {\r\n" +
                "                    \"tokenizer\": \"first_py_letter\",\r\n" +
                "					\"filter\":\"edgeNGram\"\r\n" +
                "                },\r\n" +
                "                \"full_pinyin_letter_analyzer\": {\r\n" +
                "                    \"tokenizer\": \"full_pinyin_letter\"\r\n" +
                "                },\r\n" +
                "                \"ik_smart_synonym\" : {\r\n" +
                "                	\"tokenizer\": \"ik_smart\",\r\n" +
                "                	\"filter\" : \"graph_synonyms\"\r\n" +
                "                },\r\n" +
                "                \"ik_maxword_synonym\" : {\r\n" +
                "                	\"tokenizer\": \"ik_max_word\",\r\n" +
                "                	\"filter\" : \"graph_synonyms\"\r\n" +
                "                }\r\n" +
                "			},\r\n" +
                "			\"tokenizer\" : {\r\n" +
                "                \"first_py_letter\": {\r\n" +
                "                    \"type\" : \"pinyin\",\r\n" +
                "                    \"keep_first_letter\" : true,\r\n" +
                "                    \"keep_full_pinyin\" : false,\r\n" +
                "                    \"keep_original\" : false,\r\n" +
                "                    \"limit_first_letter_length\" : 16,\r\n" +
                "                    \"lowercase\" : true,\r\n" +
                "                    \"trim_whitespace\" : true,\r\n" +
                "                    \"keep_none_chinese_in_first_letter\": false,\r\n" +
                "                    \"none_chinese_pinyin_tokenize\": false,\r\n" +
                "                    \"keep_none_chinese\": true,\r\n" +
                "                    \"keep_none_chinese_in_joined_full_pinyin\": true\r\n" +
                "                },\r\n" +
                "                \"full_pinyin_letter\": {\r\n" +
                "                    \"type\" : \"pinyin\",\r\n" +
                "                    \"keep_first_letter\" : false,\r\n" +
                "                    \"keep_full_pinyin\" : true,\r\n" +
                "                    \"keep_none_chinese\" : true,\r\n" +
                "                    \"keep_separate_first_letter\" : true,\r\n" +
                "                    \"keep_original\" : false,\r\n" +
                "                    \"limit_first_letter_length\" : 16,\r\n" +
                "                    \"lowercase\" : true,\r\n" +
                "                    \"trim_whitespace\" : true,\r\n" +
                "                    \"keep_none_chinese_in_first_letter\" : true\r\n" +
                "                }\r\n" +
                "            },\r\n" +
                "            \"filter\":{\r\n" +
                "				\"edgeNGram\":{\r\n" +
                "					\"type\": \"edgeNGram\",\r\n" +
                "					\"min_gram\": 2,\r\n" +
                "					\"max_gram\": 15,\r\n" +
                "					\"token_chars\": [\"letter\", \"digit\"]\r\n" +
                "				},\r\n" +
                "				\"graph_synonyms\": {\r\n" +
                "					\"type\": \"synonym_graph\",\r\n" +
                "            		\"synonyms_path\": \"synonym.txt\"\r\n" +
                "				}				\r\n" +
                "			}\r\n" +
                "		}\r\n" +
                "    }";

        String MAPPINGS = "{\r\n" +
                "	    \"_doc\" : {\r\n" +
                "			\"properties\" : {\r\n" +
                "				\"productNameZh\" : {\r\n" +
                "					\"type\" :   \"keyword\",\r\n" +
                "					\"index\": true,\r\n" +
                "					\"fields\": {\r\n" +
                "                        \"ik\": {\r\n" +
                "                            \"type\": \"text\",\r\n" +
                "                            \"analyzer\": \"ik_maxword_synonym\",\r\n" +
                "							\"search_analyzer\": \"ik_smart_synonym\"\r\n" +
                "                        },\r\n" +
                "                        \"pinyin\": {\r\n" +
                "                            \"type\": \"text\",\r\n" +
                "                            \"analyzer\": \"full_pinyin_letter_analyzer\"\r\n" +
                "                        },\r\n" +
                "                        \"first_py\": {\r\n" +
                "                            \"type\": \"text\",\r\n" +
                "                            \"analyzer\": \"first_py_letter_analyzer\"\r\n" +
                "                        }\r\n" +
                "                    }\r\n" +
                "			    },\r\n" +
                "			    \"productNameEn\" : {\r\n" +
                "					\"type\" :   \"text\",\r\n" +
                "					\"analyzer\": \"ik_max_word\",\r\n" +
                "					\"search_analyzer\": \"ik_max_word\"\r\n" +
                "			    },\r\n" +
                "			    \"productNameEnNotAnalyzed\" : {\r\n" +
                "					\"type\" :   \"keyword\",\r\n" +
                "					\"index\" : true\r\n" +
                "			    },\r\n" +
                "			    \"tagNamesZh\" : {\r\n" +
                "					\"type\" : \"keyword\",\r\n" +
                "					\"index\" : true\r\n" +
                "			    },\r\n" +
                "			    \"tagNamesPy\" : {\r\n" +
                "					\"type\" : \"keyword\",\r\n" +
                "					\"index\" : true\r\n" +
                "			    },\r\n" +
                "			    \"countryNameZh\" : {\r\n" +
                "					\"type\" :   \"keyword\",\r\n" +
                "					\"index\" : true\r\n" +
                "			    },\r\n" +
                "			    \"countryNamePy\" : {\r\n" +
                "					\"type\" :   \"keyword\",\r\n" +
                "					\"index\" : true\r\n" +
                "			    },\r\n" +
                "			    \"countryNameEn\" : {\r\n" +
                "					\"type\" :   \"keyword\",\r\n" +
                "					\"index\" : true\r\n" +
                "			    },\r\n" +
                "			    \"cityNameZh\" : {\r\n" +
                "					\"type\" :   \"keyword\",\r\n" +
                "					\"index\" : true\r\n" +
                "			    },\r\n" +
                "			    \"cityNamePy\" : {\r\n" +
                "					\"type\" :   \"keyword\",\r\n" +
                "					\"index\" : true\r\n" +
                "			    },\r\n" +
                "			    \"cityNameEn\" : {\r\n" +
                "					\"type\" :   \"keyword\",\r\n" +
                "					\"index\" : true\r\n" +
                "			    },\r\n" +
                "			    \"viewspotsZh\" : {\r\n" +
                "					\"type\" :   \"keyword\",\r\n" +
                "					\"index\" : true\r\n" +
                "			    },\r\n" +
                "			    \"viewspotsPy\" : {\r\n" +
                "					\"type\" :   \"keyword\",\r\n" +
                "					\"index\" : true\r\n" +
                "			    },\r\n" +
                "			    \"supplierName\" : {\r\n" +
                "					\"type\" :   \"keyword\",\r\n" +
                "					\"index\" : true\r\n" +
                "			    },\r\n" +
                "			    \"suggestText\": {\r\n" +
                "			    	\"type\": \"completion\",\r\n" +
                "                    \"analyzer\": \"autocomplete\",\r\n" +
                "					\"search_analyzer\": \"autocomplete\",\r\n" +
                "					\"preserve_separators\": true\r\n" +
                "				}\r\n" +
                "			}\r\n" +
                "	    }\r\n" +
                "	}";
    }
}

package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.convert.DataSizeUnit;

    @Data 
    @AllArgsConstructor
    public class Helbidea {
        public String href;

        public String html;

        public Map<String,String> toMap(){

            Map<String, String> hash=new HashMap<>();;
            hash.put("href", this.href);
            hash.put("html", this.href);

            return hash;
        }
    }



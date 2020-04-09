package com.example.demo.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String Hello() {
        String str1 = "{\"res\":[{\"dataArr\":[798,4201,10,19,25,21,7,11,5,1,2,32,13,9,16,9,9,22,4,94,34,125,158,48,14,127,111,194,397,250,1776,421],\"name\":\"ICI1.0+\"},{\"dataArr\":[135,525,15,1,13,4,1,1,-1,2,1,3,11,3,14,1,4,8,6,37,10,18,26,17,10,17,33,71,114,920,1106,92],\"name\":\"ICI2.0\"},{\"dataArr\":[479,973,21,20,44,33,13,24,11,5,6,50,34,23,23,26,12,43,81,64,162,96,183,101,86,223,147,159,302,2160,1283,484],\"name\":\"INFO3\"},{\"dataArr\":[433,494,0,0,1,0,1,0,3,0,0,1,0,0,1,0,0,0,0,0,0,4,0,1,1,2,2,7,26,-212,-10,76],\"name\":\"NGI2.6\"}]}";
        JSONObject jsonObject = JSONObject.parseObject(str1);
        List<Object> resList = jsonObject.getJSONArray("res");
//车机系统排序
        List<Object> datalistByInfotype = new ArrayList<>();
        List<String> infoTypeList = new ArrayList<>();
        infoTypeList.add("NGI");
        infoTypeList.add("INFO3");
        infoTypeList.add("ICI1.0");
        infoTypeList.add("NGI2.6");
        infoTypeList.add("ICI2.0");
        infoTypeList.add("NGI2.5");
        infoTypeList.add("ICI1.0+");
        List<String> aa = getInfotypeList(infoTypeList);
        HashMap hashMap = new HashMap();
        for (Object obj : resList) {
            JSONObject resJson = JSONObject.parseObject(obj.toString());
            hashMap.put(resJson.getString("name"), obj);
        }
        for (String str : aa) {
            Object object = hashMap.get(str);
            if (object != null) {
                datalistByInfotype.add(object);
            }
        }

        System.out.println(aa.toString());
        System.out.println(datalistByInfotype.toString());



        return "hello world!";
    }

    public List<String> getInfotypeList(List<String> list) {
        List<String> infoTypeList = new ArrayList<>();
        if (list != null) {
            List<String> ngiList = new ArrayList<>();
            List<String> iciList = new ArrayList<>();
            List<String> infoList = new ArrayList<>();
            for (String str : list) {
                if (str.contains("NGI")) {
                    ngiList.add(str);
                } else if (str.contains("ICI")) {
                    iciList.add(str);
                } else if (str.contains("INFO")) {
                    infoList.add(str);
                }
            }
            infoList.sort(Comparator.reverseOrder());
            iciList.sort(Comparator.reverseOrder());
            ngiList.sort(Comparator.reverseOrder());
            infoTypeList.addAll(infoList);
            infoTypeList.addAll(iciList);
            infoTypeList.addAll(ngiList);
        }
        return infoTypeList;
    }

}

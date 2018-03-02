package cn.company.project.control;

import cn.company.Application;

import cn.company.project.business.ApiBusiness;
import cn.company.project.model.Data;
import com.alibaba.fastjson.JSON;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.lang.String;


@RestController
public class ApiController {

    protected final Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApiBusiness apiBusiness;

    @RequestMapping("/api/demo")
    public Object get_pub_key() {
        HashMap<String,Object> result = new HashMap<>();
        result.put("flag","false");
        result.put("error","");
        result.put("result","");
        try{
            List<Data> pbkList = apiBusiness.getData();
            result.put("flag","true");
            result.put("result", pbkList);
        }catch(Exception e){
            e.printStackTrace();
            result.put("error",e.toString());
        }
        logger.info(JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }
}

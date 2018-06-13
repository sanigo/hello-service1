package com.jf.helloservice1;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.jws.WebMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloService {
    Map<String, String> helloVisitors = new ConcurrentHashMap<>();

    @RequestMapping(value = "/{name}",method = {RequestMethod.GET})
    public String hello(@PathVariable("name") String name) {
        return helloVisitors.get(name);
    }

    @RequestMapping(value="/{name}",method = {RequestMethod.DELETE})
    public String deleteHello(@PathVariable("name") String name) {
        String deleted = "";
        if (helloVisitors.get(name) != null) {
            helloVisitors.remove(name);
            deleted = name;
        }
        return String.format("{deleted: %s}",deleted);
    }

    @RequestMapping(value = "/{name}", method = {RequestMethod.POST})
    public String createVistor(@PathVariable("name") String name) {
        helloVisitors.put(name, String.format("{name: %s, time: %s}", name, new Timestamp(System.currentTimeMillis()).toString()));
        return helloVisitors.get(name);
    }
}

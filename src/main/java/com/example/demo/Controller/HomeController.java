package com.example.demo.Controller;


import com.example.demo.Cache;
import com.example.demo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    Cache myCache = new Cache();



    @GetMapping("/get-user-data")
    @ResponseBody
    public String getdata(@RequestParam ("id") String id) throws InterruptedException {
        System.out.println(id);


            if (myCache.has(id) == true) {
                return myCache.get(id);
            } else {
                User userobj = new User(id);
                String val = userobj.getDataSlow();
                myCache.set(id, val);

                return val;
            }

    }

    @GetMapping ("/delete")
    @ResponseBody

    public String deletedata(@RequestParam ("id") String id ){

        myCache.delete(id);

        return "Your data have been deleted";

    }

    }

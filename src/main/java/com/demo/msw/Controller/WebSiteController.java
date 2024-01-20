package com.demo.msw.Controller;

import com.demo.msw.Entity.WebSite;
import com.demo.msw.Service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webSite")
public class WebSiteController {

    @Autowired
    WebSiteService webSiteService;

    @PostMapping("/save")
    public List<WebSite> saveWebSite(@RequestBody WebSite webSite){
        WebSite saveData = webSiteService.saveWebSite(webSite);
        return  webSiteService.getAllWebSite();
    }

    @GetMapping("/getAllWebSite")
    public List<WebSite> getAllWebSite(){
        return webSiteService.getAllWebSite();
    }

    @GetMapping("/checkStatus")
    public List<WebSite> checkStatus(){
        return webSiteService.CheckWebSiteStatus();
    }

}

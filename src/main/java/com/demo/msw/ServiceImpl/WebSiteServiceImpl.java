package com.demo.msw.ServiceImpl;

import com.demo.msw.Entity.WebSite;
import com.demo.msw.Repository.WebSiteRepository;
import com.demo.msw.Service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebSiteServiceImpl implements WebSiteService {

    @Autowired
    WebSiteRepository webSiteRepository;


    /**
     * @param webSite
     */
    @Override
    public WebSite saveWebSite(WebSite webSite) {
        return webSiteRepository.save(webSite);
    }

    /**
     * @return
     */
    @Override
    public List<WebSite> getAllWebSite() {
//        List<WebSite> webSiteList;
//        List<WebSite> data = webSiteRepository.findAll();
//        webSiteList = data.stream().sorted(Comparator.comparing(WebSite::getWebSiteName)).collect(Collectors.toList());
        return webSiteRepository.findAll().stream().sorted( Comparator.comparing( WebSite::getWebSiteName)).collect(Collectors.toList());
    }
}

package com.demo.msw.ServiceImpl;

import com.demo.msw.Entity.WebSite;
import com.demo.msw.Repository.WebSiteRepository;
import com.demo.msw.Service.WebSiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebSiteServiceImpl implements WebSiteService {

    private final Logger LOGGER = LoggerFactory.getLogger(WebSiteServiceImpl.class);

    @Autowired
    WebSiteRepository webSiteRepository;

    @Autowired
    RestTemplate restTemplate;

    /**
     * @param webSite
     */
    @Override
    public WebSite saveWebSite(WebSite webSite) {
        return webSiteRepository.save(webSite);
    }

    /**
     * @return List<WebSite>
     */
    @Override
    public List<WebSite> getAllWebSite() {
        return webSiteRepository.findAll().stream().sorted( Comparator.comparing( WebSite::getWebSiteName)).collect(Collectors.toList());
    }

    /**
     *
     */
    @Override
    public List<WebSite> CheckWebSiteStatus() {
        List<WebSite> webSiteList = new ArrayList<>();
        webSiteList = webSiteRepository.findAll().stream().filter( web -> web.getWebSiteUrl() != null && web.getWebSiteUrl().length() != 0).collect(Collectors.toList());
        webSiteList.parallelStream().forEach( web -> {
            checkWeb(web);
        });
        return webSiteRepository.findAll();
    }

    private synchronized void checkWeb(WebSite web){
        try {
            ResponseEntity<String> response
                    = restTemplate.getForEntity(web.getWebSiteUrl(), String.class);
            LOGGER.info("Site: "+web.getWebSiteName());
            LOGGER.info("Status code: "+response.getStatusCode());
            if(response.getStatusCode().toString().equals("200 OK") && web.getIsActive().equals(Boolean.FALSE)){
                web.setIsActive(Boolean.TRUE);
                webSiteRepository.save(web);
            }
        } catch (Exception e){
            web.setIsActive(Boolean.FALSE);
            webSiteRepository.save(web);
            LOGGER.error(e.getMessage());
        }

    }

}

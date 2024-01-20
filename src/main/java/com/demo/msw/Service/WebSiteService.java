package com.demo.msw.Service;

import com.demo.msw.Entity.WebSite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WebSiteService {
    WebSite saveWebSite(WebSite webSite);

    List<WebSite> getAllWebSite();
}

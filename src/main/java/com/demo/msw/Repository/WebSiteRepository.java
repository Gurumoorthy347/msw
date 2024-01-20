package com.demo.msw.Repository;

import com.demo.msw.Entity.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSiteRepository extends JpaRepository<WebSite, Long> {

}

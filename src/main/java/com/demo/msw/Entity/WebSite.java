package com.demo.msw.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "web_site_details")
public class WebSite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="web_site_name", unique = true, nullable = false)
    private String webSiteName;

    @Column(name="web_site_url", unique = true, nullable = false)
    private String webSiteUrl;

    @Column(name="status", nullable = false)
    private Boolean isActive;
}

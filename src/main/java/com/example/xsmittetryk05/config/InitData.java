package com.example.xsmittetryk05.config;

import com.example.xsmittetryk05.model.County;
import com.example.xsmittetryk05.model.Region;
import com.example.xsmittetryk05.repository.CountyRepository;
import com.example.xsmittetryk05.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    CountyRepository countyRepository;

    @Autowired
    RegionRepository regionRepository;

    @Override
    public void run(String... args) throws Exception {

        Region region = new Region();
        region.setRegionCode("1085");
        region.setName("Region Sjælland");
        region.setHref("https://api.dataforsyningen.dk/regioner/1085");
        regionRepository.save(region);

        County county = new County();
        county.setName("Roskilde");
        county.setCountyCode("0265");
        county.setHref("http://localhost:8080/county/0265");
        county.setRegion(region);
        countyRepository.save(county);

        county.setName("Køgexx");
        county.setCountyCode("0259");
        county.setHref("http://localhost:8080/county/0259");
        countyRepository.save(county);

        region.setRegionCode("1084");
        region.setName("Region Hovedstaden");
        region.setHref("https://api.dataforsyningen.dk/regioner/1084");
        regionRepository.save(region);

        county.setName("København");
        county.setCountyCode("0101");
        county.setHref("http://localhost:8080/county/0101");
        countyRepository.save(county);

    }
}


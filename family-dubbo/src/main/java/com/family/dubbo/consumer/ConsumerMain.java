package com.family.dubbo.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.souche.car.model.api.model.SeriesService;
import com.souche.car.model.api.model.SimilarSearchService;
import com.souche.car.model.common.model.SeriesDTO;
import com.souche.vinquery.api.VinParseService;
import com.souche.vinquery.dto.AccessBasicInfo;
import com.souche.vinquery.dto.VinRequestDTO;
import com.souche.vinquery.dto.VinResponseResult;

@SpringBootApplication
public class ConsumerMain implements ApplicationRunner {

    @DubboReference(url = "dubbo://172.18.75.229:20880")
    private VinParseService vinParseService;

//    @DubboReference(url = "dubbo://172.18.75.229:20880")
//    private SeriesService seriesService;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        VinRequestDTO vinRequestDTO = new VinRequestDTO();
        vinRequestDTO.setVin("1234567890");
        AccessBasicInfo accessBasicInfo = new AccessBasicInfo();
        accessBasicInfo.setAppCode("composite_app_code");
        accessBasicInfo.setAuthCode("VrEveYMMUnw7ZEoSw7m1ZqCL");
        vinRequestDTO.setAccessBasicInfo(accessBasicInfo);
        VinResponseResult v  = vinParseService.analysisVinFacade(vinRequestDTO);
        /*SeriesDTO seriesDTO =  seriesService.getSeriesByCode("series-50052");*/
        System.out.println("ddd");
    }
}

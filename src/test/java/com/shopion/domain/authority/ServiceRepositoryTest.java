package com.shopion.domain.authority;

import com.shopion.domain.code.WordDict;
import com.shopion.domain.code.WordDictRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ServiceRepositoryTest {

    @Autowired
    ServiceRepository serviceRepository;

    @Test
    public void save() {
        String serviceCode = "SHP001";
        String serviceName = "SHOPION";

        serviceRepository.save(
                Service.builder()
                        .serviceCode(serviceCode)
                        .serviceName(serviceName)
                        .build()
        );

        List<Service> serviceList = serviceRepository.findAll();

        Service service = serviceList.get(0);
        assertThat(service.getServiceCode()).isEqualTo(serviceCode);
        assertThat(service.getServiceName()).isEqualTo(serviceName);
    }

}

package com.shopion.domain.authority;

import com.shopion.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Service extends BaseEntity {

    @Id
    private String serviceCode;

    private String serviceName;

    @Builder
    public Service(String serviceCode, String serviceName) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
    }

}

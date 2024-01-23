package com.shopion.domain.authority;

import com.shopion.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Role extends BaseEntity {

    @Id
    private String roleUid;

    private String roleName;

    private String serviceCode;

    @Builder
    public Role(String roleUid, String roleName, String serviceCode) {
        this.roleUid = roleUid;
        this.roleName = roleName;
        this.serviceCode = serviceCode;
    }


}

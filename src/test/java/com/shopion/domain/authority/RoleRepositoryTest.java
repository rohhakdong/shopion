package com.shopion.domain.authority;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void save() {
        String serviceCode = "SHP001";
        String roleName = "시스템관리자";
        String roleUid = "ac301af7-d6ff-46d4-a7d1-656a1edd7dee";

        roleRepository.save(
                Role.builder()
                        .serviceCode(serviceCode)
                        .roleName(roleName)
                        .roleUid(roleUid)
                        .build()
        );

        List<Role> roleList = roleRepository.findAll();

        Role service = roleList.get(0);
        assertThat(service.getServiceCode()).isEqualTo(serviceCode);
        assertThat(service.getRoleName()).isEqualTo(roleName);
        assertThat(service.getRoleUid()).isEqualTo(roleUid);
    }

}

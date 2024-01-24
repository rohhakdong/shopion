package com.shopion.domain.authority;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MenuRepositoryTest {

    @Autowired
    MenuRepository menuRepository;

    @Test
    public void save() {

        /*
         1013000000000 시스템   0
         1013001000000 코드관리 1
         1013001001000 제약조건 2
         1013002000000 권한관리 1
         1013002001000 서비스 2
         1013002002000 역할 2
         1013002003000 관리자 2
         1013002004000 메뉴 2
         1013002005000 기능 2
         1013003000000 모델관리 1
         1013003001000 단어사전 2
         1013003002000 모델 2
         */

        menuRepository.save(
                Menu.builder()
                        .menuCode("1013000000000")
                        .roleUid("ac301af7-d6ff-46d4-a7d1-656a1edd7dee")
                        .menuName("시스템")
                        .menuUri("")
                        .parentMenuCode("")
                        .menuLevel(0)
                        .menuSeq(999)
                        .childCount(11)
                        .build()
        );

        menuRepository.save(
                Menu.builder()
                        .menuCode("1013001000000")
                        .roleUid("ac301af7-d6ff-46d4-a7d1-656a1edd7dee")
                        .menuName("코드관리")
                        .menuUri("")
                        .parentMenuCode("1013000000000")
                        .menuLevel(1)
                        .menuSeq(999)
                        .childCount(1)
                        .build()
        );

        menuRepository.save(
                Menu.builder()
                        .menuCode("1013001001000")
                        .roleUid("ac301af7-d6ff-46d4-a7d1-656a1edd7dee")
                        .menuName("제약조건")
                        .menuUri("")
                        .parentMenuCode("1013001000000")
                        .menuLevel(2)
                        .menuSeq(999)
                        .childCount(0)
                        .build()
        );

        menuRepository.save(
                Menu.builder()
                        .menuCode("1013002000000")
                        .roleUid("ac301af7-d6ff-46d4-a7d1-656a1edd7dee")
                        .menuName("권한관리")
                        .menuUri("")
                        .parentMenuCode("1013000000000")
                        .menuLevel(1)
                        .menuSeq(999)
                        .childCount(5)
                        .build()
        );

        menuRepository.save(
                Menu.builder()
                        .menuCode("1013002001000")
                        .roleUid("ac301af7-d6ff-46d4-a7d1-656a1edd7dee")
                        .menuName("서비스")
                        .menuUri("")
                        .parentMenuCode("1013002000000")
                        .menuLevel(2)
                        .menuSeq(999)
                        .childCount(0)
                        .build()
        );

        menuRepository.save(
                Menu.builder()
                        .menuCode("1013002002000")
                        .roleUid("ac301af7-d6ff-46d4-a7d1-656a1edd7dee")
                        .menuName("역할")
                        .menuUri("")
                        .parentMenuCode("1013002000000")
                        .menuLevel(2)
                        .menuSeq(999)
                        .childCount(0)
                        .build()
        );

        menuRepository.save(
                Menu.builder()
                        .menuCode("1013002003000")
                        .roleUid("ac301af7-d6ff-46d4-a7d1-656a1edd7dee")
                        .menuName("관리자")
                        .menuUri("")
                        .parentMenuCode("1013002000000")
                        .menuLevel(2)
                        .menuSeq(999)
                        .childCount(0)
                        .build()
        );

        menuRepository.save(
                Menu.builder()
                        .menuCode("1013002004000")
                        .roleUid("ac301af7-d6ff-46d4-a7d1-656a1edd7dee")
                        .menuName("메뉴")
                        .menuUri("")
                        .parentMenuCode("1013002000000")
                        .menuLevel(2)
                        .menuSeq(999)
                        .childCount(0)
                        .build()
        );

        menuRepository.save(
                Menu.builder()
                        .menuCode("1013002005000")
                        .roleUid("ac301af7-d6ff-46d4-a7d1-656a1edd7dee")
                        .menuName("기능")
                        .menuUri("")
                        .parentMenuCode("1013002000000")
                        .menuLevel(2)
                        .menuSeq(999)
                        .childCount(0)
                        .build()
        );

        menuRepository.save(
                Menu.builder()
                        .menuCode("1013003000000")
                        .roleUid("ac301af7-d6ff-46d4-a7d1-656a1edd7dee")
                        .menuName("모델관리")
                        .menuUri("")
                        .parentMenuCode("1013000000000")
                        .menuLevel(1)
                        .menuSeq(999)
                        .childCount(2)
                        .build()
        );

        menuRepository.save(
                Menu.builder()
                        .menuCode("1013003001000")
                        .roleUid("ac301af7-d6ff-46d4-a7d1-656a1edd7dee")
                        .menuName("단어사전")
                        .menuUri("")
                        .parentMenuCode("1013003000000")
                        .menuLevel(2)
                        .menuSeq(999)
                        .childCount(0)
                        .build()
        );

        menuRepository.save(
                Menu.builder()
                        .menuCode("1013003002000")
                        .roleUid("ac301af7-d6ff-46d4-a7d1-656a1edd7dee")
                        .menuName("모델")
                        .menuUri("")
                        .parentMenuCode("1013003000000")
                        .menuLevel(2)
                        .menuSeq(999)
                        .childCount(0)
                        .build()
        );

        List<Menu> menuList = menuRepository.findAll();

        assertThat(menuList.size()).isEqualTo(12);
    }

}

package com.shopion.web.domain.member;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shopion.domain.member.Member;
import com.shopion.domain.member.MemberRole;
import com.shopion.domain.member.MemberRepository;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository repos;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertDummies() {

        IntStream.rangeClosed(0, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("user"+i+"@shopwizard.com")
                    .name("사용자"+i)
                    .password(passwordEncoder.encode("1111"))
                    .build();

            member.addMemberRole(MemberRole.USER);

            if (i > 80) member.addMemberRole(MemberRole.MANAGER);

            if (i > 90) member.addMemberRole(MemberRole.ADMIN);

            repos.save(member);
        });

    }

    @Test
    public void findMember() {

        Optional<Member> result = repos.findByEmail("user95@shopwizard.com");

        Member member = result.get();

        System.out.println(member);

    }
}

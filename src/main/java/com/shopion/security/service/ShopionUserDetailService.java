package com.shopion.security.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shopion.domain.member.Member;
import com.shopion.domain.member.MemberRepository;
import com.shopion.security.dto.AuthMemberDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ShopionUserDetailService implements UserDetailsService {

    private final MemberRepository repos;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("MemberUserDetailsService loddUserByUsername: " + username);

        Optional<Member> result = repos.findByEmail(username);

        if(!result.isPresent()) {
            throw new UsernameNotFoundException("Check Email");
        }

        Member member = result.get();

        log.info("-------------------------------");
        log.info(member);

        AuthMemberDto authMember = new AuthMemberDto(
                member.getEmail(),
                member.getPassword(),
                member.getRoleSet().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())).collect(Collectors.toSet())
        );

        authMember.setName(member.getName());

        return authMember;
    }
}

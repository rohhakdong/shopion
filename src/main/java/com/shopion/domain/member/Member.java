package com.shopion.domain.member;

import com.shopion.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginName;

    private String email;

    private String password;

    private String name;

    private String channelCode;

    private boolean mailReceiptYn;

    private boolean textReceiptYn;

    private LocalDateTime lastLoginDate;

    private LocalDateTime lastPasswordDate;

    private int loginErrorCount;

    private String oldPassword;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    public void addMemberRole(MemberRole role) {
        roleSet.add(role);
    }

}

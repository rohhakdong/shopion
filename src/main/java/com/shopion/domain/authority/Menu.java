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
public class Menu extends BaseEntity {

    @Id
    private String menuCode;

    private String roleUid;

    private String menuName;

    private String menuUri;

    private String parentMenuCode;

    private int menuLevel;

    private int menuSeq;

    private int childCount;

    @Builder
    public Menu(String menuCode, String roleUid, String menuName, String menuUri, String parentMenuCode, int menuLevel, int menuSeq, int childCount) {
        this.menuCode = menuCode;
        this.roleUid = roleUid;
        this.menuName = menuName;
        this.menuUri = menuUri;
        this.parentMenuCode = parentMenuCode;
        this.menuLevel = menuLevel;
        this.menuSeq = menuSeq;
        this.childCount = childCount;
    }

    public void update(String menuName, String menuUri, int menuSeq) {
        this.menuName = menuName;
        this.menuUri = menuUri;
        this.menuSeq = menuSeq;
    }
}

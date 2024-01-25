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
public class Function extends BaseEntity {

    @Id
    private String menuCode;

    private String roleUid;

    private String functionUri;

    @Builder
    public Function(String menuCode, String roleUid, String functionUri) {
        this.menuCode = menuCode;
        this.roleUid = roleUid;
        this.functionUri = functionUri;
    }

    public void update(String functionUri) {
        this.functionUri = functionUri;
    }
}

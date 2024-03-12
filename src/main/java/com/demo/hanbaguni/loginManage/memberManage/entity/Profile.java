package com.demo.hanbaguni.loginManage.memberManage.entity;

import com.demo.hanbaguni.dtoUtility.UpdatableDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.Update;

@Entity
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileKey;

    @Column(name = "profile_gender")
    private String profileGender;

    @Column(name = "profile_number")
    private String profileNumber;

    @Column(name = "profile_birth")
    private String profileBirth;

    @Column(name = "profile_isDormitory")
    private boolean profileIsDormitory;

    public void updateFromDto(UpdatableDto dto) {
        dto.update(this);
    }

}

package com.demo.hanbaguni.loginManage.memberManage.entity;

import com.demo.hanbaguni.dtoUtility.UpdatableDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UnivInfo {
    @Id
    private Long memberKey;

    @OneToOne
    @MapsId
    @JoinColumn(name = "memberKey")
    private Member member;

    @Column(name = "univ_email")
    private String univEmail;

    @Column(name = "univ_name")
    private String univName;

    @Column(name = "univ_studentId")
    private String univStudentId;



    public void updateFromDto(UpdatableDto dto) {
        dto.update(this);
    }
}

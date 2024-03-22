package com.demo.hanbaguni.loginManage.memberManage.entity;

import com.demo.hanbaguni.dtoUtility.UpdatableDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberKey;

    @Column(name = "member_id", nullable = false, unique = true)
    private String memberId;

    @Column(name = "member_password", length = 256, nullable = false)
    private String memberPassword;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @Column(name = "member_isEmail_verified")
    private boolean memberIsEmailVerified;

    @Column(name = "member_isProfile_insert")
    private boolean memberIsProfileInsert;

    @CreationTimestamp
    @Column(name = "member_createAt")
    private LocalDateTime memberCreateAt;

    @Enumerated(EnumType.STRING)
    private List<MemberRole> memberRole;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private UnivInfo univInfo;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Profile profile;
    /**
     * 향후 DTO를 해당 객체에 삽입할 때 사용.
     * @param dto
     */
    public void updateFromDto(UpdatableDto dto) {
        dto.update(this);
    }
}

package com.demo.hanbaguni.loginManage.securityManage;

import com.demo.hanbaguni.loginManage.memberManage.entity.Member;
import com.demo.hanbaguni.loginManage.memberManage.entity.MemberRole;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * costomizing of userDetail in spring security
 * to return memberRole list -> Collection
 */
@Getter
public class PrincipleDetails implements UserDetails {
    private Member member;

    public PrincipleDetails(Member member) {
        this.member = member;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<MemberRole> roles = member.getMemberRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(MemberRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return member.getMemberPassword();
    }

    @Override
    public String getUsername() {
        return member.getMemberId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

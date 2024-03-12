package com.demo.hanbaguni.loginManage.memberManage.repository;

import com.demo.hanbaguni.loginManage.memberManage.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberId(String memberId);
}

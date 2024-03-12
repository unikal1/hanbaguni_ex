package com.demo.hanbaguni.loginManage.memberManage.repository;

import com.demo.hanbaguni.loginManage.memberManage.entity.Member;
import com.demo.hanbaguni.loginManage.memberManage.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository  extends JpaRepository<Profile, Long> {
}

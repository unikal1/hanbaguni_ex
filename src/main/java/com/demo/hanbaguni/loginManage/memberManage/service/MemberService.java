package com.demo.hanbaguni.loginManage.memberManage.service;

import com.demo.hanbaguni.loginManage.memberManage.dataForm.MemberDto;
import com.demo.hanbaguni.loginManage.memberManage.entity.Member;

public interface MemberService {

    Member createNewMember(MemberDto memberDto);

    Member findMemberById(String memberId);

    Member changeEmailVerified(String memberId, boolean isVerified);
    Member changeProfileInsert(String membeerId, boolean isInsert);
}

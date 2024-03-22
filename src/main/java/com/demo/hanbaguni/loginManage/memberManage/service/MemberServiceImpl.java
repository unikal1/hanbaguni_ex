package com.demo.hanbaguni.loginManage.memberManage.service;

import com.demo.hanbaguni.loginManage.memberManage.dataForm.MemberDto;
import com.demo.hanbaguni.loginManage.memberManage.entity.Member;
import com.demo.hanbaguni.loginManage.memberManage.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.demo.hanbaguni.loginManage.memberManage.entity.MemberRole.USER;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    @Override
    public Member createNewMember(MemberDto memberDto) {
        Member newMember = new Member();

        newMember.updateFromDto(dtoPasswordEncoding(memberDto));
        newMember.setMemberIsEmailVerified(false);
        newMember.setMemberIsProfileInsert(false);
        newMember.setMemberRole(USER);

        memberRepository.save(newMember);
        return newMember;
    }

    @Override
    public Member findMemberById(String memberId) {
        Optional<Member> findMember = memberRepository.findByMemberId(memberId);
        if(findMember.isEmpty()) {
            throw new EntityNotFoundException("member not exist");
        }
        return findMember.get();
    }

    @Override
    @Transactional
    public Member changeEmailVerified(String memberId, boolean isVerified) {
        Optional<Member> findMember = memberRepository.findByMemberId(memberId);
        findMember.ifPresentOrElse(object -> {
                    object.setMemberIsEmailVerified(isVerified);
                }, () -> {
                    throw new EntityNotFoundException("member not exist");
                }
        );

        return findMember.get();
    }

    @Override
    @Transactional
    public Member changeProfileInsert(String memberId, boolean isInsert) {
        Optional<Member> findMember = memberRepository.findByMemberId(memberId);
        findMember.ifPresentOrElse(object -> {
                    object.setMemberIsProfileInsert(isInsert);
                }, () -> {
            throw new EntityNotFoundException("member not exist");
                }
        );

        return findMember.get();
    }

    private MemberDto dtoPasswordEncoding(MemberDto memberDto) {
        memberDto.setMemberDtoPassword(
                passwordEncoder.encode(memberDto.getMemberDtoPassword()));

        return memberDto;
    }
}

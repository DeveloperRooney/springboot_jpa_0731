package com.springbootjpa.board.servicetest;

import com.springbootjpa.board.entity.Member;
import com.springbootjpa.board.repository.MemberRepository;
import com.springbootjpa.board.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public class MemberServiceTest{

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    public void join() {

        Member member = new Member();

        member.setUserId("suhan0218");
        member.setUserName("김수한");
        member.setUserPass("suhan1994");
        member.setRegDate(LocalDateTime.now());
    }
}

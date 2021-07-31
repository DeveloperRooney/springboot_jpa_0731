package com.springbootjpa.board.service;

import com.springbootjpa.board.entity.Member;
import com.springbootjpa.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public void join(Member member) {

        memberRepository.save(member);
    }
}

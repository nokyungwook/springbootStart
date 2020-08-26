package com.example.springbootStart.repository;

import com.example.springbootStart.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member memeber);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}

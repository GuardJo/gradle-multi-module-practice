package io.github.guardjo.multimodule.common.service;

import io.github.guardjo.multimodule.common.domain.Member;
import io.github.guardjo.multimodule.common.exception.TestException;
import io.github.guardjo.multimodule.common.model.TestModel;
import io.github.guardjo.multimodule.common.repository.MemberRepository;
import io.github.guardjo.multimodule.common.type.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final MemberRepository memberRepository;

    public TestModel findTestModel() {
        return TestModel.builder()
                .name("tester")
                .build();
    }

    public void throwException() throws TestException {
        throw new TestException(ResponseCode.FAIL);
    }

    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }
}

package io.github.guardjo.multimodule.common.repository;

import io.github.guardjo.multimodule.common.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

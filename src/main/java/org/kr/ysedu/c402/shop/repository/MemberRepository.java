package org.kr.ysedu.c402.shop.repository;

import java.util.List;

import org.kr.ysedu.c402.shop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {

	@Query("SELECT m.userNo, m.userId, m.userPw, m.userName, cd.codeName, m.coin, m.regDate "
			+ "FROM Member m "
			+ "INNER JOIN CodeDetail cd ON cd.codeValue = m.job "
			+ "INNER JOIN CodeGroup cg ON cg.groupCode = cd.groupCode "
			+ "WHERE cg.groupCode = 'A01' ORDER BY m.regDate DESC")
	public List<Object[]> ListAllMember();
	
}

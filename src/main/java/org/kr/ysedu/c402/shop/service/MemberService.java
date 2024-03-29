package org.kr.ysedu.c402.shop.service;

import java.util.List;

import org.kr.ysedu.c402.shop.domain.Member;

public interface MemberService {

	public void register(Member member) throws Exception;
	
	public Member read(Long userNo) throws Exception;
	
	public void modify(Member member) throws Exception;
	
	public void remove(Long userNo) throws Exception;
	
	public List<Member> list() throws Exception;
	
	
}

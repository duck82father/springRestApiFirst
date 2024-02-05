package org.kr.ysedu.c402.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.kr.ysedu.c402.shop.domain.CodeGroup;
import org.kr.ysedu.c402.shop.dto.CodeLabelValue;
import org.kr.ysedu.c402.shop.repository.CodeGroupRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CodeServiceImpl implements CodeService {

	private final CodeGroupRepository repository;
	
	@Override
	public List<CodeLabelValue> getCodeGroupList() throws Exception {
		List<CodeGroup> codeGroups = repository.findAll(Sort.by(Direction.ASC, "groupCode"));
		
		List<CodeLabelValue> codeGroupList = new ArrayList<CodeLabelValue>();
		
		for(CodeGroup codeGroup : codeGroups) {
			codeGroupList.add(new CodeLabelValue(codeGroup.getGroupCode(), codeGroup.getGroupName()));
		}
				
		return codeGroupList;
	}

}

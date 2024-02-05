package org.kr.ysedu.c402.shop.service;

import java.util.List;

import org.kr.ysedu.c402.shop.dto.CodeLabelValue;

public interface CodeService {

	public List<CodeLabelValue> getCodeGroupList() throws Exception;
	
}

package org.kr.ysedu.c402.shop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"groupCode", "codeValue"})
public class CodeDetailId {

	private static final long serialVersionUID = 1L;
	
	private String groupCode;
	private String codeValue;
	
}

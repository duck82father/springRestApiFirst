package org.kr.ysedu.c402.shop.controller;

import java.util.List;

import org.kr.ysedu.c402.shop.domain.CodeDetail;
import org.kr.ysedu.c402.shop.service.CodeDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/codedetails")
public class CodeDetailController {
	
	private final CodeDetailService codeDetailService;
	
	@GetMapping("/{groupCode}/{codeValue}")
	public ResponseEntity<CodeDetail> read(@PathVariable("groupCode") String groupCode,
			@PathVariable("codeValue") String codeValue) throws Exception {
		CodeDetail codeDetail = new CodeDetail();
		codeDetail.setGroupCode(groupCode);
		codeDetail.setCodeValue(codeValue);
		
		return new ResponseEntity<>(codeDetailService.read(codeDetail), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CodeDetail>> list() throws Exception {
		log.info("register");

		return new ResponseEntity<>(codeDetailService.list(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CodeDetail> register(@Validated @RequestBody CodeDetail codeDetail) throws Exception{
		log.info("register");
		codeDetailService.register(codeDetail);
		
		log.info("register codeDetail.getCodeClassNo() = " + codeDetail.getGroupCode());
		log.info("register codeDetail.getCodeValue() = " + codeDetail.getCodeValue());
		
		return new ResponseEntity<>(codeDetail, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{groupCode}/{codeValue}")
	public ResponseEntity<Void> delete(@PathVariable("groupCode") String groupCode,
			@PathVariable("codeValue") String codeValue) throws Exception {
		CodeDetail codeDetail = new CodeDetail();
		codeDetail.setGroupCode(groupCode);
		codeDetail.setCodeValue(codeValue);
		
		codeDetailService.remove(codeDetail);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{groupCode}/{codeValue}")
	public ResponseEntity<CodeDetail> modify(@PathVariable("groupCode") String groupCode,
			@PathVariable("codeValue") String codeValue,
			@Validated @RequestBody CodeDetail codeDetail) throws Exception {
		codeDetail.setGroupCode(groupCode);
		codeDetail.setCodeValue(codeValue);
		
		codeDetailService.modify(codeDetail);
		
		return new ResponseEntity<>(codeDetail, HttpStatus.OK);
	}
	
	
	
}

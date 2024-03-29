package org.kr.ysedu.c402.shop.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(value = "hibernateLazyInitializer")
@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(of = {"groupCode", "codeValue"})
@IdClass(CodeDetailId.class)
@Table(name = "code_detail")
public class CodeDetail {
	
	@Id
	@Column(length = 3)
	private String groupCode;
	
	@Id
	@Column(length = 3)
	private String codeValue;
	
	@Column(length = 30, nullable = false)
	private String codeName;
	
	private int sortSeq;
	
	@Column(length = 1)
	private String useYn = "Y";
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@CreationTimestamp
	private LocalDateTime regDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@UpdateTimestamp
	private LocalDateTime updDate;
	
}

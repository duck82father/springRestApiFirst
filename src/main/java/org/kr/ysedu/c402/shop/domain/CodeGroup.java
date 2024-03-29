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
import jakarta.persistence.JoinColumn;
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
@EqualsAndHashCode(of = "groupCode")
@Table(name = "code_group")
public class CodeGroup {
	
	@Id
	@Column(length = 3)
	private String groupCode;
	
	@Column(length = 30, nullable = false)
	private String groupName;
	
	@Column(length = 1)
	private String useYn = "Y";
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="groupCode")
	private List<CodeDetail> codeDetails;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@CreationTimestamp
	private LocalDateTime regDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@UpdateTimestamp
	private LocalDateTime updDate;
		
}

package fon.is.fpis.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "internal_check_plans")
public class InternalCheckPlan implements BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6438979154739058225L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_internal_check_plans")
	@Column(name = "plan_id")
	private Long id;
	@Column(name= "plan_date")
	private LocalDate date;
	@Column(name= "check_subject")
	private String checkSubject;
	@Column(name = "plan_description")
	private String description;
	@OneToOne
	@JoinColumn
	private Worker sender;
	@OneToOne
	@JoinColumn
	private Worker receiver;
}

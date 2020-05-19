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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "internal_check_plans")
public class InternalCheckPlan implements BaseEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_internal_check_plans")
	@Column(name = "id")
	private Long id;
	@Column(name= "date")
	private LocalDate date;
	@Column(name= "check_subject")
	private String checkSubject;
	@Column(name = "description")
	private String description;
	@OneToOne
	@JoinColumn(name = "sender_id")
	private Worker sender;
	@OneToOne
	@JoinColumn(name = "receiver_id")
	private Worker receiver;
}

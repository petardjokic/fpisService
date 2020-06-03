package fon.is.fpis.domain;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fon.is.fpis.domain.converter.WorkerPositionConverter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "workers")
public class Worker implements BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4620103664979820327L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_workers")
	@Column(name = "worker_id")
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "position")
	@Convert(converter = WorkerPositionConverter.class)
	private WorkerPosition position;
	
}

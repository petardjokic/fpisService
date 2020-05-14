package fon.is.fpis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class Worker implements BaseEntity{

	private Long id;
	private String firstName;
	private String lastName;
	private WorkerPosition position;
	
}

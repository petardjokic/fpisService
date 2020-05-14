package fon.is.fpis.domain;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class StorageFinalProductWarrant implements BaseEntity {
	
	private Long id;
	private LocalDate date;
	
}

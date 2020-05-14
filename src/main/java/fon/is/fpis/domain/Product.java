package fon.is.fpis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class Product implements BaseEntity {
	
	private Long id;
	private String name;
}

package fon.is.fpis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class InternalCheckReportItem implements BaseEntity {
	
	private Long id;
	private String note;
	private Product product;
}

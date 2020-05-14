package fon.is.fpis.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class InternalCheckReport implements BaseEntity {
	
	private Long id;
	private Long planId;
	private LocalDate date;
	private Worker sender;
	private Worker receiver;
	private List<InternalCheckReportItem> reportItems;
	
}

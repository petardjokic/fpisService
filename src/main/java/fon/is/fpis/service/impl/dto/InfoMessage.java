package fon.is.fpis.service.impl.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class InfoMessage {

	private Boolean show;
	private String value;
	private String type;
}

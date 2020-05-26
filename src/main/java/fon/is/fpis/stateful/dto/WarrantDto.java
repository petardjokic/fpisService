package fon.is.fpis.stateful.dto;

import fon.is.fpis.domain.StorageFinalProductWarrant;
import fon.is.fpis.domain.StorageWarantItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class WarrantDto {
	private StorageFinalProductWarrant warrant;
	private StorageWarantItem item;
}

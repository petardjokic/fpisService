package fon.is.fpis.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "storage_final_product_warrant")
public class StorageFinalProductWarrant implements BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8028322804733923812L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_warrant")
	@Column(name = "warrant_id")
	private Long id;
	@Column(name = "warrant_date")
	private LocalDate date;
	@ElementCollection
	@CollectionTable(name = "storage_final_product_warrant_items", joinColumns = @JoinColumn(referencedColumnName = "warrant_id", name = "warrant_id"))
	private List<StorageWarantItem> items = new ArrayList<>();
	
}

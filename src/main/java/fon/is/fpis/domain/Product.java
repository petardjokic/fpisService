package fon.is.fpis.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "products")
public class Product implements BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5638159329978070252L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_products")
	@Column(name = "product_id")
	private Long id;
	@Column(name = "product_name")
	private String name;
}

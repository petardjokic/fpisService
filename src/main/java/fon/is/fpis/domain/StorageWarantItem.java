package fon.is.fpis.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Embeddable
public class StorageWarantItem {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "order_number")
	private Integer orderNumber;
	@Column(name = "note")
	private String note;
	@Column(name = "amount")
	private Integer amount;
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
}

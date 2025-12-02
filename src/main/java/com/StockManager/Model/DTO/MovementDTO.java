package com.StockManager.Model.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.StockManager.Model.HandlingType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class MovementDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long productId;
	private HandlingType type;
	private int amount;
	private Date moveDate;

		public MovementDTO(Long id, Long productId, HandlingType type, int amount) {
		this.id = id;
		this.productId = productId;
		this.type = type;
		this.amount = amount;

	}

}

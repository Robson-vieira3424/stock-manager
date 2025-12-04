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

	private Long productId;
	private HandlingType type;
	private int amount;
	private Date moveDate;
    private String categoria;

    @Override
    public String toString() {
        return "MovementDTO{" +
                "productId=" + productId +
                ", type=" + type +
                ", amount=" + amount +
                ", moveDate=" + moveDate +
                '}';
    }
}

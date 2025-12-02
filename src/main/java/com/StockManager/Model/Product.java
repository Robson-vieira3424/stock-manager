package com.StockManager.Model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, name = "name")
	private String name;

	@Column(nullable = false, name = "amount")
	private int amount;

    @Enumerated(EnumType.STRING)
    private StatusProduct status;

    @Column
    private long min;
}

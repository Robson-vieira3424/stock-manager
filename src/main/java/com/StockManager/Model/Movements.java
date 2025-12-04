package com.StockManager.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movements")

public class Movements implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private HandlingType type;

    @Column()
    private String categoria;

    private String observation;

	@Column(name = "amount", nullable = false)
	private int amount;
	

	@Column(name = "moveDate")
	private Date moveDate;

    private String destination;



    public Movements(Long productId, Long id, HandlingType type, String categoria, String observation, int amount, Date moveDate, String destination) {
        this.productId = productId;
        this.id = id;
        this.type = type;
        this.categoria = categoria;
        this.observation = observation;
        this.amount = amount;
        this.moveDate = moveDate;
        this.destination=destination;
    }
    public Movements(){}

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public HandlingType getType() {
        return type;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getObservacoes() {
        return observation;
    }

    public int getAmount() {
        return amount;
    }

    public Date getMoveDate() {
        return moveDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setType(HandlingType type) {
        this.type = type;
    }

    public void setObservacoes(String observacoes) {
        this.observation = observacoes;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setMoveDate(Date moveDate) {
        this.moveDate = moveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movements movements = (Movements) o;
        return amount == movements.amount && Objects.equals(id, movements.id) && Objects.equals(productId, movements.productId) && type == movements.type && Objects.equals(categoria, movements.categoria) && Objects.equals(observation, movements.observation) && Objects.equals(moveDate, movements.moveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, type, categoria, observation, amount, moveDate);
    }

    @Override
    public String toString() {
        return "Movements{" +
                "id=" + id +
                ", productId=" + productId +
                ", type=" + type +
                ", categoria='" + categoria + '\'' +
                ", observation='" + observation + '\'' +
                ", amount=" + amount +
                ", moveDate=" + moveDate +
                ", destination='" + destination + '\'' +
                '}';
    }
}

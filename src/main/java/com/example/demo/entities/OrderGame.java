package com.example.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.entities.pk.OrderGamePK;

@Entity
@Table(name = "tb_order_game")
public class OrderGame implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderGamePK id;
	private Integer quantity;
	private Double price;
	
	public OrderGame() {
	}

	public OrderGame(Order order, Game game, Integer quantity, Double price) {
		id.setOrder(order);
		id.setGame(game);
		this.quantity = quantity;
		this.price = price;
	}

	public Game getGame() {
		return id.getGame();
	}
	
	public void setOrder(Game game) {
		id.setGame(game);
	}
	
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderGame other = (OrderGame) obj;
		return Objects.equals(id, other.id);
	}
	
	
}

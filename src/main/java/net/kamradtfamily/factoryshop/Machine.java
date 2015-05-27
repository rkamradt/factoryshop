/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.kamradtfamily.factoryshop;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author kamradt
 */
public class Machine implements Comparable {
	private final String name;
	private final String location;
	private final BigDecimal cost;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @return the cost
	 */
	public BigDecimal getCost() {
		return cost;
	}

	public static class Builder {
		// required
		private final String name;
		//optional
		private String location;
		private BigDecimal cost;
		public Builder(String name) {
			if(name == null) {
				throw new IllegalArgumentException();
			}
			this.name = name;
		}
		public Builder location(String location) {
			this.location = location;
			return this;
		}
		public Builder cost(BigDecimal cost) {
			this.cost = cost;
			return this;
		}
		public Machine build() {
			return new Machine(this);
		}
	}
	private Machine(Builder builder) {
		this.cost = builder.cost;
		this.location = builder.location;
		this.name = builder.name;
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Machine) {
			return this.name.compareTo(((Machine)o).name);
		}
		return -1;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Machine) {
			return this.name.equals(((Machine)o).name);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 29 * hash + Objects.hashCode(this.name);
		return hash;
	}
	
}

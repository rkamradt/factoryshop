/*
 * Copyright 2015 randalkamradt.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kamradtfamily.factoryshop;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author kamradt
 */
public class Role implements Comparable {
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
		public Role build() {
			return new Role(this);
		}
	}
	private Role(Builder builder) {
		this.cost = builder.cost;
		this.location = builder.location;
		this.name = builder.name;
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Role) {
			return this.name.compareTo(((Role)o).name);
		}
		return -1;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Role) {
			return this.name.equals(((Role)o).name);
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

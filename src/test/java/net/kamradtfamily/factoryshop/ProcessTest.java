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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kamradt
 */
public class ProcessTest {
	Process instance;
	String testprocessname = "testprocessname";
	String testprocesslocation = "testprocesslocation";
	BigDecimal testprocesscost = BigDecimal.TEN;
	public ProcessTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		instance = new Process.Builder(testprocessname).cost(testprocesscost).location(testprocesslocation).build();
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of getName method, of class Process.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		String result = instance.getName();
		assertEquals(testprocessname, result);
	}

	/**
	 * Test of getLocation method, of class Process.
	 */
	@Test
	public void testGetLocation() {
		System.out.println("getLocation");
		String result = instance.getLocation();
		assertEquals(testprocesslocation, result);
	}

	/**
	 * Test of getCost method, of class Process.
	 */
	@Test
	public void testGetCost() {
		System.out.println("getCost");
		BigDecimal result = instance.getCost();
		assertEquals(testprocesscost, result);
	}

	/**
	 * Test of compareTo method, of class Process.
	 */
	@Test
	public void testCompareTo() {
		System.out.println("compareTo");
		Process instance1 = new Process.Builder("anotherprocessname").build();
		int result = instance.compareTo(instance1);
		assertTrue(result > 0);
		result = instance1.compareTo(instance);
		assertTrue(result < 0);
		result = instance.compareTo(instance);
		assertTrue(result == 0);
		result = instance.compareTo(this);
		assertTrue(result < 0);
	}

	/**
	 * Test of equals method, of class Process.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");
		Process instance1 = new Process.Builder("anotherprocessname").build();
		boolean result = instance.equals(instance1);
		assertFalse(result);
		result = instance.equals(instance);
		assertTrue(result);
		result = instance.equals(this);
		assertFalse(result);
	}

}

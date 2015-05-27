/*
 * Copyright 2014 randalkamradt.
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

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author randalkamradt
 */
public class FactoryShopTest {
    public final static String NAME = "shop1";
    FactoryShop instance;
    
    public FactoryShopTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new FactoryShopImpl(NAME);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class FactoryShop.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = NAME;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of addRole method, of class FactoryShop.
     */
    @Test
    public void testAddRole() {
        System.out.println("addRole");
        final Role role = new Role.Builder("role1").build();
        instance.addRole(role);
        Role [] roles = instance.getRoles();
        assertTrue(Arrays.stream(roles).anyMatch((t) -> t.equals(role)));
    }

    /**
     * Test of deleteRole method, of class FactoryShop.
     */
    @Test
    public void testDeleteRole() {
        final Role role = new Role.Builder("role1").build();
        instance.addRole(role);
        instance.addRole(new Role.Builder("role2").build());
        instance.addRole(new Role.Builder("role3").build());
        Role [] roles = instance.getRoles();
        assertTrue(Arrays.stream(roles).anyMatch((t) -> t.equals(role)));
        instance.deleteRole(role);
        roles = instance.getRoles();
        assertTrue(!Arrays.stream(roles).anyMatch((t) -> t.equals(role)));
    }

    /**
     * Test of getRoles method, of class FactoryShop.
     */
    @Test
    public void testGetRoles() {
        System.out.println("getRoles");
        instance.addRole(new Role.Builder("role1").build());
        instance.addRole(new Role.Builder("role2").build());
        instance.addRole(new Role.Builder("role3").build());
        instance.addRole(new Role.Builder("role4").build());
        instance.addRole(new Role.Builder("role5").build());
        Role[] result = instance.getRoles();
        assertEquals(5, result.length);
        instance.addRole(new Role.Builder("role1").build()); // cant add role twice (more than one person can be needed with that role)
        result = instance.getRoles();
        assertEquals(5, result.length);
        instance.deleteRole(result[0]);
        result = instance.getRoles();
        assertEquals(4, result.length);
    }

    /**
     * Test of addMachine method, of class FactoryShop.
     */
    @Test
    public void testAddMachine() {
        System.out.println("addMachine");
		Machine machine = new Machine.Builder("machine1").build();
        instance.addMachine(machine);
        Machine [] machines = instance.getMachines();
        assertTrue(Arrays.stream(machines).anyMatch((t) -> t.equals(machine)));
    }

    /**
     * Test of deleteMachine method, of class FactoryShop.
     */
    @Test
    public void testDeleteMachine() {
        System.out.println("deleteMachine");
        String machine1name = "machine1";
        String machine2name = "machine2";
        String machine3name = "machine3";
		Machine machine = new Machine.Builder(machine1name).build();
        instance.addMachine(machine);
        instance.addMachine(new Machine.Builder(machine2name).build());
        instance.addMachine(new Machine.Builder(machine3name).build());
        Machine [] machines = instance.getMachines();
        assertTrue(Arrays.stream(machines).anyMatch((t) -> t.getName().equals(machine1name)));
        instance.deleteMachine(machine);
        machines = instance.getMachines();
        assertTrue(!Arrays.stream(machines).anyMatch((t) -> t.getName().equals(machine)));
    }

    /**
     * Test of getMachines method, of class FactoryShop.
     */
    @Test
    public void testGetMachines() {
        System.out.println("getMachines");
        instance.addMachine(new Machine.Builder("machine1").build());
        instance.addMachine(new Machine.Builder("machine2").build());
        instance.addMachine(new Machine.Builder("machine3").build());
        instance.addMachine(new Machine.Builder("machine4").build());
        instance.addMachine(new Machine.Builder("machine5").build());
        Machine[] result = instance.getMachines();
        assertEquals(5, result.length);
        instance.addMachine(new Machine.Builder("machine5").build()); // cant add machine twice (more than one instance of that machine can be needed)
        result = instance.getMachines();
        assertEquals(5, result.length);
        instance.deleteMachine(result[0]);
        result = instance.getMachines();
        assertEquals(4, result.length);
    }

    /**
     * Test of addProcess method, of class FactoryShop.
     */
    @Test
    public void testAddProcess() {
        System.out.println("addProcess");
        Process process = new Process.Builder("process1").build();
        instance.addProcess(process);
        Process [] processs = instance.getProcesses();
        assertTrue(Arrays.stream(processs).anyMatch((t) -> t.equals(process)));
    }

    /**
     * Test of deleteProcess method, of class FactoryShop.
     */
    @Test
    public void testDeleteProcess() {
        System.out.println("deleteProcess");
        Process process = new Process.Builder("process1").build();
        instance.addProcess(process);
        instance.addProcess(new Process.Builder("process2").build());
        instance.addProcess(new Process.Builder("process3").build());
        Process [] processes = instance.getProcesses();
        assertTrue(Arrays.stream(processes).anyMatch((t) -> t.equals(process)));
        instance.deleteProcess(process);
        processes = instance.getProcesses();
        assertTrue(!Arrays.stream(processes).anyMatch((t) -> t.equals(process)));
    }

    /**
     * Test of getProcesses method, of class FactoryShop.
     */
    @Test
    public void testGetProcesses() {
        System.out.println("getProcesses");
        instance.addProcess(new Process.Builder("process1").build());
        instance.addProcess(new Process.Builder("process2").build());
        instance.addProcess(new Process.Builder("process3").build());
        instance.addProcess(new Process.Builder("process4").build());
        instance.addProcess(new Process.Builder("process5").build());
        Process[] result = instance.getProcesses();
        assertEquals(5, result.length);
        instance.addProcess(new Process.Builder("process1").build()); // cant add process twice
        result = instance.getProcesses();
        assertEquals(5, result.length);
        instance.deleteProcess(result[0]);
        result = instance.getProcesses();
        assertEquals(4, result.length);
    }

    /**
     * Test of runProcessOnItem method, of class FactoryShop.
     */
    @Test
    public void testRunProcessOnItem() {
        System.out.println("runProcessOnItem");
        Process process = new Process.Builder("process1").build();
        instance.addProcess(process);
        Item item = new Item.Builder("item1").build();
        instance.runProcessOnItem(process, item); // cant test until process and item are better defined
        try {
            process = new Process.Builder("unknown process").build(); // can test that the process exists to actually run
            instance.runProcessOnItem(process, item);
            fail("expected exception not thrown");
        } catch(IllegalStateException ex) {
            assertEquals("no processes named unknown process exist at this shop", ex.getMessage());
        }
    }
    
}

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
import java.util.function.Predicate;
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
        final String role = "role1";
        instance.addRole(role);
        String [] roles = instance.getRoles();
        assertTrue(Arrays.stream(roles).anyMatch((String t) -> t.equals(role)));
    }

    /**
     * Test of deleteRole method, of class FactoryShop.
     */
    @Test
    public void testDeleteRole() {
        final String role = "role1";
        instance.addRole(role);
        instance.addRole("role2");
        instance.addRole("role3");
        String [] roles = instance.getRoles();
        assertTrue(Arrays.stream(roles).anyMatch((String t) -> t.equals(role)));
        instance.deleteRole(role);
        roles = instance.getRoles();
        assertTrue(!Arrays.stream(roles).anyMatch((String t) -> t.equals(role)));
    }

    /**
     * Test of getRoles method, of class FactoryShop.
     */
    @Test
    public void testGetRoles() {
        System.out.println("getRoles");
        instance.addRole("role1");
        instance.addRole("role2");
        instance.addRole("role3");
        instance.addRole("role4");
        instance.addRole("role5");
        String[] result = instance.getRoles();
        assertEquals(5, result.length);
        instance.addRole("role5"); // cant add role twice (more than one person can be needed with that role)
        result = instance.getRoles();
        assertEquals(5, result.length);
        instance.deleteRole("role5");
        result = instance.getRoles();
        assertEquals(4, result.length);
    }

    /**
     * Test of addMachine method, of class FactoryShop.
     */
    @Test
    public void testAddMachine() {
        System.out.println("addMachine");
        String machine = "machine1";
        instance.addMachine(machine);
        String [] machines = instance.getMachines();
        assertTrue(Arrays.stream(machines).anyMatch((String t) -> t.equals(machine)));
    }

    /**
     * Test of deleteMachine method, of class FactoryShop.
     */
    @Test
    public void testDeleteMachine() {
        System.out.println("deleteMachine");
        String machine = "machine1";
        instance.addMachine(machine);
        instance.addMachine("machine2");
        instance.addMachine("machine3");
        String [] machines = instance.getMachines();
        assertTrue(Arrays.stream(machines).anyMatch((String t) -> t.equals(machine)));
        instance.deleteMachine(machine);
        machines = instance.getMachines();
        assertTrue(!Arrays.stream(machines).anyMatch((String t) -> t.equals(machine)));
    }

    /**
     * Test of getMachines method, of class FactoryShop.
     */
    @Test
    public void testGetMachines() {
        System.out.println("getMachines");
        instance.addMachine("machine1");
        instance.addMachine("machine2");
        instance.addMachine("machine3");
        instance.addMachine("machine4");
        instance.addMachine("machine5");
        String[] result = instance.getMachines();
        assertEquals(5, result.length);
        instance.addMachine("machine5"); // cant add machine twice (more than one instance of that machine can be needed)
        result = instance.getMachines();
        assertEquals(5, result.length);
        instance.deleteMachine("machine5");
        result = instance.getMachines();
        assertEquals(4, result.length);
    }

    /**
     * Test of addProcess method, of class FactoryShop.
     */
    @Test
    public void testAddProcess() {
        System.out.println("addProcess");
        String process = "process1";
        instance.addProcess(process);
        String [] processs = instance.getProcesses();
        assertTrue(Arrays.stream(processs).anyMatch((String t) -> t.equals(process)));
    }

    /**
     * Test of deleteProcess method, of class FactoryShop.
     */
    @Test
    public void testDeleteProcess() {
        System.out.println("deleteProcess");
        String process = "process1";
        instance.addProcess(process);
        instance.addProcess("process2");
        instance.addProcess("process3");
        String [] processes = instance.getProcesses();
        assertTrue(Arrays.stream(processes).anyMatch((String t) -> t.equals(process)));
        instance.deleteProcess(process);
        processes = instance.getProcesses();
        assertTrue(!Arrays.stream(processes).anyMatch((String t) -> t.equals(process)));
    }

    /**
     * Test of getProcesses method, of class FactoryShop.
     */
    @Test
    public void testGetProcesses() {
        System.out.println("getProcesses");
        instance.addProcess("process1");
        instance.addProcess("process2");
        instance.addProcess("process3");
        instance.addProcess("process4");
        instance.addProcess("process5");
        String[] result = instance.getProcesses();
        assertEquals(5, result.length);
        instance.addProcess("process5"); // cant add process twice
        result = instance.getProcesses();
        assertEquals(5, result.length);
        instance.deleteProcess("process5");
        result = instance.getProcesses();
        assertEquals(4, result.length);
    }

    /**
     * Test of runProcessOnItem method, of class FactoryShop.
     */
    @Test
    public void testRunProcessOnItem() {
        System.out.println("runProcessOnItem");
        instance.addProcess("process");
        String process = "process";
        String item = "id";
        instance.runProcessOnItem(process, item); // cant test until process and item are better defined
        try {
            process = "unknown process"; // can test that the process exists to actually run
            instance.runProcessOnItem(process, item);
            fail("expected exception not thrown");
        } catch(IllegalStateException ex) {
            assertEquals("no processes name unknown process exist at this shop", ex.getMessage());
        }
    }
    
}

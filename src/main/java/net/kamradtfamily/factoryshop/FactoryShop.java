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

/**
 * A Factory Shop specification.  The factory shop allows processes to be run
 * on items.  It requires a certain number of people of particular roles, and
 * has a set of machines to facilitate the processing of items.
 * 
 * Roles, Machines, and Processes, and Items will all be defined later, but for
 * now they are just referred to by name (String)  Notice that Roles and Machine
 * are descriptions of people and objects, and not the people or objects themselves
 * 
 * // todo add assignments that match people with roles and objects with machines.
 * // todo a process may have a listing of roles and machines necessary which
 * may negate the need for adding/deleting of roles/machines.
 * 
 * @author randalkamradt
 */
public interface FactoryShop {

    /**
     * The FactoryShop has a name that is fixed.
     * 
     * @return the name of the shop.  Must be unique within a factory.
     */
    String getName();

    /**
     *
     * A shop can have one or more roles, this allows adding roles that facilitate
     * processes
     * 
     * note: a shop can have zero roles temporarily while transitioning processes
     * 
     * // todo adding process may add needed roles, making this method obsolete
     * // todo add assignments that allocate a person of the role to the shop
     * 
     * @param role the name of the role to add
     */
    void addRole(String role);

    /**
     *
     * Roles can be removed if they are no longer needed for the processes.
     * 
     * // todo removing process may remove uneccessary roles, making this method obsolete
     * // todo add assignments that remove a person of the role to the shop
     * 
     * @param role the name of the role to delete
     */
    void deleteRole(String role);

    /**
     *
     * Get the list of roles needed by this shop to perform it's processes
     * 
     * // todo return a list of assignments that are performing these roles
     * 
     * @return the list of roles that are currently added to this shop
     */
    String [] getRoles();

    /**
     *
     * A shop can have zero or more machines.  Add a machine to this shop
     * 
     * // todo add process may add machines, (assuming they are portable) making this method obsolete
     * // todo add assignments that allocates a unique portable machine to the shop
     * 
     * @param machine the name of the machine to add
     */
    void addMachine(String machine);

    /**
     *
     * A shop can have zero or more machines.  Remove a (portable) machine from this shop
     * 
     * // todo add process may add machines, (assuming they are portable) making this method obsolete
     * // todo add assignments that allocates a unique portable machine to the shop
     * 
     * @param machine
     */
    void deleteMachine(String machine);

    /**
     *
     * Return a list of machines needed by this shop to perform it's processes
     * 
     * // todo return a list of unique portable machines this shop has
     * 
     * @return the names of the machines needed by this shop
     */
    String [] getMachines();

    /**
     *
     * A shop can perform one or more processes. Add a process that this shop is capable of.
     * 
     * Note: a shop can temporarily have no process during periods of transition.
     * 
     * @param process the name of the process to add
     */
    void addProcess(String process);

    /**
     *
     * A shop can perform one or more processes. Remove one of these processes
     * 
     * @param process the name of the process to remove
     */
    void deleteProcess(String process);

    /**
     *
     * Return a list of process names that this shop is capable 
     * 
     * Note: a shop can temporarily have no process during periods of transition.
     * 
     * @return
     */
    String [] getProcesses();

    /**
     *
     * This will run the process on a unique item.  Note that the process is the
     * name of a process, but the item is the id of a unique object, and the 
     * process may change the attributes of the item.
     * 
     * @param process the name of a process
     * @param item the id of a unique object.
     */
    void runProcessOnItem(String process, String item);
    
}

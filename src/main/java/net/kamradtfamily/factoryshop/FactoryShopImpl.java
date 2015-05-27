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

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author randalkamradt
 */
public class FactoryShopImpl implements FactoryShop {
    private final String name;
    private final Set<Role> roles = new TreeSet<>();
    private final Set<Machine> machines = new TreeSet<>();
    private final Set<Process> processes = new TreeSet<>();
    public FactoryShopImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addRole(Role role) {
        roles.add(role);
    }

    @Override
    public void deleteRole(Role role) {
        roles.remove(role);
    }

    @Override
    public Role[] getRoles() {
        return roles.toArray(new Role[roles.size()]);
    }

    @Override
    public void addMachine(Machine machine) {
        machines.add(machine);
    }

    @Override
    public void deleteMachine(Machine machine) {
        machines.remove(machine);
    }

    @Override
    public Machine[] getMachines() {
        return machines.toArray(new Machine[machines.size()]);
    }

    @Override
    public void addProcess(Process process) {
        processes.add(process);
    }

    @Override
    public void deleteProcess(Process process) {
        processes.remove(process);
    }

    @Override
    public Process[] getProcesses() {
        return processes.toArray(new Process[processes.size()]);
    }

    @Override
    public void runProcessOnItem(Process process, Item item) {
        if(!processes.contains(process)) {
            throw new IllegalStateException("no processes named " + process.getName() + " exist at this shop");
        }
        // cannot fully implement untill processes and items are better defined
    }
    
}

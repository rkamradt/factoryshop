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
    private final Set<String> roles = new TreeSet<>();
    private final Set<String> machines = new TreeSet<>();
    private final Set<String> processes = new TreeSet<>();
    public FactoryShopImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addRole(String role) {
        roles.add(role);
    }

    @Override
    public void deleteRole(String role) {
        roles.remove(role);
    }

    @Override
    public String[] getRoles() {
        return roles.toArray(new String[roles.size()]);
    }

    @Override
    public void addMachine(String machine) {
        machines.add(machine);
    }

    @Override
    public void deleteMachine(String machine) {
        machines.remove(machine);
    }

    @Override
    public String[] getMachines() {
        return machines.toArray(new String[machines.size()]);
    }

    @Override
    public void addProcess(String process) {
        processes.add(process);
    }

    @Override
    public void deleteProcess(String process) {
        processes.remove(process);
    }

    @Override
    public String[] getProcesses() {
        return processes.toArray(new String[processes.size()]);
    }

    @Override
    public void runProcessOnItem(String process, String item) {
        if(!processes.contains(process)) {
            throw new IllegalStateException("no processes name " + process + " exist at this shop");
        }
        // cannot fully implement untill processes and items are better defined
    }
    
}

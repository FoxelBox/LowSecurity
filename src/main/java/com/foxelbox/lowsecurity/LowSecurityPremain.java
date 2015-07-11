/**
 * This file is part of LowSecurity.
 *
 * LowSecurity is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LowSecurity is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with LowSecurity.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.foxelbox.lowsecurity;

import java.lang.instrument.Instrumentation;

public class LowSecurityPremain {
    public static void premain(String agentArgument, final Instrumentation instrumentation) {
        System.out.println("Hotpatching: Patch System.setSecurityManager");
        MyClassFileTransformer transformer = new LowSecurityClassVisitorPatchSystem.ClassTransformer();
        transformer.patch(instrumentation);
    }
}

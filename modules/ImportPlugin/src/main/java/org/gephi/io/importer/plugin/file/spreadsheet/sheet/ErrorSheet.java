/*
Copyright 2008-2016 Gephi
Authors : Eduardo Ramos <eduardo.ramos@gephi.org>
Website : http://www.gephi.org

This file is part of Gephi.

DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2016 Gephi Consortium. All rights reserved.

The contents of this file are subject to the terms of either the GNU
General Public License Version 3 only ("GPL") or the Common
Development and Distribution License("CDDL") (collectively, the
"License"). You may not use this file except in compliance with the
License. You can obtain a copy of the License at
http://gephi.org/about/legal/license-notice/
or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
specific language governing permissions and limitations under the
License.  When distributing the software, include this License Header
Notice in each file and include the License files at
/cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
License Header, with the fields enclosed by brackets [] replaced by
your own identifying information:
"Portions Copyrighted [year] [name of copyright owner]"

If you wish your version of this file to be governed by only the CDDL
or only the GPL Version 3, indicate your decision by adding
"[Contributor] elects to include this software in this distribution
under the [CDDL or GPL Version 3] license." If you do not indicate a
single choice of license, a recipient has the option to distribute
your version of this file under either the CDDL, the GPL Version 3 or
to extend the choice of license to its licensees as provided above.
However, if you add GPL Version 3 code and therefore, elected the GPL
Version 3 license, then the option applies only if the new code is
made subject to such option by the copyright holder.

Contributor(s):

Portions Copyrighted 2016 Gephi Consortium.
 */
package org.gephi.io.importer.plugin.file.spreadsheet.sheet;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Eduardo Ramos
 */
public final class ErrorSheet implements SheetParser {

    private static final Map<String, Integer> ERROR_HEADER = new HashMap<String, Integer>();

    static {
        ERROR_HEADER.put("error", 0);
    }
    private final SheetRow errorRow;

    public ErrorSheet(final String error) {
        this.errorRow = new SheetRow() {
            @Override
            public boolean isConsistent() {
                return true;
            }

            @Override
            public int size() {
                return 1;
            }

            @Override
            public String get(int index) {
                return error;
            }
        };
    }

    @Override
    public Map<String, Integer> getHeaderMap() {
        return ERROR_HEADER;
    }

    @Override
    public long getCurrentRecordNumber() {
        return 1;
    }

    @Override
    public void close() throws IOException {
        //NOOP
    }

    @Override
    public Iterator<SheetRow> iterator() {
        return Arrays.asList(errorRow).iterator();
    }
}
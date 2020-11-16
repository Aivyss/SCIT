// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.log4j;

import java.util.Vector;

class ProvisionNode extends Vector
{
    ProvisionNode(final Logger logger) {
        this.addElement(logger);
    }
}

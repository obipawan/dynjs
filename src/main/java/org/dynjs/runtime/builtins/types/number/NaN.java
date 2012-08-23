package org.dynjs.runtime.builtins.types.number;

import org.dynjs.runtime.GlobalObject;

public class NaN extends DynNumber {
    
    public NaN(final GlobalObject globalObject) { 
        super(globalObject);
    }

    @Override
    public Object getPrimitiveValue() {
        return Double.NaN;
    }
}

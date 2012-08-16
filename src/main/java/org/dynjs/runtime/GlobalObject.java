package org.dynjs.runtime;

import java.util.Collections;
import java.util.List;

import org.dynjs.Config;
import org.dynjs.compiler.JSCompiler;
import org.dynjs.runtime.BlockManager.Entry;
<<<<<<< HEAD
import org.dynjs.runtime.builtins.Eval;
=======
import org.dynjs.runtime.builtins.IsNaN;
>>>>>>> Add IsNaN implementation and specs.
import org.dynjs.runtime.builtins.ParseFloat;
import org.dynjs.runtime.builtins.ParseInt;
import org.dynjs.runtime.modules.ModuleProvider;

public class GlobalObject extends DynObject {

    private DynJS runtime;
    private JSCompiler compiler;
    private BlockManager blockManager;

    public GlobalObject(DynJS runtime) {
        this.runtime = runtime;
        this.compiler = new JSCompiler( runtime.getConfig() );
        this.blockManager = new BlockManager();

        defineGlobalProperty( "undefined", Types.UNDEFINED );
        defineGlobalProperty( "NaN", Double.NaN );
        defineGlobalProperty( "Infinity", Double.POSITIVE_INFINITY );
        defineGlobalProperty( "-Infinite", Double.NEGATIVE_INFINITY );
        defineGlobalProperty( "parseFloat", new ParseFloat( this ) );
        defineGlobalProperty( "parseInt", new ParseInt( this ) );
        defineGlobalProperty( "eval", new Eval( this ) );
        defineGlobalProperty( "isNaN", new IsNaN( this ) );

        /*
         * put("-Infinity", Double.NEGATIVE_INFINITY);
         * put("Object", new DynObject() {{
         * setProperty("defineProperty", new DefineProperty());
         * }});
         * put("Number", new DynObject());
         * put("Array", new DynObject());
         * put("Date", new DynObject());
         * put("String", new DynObject());
         * put("Boolean", new DynObject());
         * put("Error", new DynObject());
         * put("Function", new DynObject() {{
         * setProperty("prototype", get("Object"));
         * }});
         * put("eval", DynJSCompiler.wrapFunction(get("Function"), new Eval()));
         * put("require", DynJSCompiler.wrapFunction(get("Function"), new
         * Require()));
         * put("parseFloat", DynJSCompiler.wrapFunction(get("Function"), new
         * ParseFloat()));
         * put("parseInt", DynJSCompiler.wrapFunction(get("Function"), new
         * ParseInt()));
         * put("isNaN", DynJSCompiler.wrapFunction( get("Function"), new
         * IsNaN()));
         * put("Math", new DynObject());
         */
    }
    
    public List<ModuleProvider> getModuleProviders() {
        // TODO: wire me back up.
        return Collections.emptyList();
    }
    
    public DynJS getRuntime() {
        return this.runtime;
    }
    
    public Config getConfig() {
        return getRuntime().getConfig();
    }

    public JSCompiler getCompiler() {
        return this.compiler;
    }

    public BlockManager getBlockManager() {
        return this.blockManager;
    }

    public Entry retrieveBlockEntry(int statementNumber) {
        return this.blockManager.retrieve( statementNumber );
    }

    protected void defineGlobalProperty(final String name, final Object value) {
        PropertyDescriptor desc = new PropertyDescriptor() {
            {
                set( "Value", value );
                set( "Writable", true );
                set( "Configurable", true );
                set( "Enumerable", true );
            }
        };
        defineOwnProperty( null, name, desc, false );
    }

}

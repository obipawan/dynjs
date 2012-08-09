/**
 *  Copyright 2012 Douglas Campos, and individual contributors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.dynjs.parser.statement;

import static me.qmx.jitescript.util.CodegenUtils.*;

import java.util.List;

import me.qmx.jitescript.CodeBlock;

import org.antlr.runtime.tree.Tree;
import org.dynjs.compiler.DynJSCompiler;
import org.dynjs.parser.Statement;
import org.dynjs.runtime.DynThreadContext;
import org.dynjs.runtime.RT;

public class FunctionStatement extends BaseStatement implements Statement {

    private final String identifier;
    private final List<String> formalParameters;
    private Statement block;

    public FunctionStatement(final Tree tree, final List<String> args, final Statement block) {
        this( tree, null, args, block );
    }

    public FunctionStatement(final Tree tree, final String identifier, final List<String> formalParameters, final Statement block) {
        super( tree );
        this.identifier = identifier;
        this.formalParameters = formalParameters;
        this.block = block;
    }
    
    public String getIdentifier() {
        return this.identifier;
    }
    
    public List<String> getFormalParameters() {
        return this.formalParameters;
    }
    
    public Statement getBlock() {
        return this.block;
    }

    @Override
    public CodeBlock getCodeBlock() {
        return new CodeBlock() {
            {
                /**
                append( compileFunctionIfNecessary( args ) );
                if (identifier != null) {
                    dup();
                    // object object
                    aload( DynJSCompiler.Arities.THIS );
                    // object object this
                    swap();
                    // object this object
                    ldc( identifier );
                    // object this object id
                    swap();
                    // object this id object
                    invokedynamic( "dyn:setProp", sig( void.class, Object.class, Object.class, Object.class ), RT.BOOTSTRAP, RT.BOOTSTRAP_ARGS );
                    // object
                }
                **/

            }
        };
    }
}

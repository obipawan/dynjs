package org.dynjs.parser.statement;

import static me.qmx.jitescript.util.CodegenUtils.*;
import me.qmx.jitescript.CodeBlock;

import org.antlr.runtime.tree.Tree;
import org.dynjs.compiler.JSCompiler;
import org.dynjs.parser.Statement;
import org.dynjs.runtime.ExecutionContext;
import org.dynjs.runtime.RT;

public class ThisStatement extends BaseStatement implements Statement {
    public ThisStatement(Tree tree) {
        super(tree);
    }

    @Override
    public CodeBlock getCodeBlock() {
        return new CodeBlock(){{
            aload(JSCompiler.Arities.EXECUTION_CONTEXT);
            invokevirtual( p(ExecutionContext.class), "getThisBinding", sig(Object.class) );
        }};
    }
}

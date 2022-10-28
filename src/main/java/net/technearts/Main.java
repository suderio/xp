package net.technearts;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream("2+1;");
        LexerXP lexer = new LexerXP(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParserXP parser = new ParserXP(tokens);
        ParserXP.LineContext lines = parser.line();
        VisitorXP visitor = new VisitorXP();
        System.out.println(visitor.visit(lines));
    }
}

package net.technearts.xp

import io.quarkus.test.junit.QuarkusTest
import net.technearts.LexerXP
import net.technearts.ParserXP
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CharStreams.fromString
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.DiagnosticErrorListener
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@QuarkusTest
internal class XPTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun sumTest() {
        val input = fromString("2+1;")
        val lexer = LexerXP(input)
        val tokens = CommonTokenStream(lexer)
        val parser = ParserXP(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(DiagnosticErrorListener())
        val tree = parser.line()
        // val visitor = VisitorXP()
        // println(visitor.visit(tree))
        val walker = ParseTreeWalker()
        val listener = ListenerXP()
        walker.walk(listener, tree)
        assert(listener.integerValues.get(tree) == 3)
    }
}
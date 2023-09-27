package net.technearts.xp

import net.technearts.ParserXP
import net.technearts.ParserXP.*
import net.technearts.ParserXPBaseListener
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.ParseTreeProperty
import org.antlr.v4.runtime.tree.TerminalNode

class ListenerXP : ParserXPBaseListener() {
    var integerValues = ParseTreeProperty<Int>()
    var stringValues = ParseTreeProperty<String>()
    var integerUnaryFunction = ParseTreeProperty<(ParserRuleContext) -> Int>()
    override fun enterCallUnaryFuncOp(ctx: CallUnaryFuncOpContext) {
        super.enterCallUnaryFuncOp(ctx)
    }

    override fun enterProg(ctx: ProgContext?) {
        super.enterProg(ctx)
    }

    override fun exitProg(ctx: ProgContext?) {
        super.exitProg(ctx)
    }

    override fun enterLine(ctx: LineContext?) {
        super.enterLine(ctx)
    }

    override fun exitLine(ctx: LineContext?) {
        if (ctx != null) {
            integerValues.put(ctx, integerValues.get(ctx.expression()))
        }
    }

    override fun exitCallUnaryFuncOp(ctx: CallUnaryFuncOpContext) {
        super.exitCallUnaryFuncOp(ctx)
    }

    override fun enterImplicitCallUnaryFuncOp(ctx: ImplicitCallUnaryFuncOpContext) {
        super.enterImplicitCallUnaryFuncOp(ctx)
    }

    override fun exitImplicitCallUnaryFuncOp(ctx: ImplicitCallUnaryFuncOpContext) {
        super.exitImplicitCallUnaryFuncOp(ctx)
    }

    override fun enterImplicitCallBinaryFuncOp(ctx: ImplicitCallBinaryFuncOpContext) {
        super.enterImplicitCallBinaryFuncOp(ctx)
    }

    override fun exitImplicitCallBinaryFuncOp(ctx: ImplicitCallBinaryFuncOpContext) {
        super.exitImplicitCallBinaryFuncOp(ctx)
    }

    override fun enterOperatorExpr(ctx: OperatorExprContext) {
        super.enterOperatorExpr(ctx)
    }

    override fun exitOperatorExpr(ctx: OperatorExprContext) {
        super.exitOperatorExpr(ctx)
    }

    override fun enterSumOp(ctx: SumOpContext) {
        super.enterSumOp(ctx)
    }

    override fun exitSumOp(ctx: SumOpContext) {
        val left = integerValues.get(ctx.left)
        val right = integerValues.get(ctx.right)
        val result = when (ctx.operator.type) {
            PLUS -> left + right
            MINUS -> left - right
            else -> null
        }
        integerValues.put(ctx, result)
    }

    override fun enterMinusOp(ctx: MinusOpContext) {
        super.enterMinusOp(ctx)
    }

    override fun exitMinusOp(ctx: MinusOpContext) {
        super.exitMinusOp(ctx)
    }

    override fun enterIntLiteral(ctx: IntLiteralContext) {
        super.enterIntLiteral(ctx)
    }

    override fun exitIntLiteral(ctx: IntLiteralContext) {
        val value = when (val text = ctx.INTLIT().text) {
            "right" -> {(ctx: ParserXP.IntLiteralContext) -> Integer.valueOf(ctx.INTLIT().text)}
            "left" -> null
            else -> Integer.valueOf(text)
        }
        integerValues.put(ctx, value)
    }

    override fun enterComparisonOp(ctx: ComparisonOpContext) {
        super.enterComparisonOp(ctx)
    }

    override fun exitComparisonOp(ctx: ComparisonOpContext) {
        super.exitComparisonOp(ctx)
    }

    override fun enterAssignmentOp(ctx: AssignmentOpContext) {
        super.enterAssignmentOp(ctx)
    }

    override fun exitAssignmentOp(ctx: AssignmentOpContext) {
        super.exitAssignmentOp(ctx)
    }

    override fun enterParenExpression(ctx: ParenExpressionContext) {
        super.enterParenExpression(ctx)
    }

    override fun exitParenExpression(ctx: ParenExpressionContext) {
        super.exitParenExpression(ctx)
    }

    override fun enterCallBinaryFuncOp(ctx: CallBinaryFuncOpContext) {
        super.enterCallBinaryFuncOp(ctx)
    }

    override fun exitCallBinaryFuncOp(ctx: CallBinaryFuncOpContext) {
        super.exitCallBinaryFuncOp(ctx)
    }

    override fun enterVarReference(ctx: VarReferenceContext) {
        super.enterVarReference(ctx)
    }

    override fun exitVarReference(ctx: VarReferenceContext) {
        super.exitVarReference(ctx)
    }

    override fun enterRightRef(ctx: RightRefContext) {
        super.enterRightRef(ctx)
    }

    override fun exitRightRef(ctx: RightRefContext) {
        super.exitRightRef(ctx)
    }

    override fun enterExponentiationOp(ctx: ExponentiationOpContext) {
        super.enterExponentiationOp(ctx)
    }

    override fun exitExponentiationOp(ctx: ExponentiationOpContext) {
        super.exitExponentiationOp(ctx)
    }

    override fun enterProductOp(ctx: ProductOpContext) {
        super.enterProductOp(ctx)
    }

    override fun exitProductOp(ctx: ProductOpContext) {
        super.exitProductOp(ctx)
    }

    override fun enterEveryRule(ctx: ParserRuleContext) {
        super.enterEveryRule(ctx)
    }

    override fun exitEveryRule(ctx: ParserRuleContext) {
        super.exitEveryRule(ctx)
    }

    override fun visitTerminal(node: TerminalNode) {
        super.visitTerminal(node)
    }

    override fun visitErrorNode(node: ErrorNode) {
        super.visitErrorNode(node)
    }
}

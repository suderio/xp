package net.technearts;

import java.util.HashMap;
import java.util.Map;

public class VisitorXP extends ParserXPBaseVisitor<Integer> {
    private final Map<String, Integer> memory = new HashMap<String, Integer>();
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Integer visitSumOp(ParserXP.SumOpContext ctx) {
        return visit(ctx.left) + visit(ctx.right);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Integer visitMinusOp(ParserXP.MinusOpContext ctx) {
        return -visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Integer visitIntLiteral(ParserXP.IntLiteralContext ctx) {
        return Integer.valueOf(ctx.INTLIT().getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Integer visitExponentiationOp(ParserXP.ExponentiationOpContext ctx) {
        return visit(ctx.left) ^ visit(ctx.right);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Integer visitParenExpression(ParserXP.ParenExpressionContext ctx) {
        return visit(ctx.expression());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Integer visitAssignmentOp(ParserXP.AssignmentOpContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expression());
        memory.put(id, value);
        return value;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Integer visitProductOp(ParserXP.ProductOpContext ctx) {
        return visit(ctx.left) * visit(ctx.right);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Integer visitVarReference(ParserXP.VarReferenceContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) {
            return memory.get(id);
        }
        return null;
    }

}

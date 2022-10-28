parser grammar ParserXP;

options { tokenVocab=LexerXP; }

prog      : line* EOF;

line      : expression SEMICOLON;

expression  : expression ID expression                                          # callBinaryFuncOp
            | ID expression                                                     # callUnaryFuncOp
            | ID ASSIGN expression                                              # assignmentOp

            | MINUS expression                                                  # minusOp

            | <assoc=right>left=expression operator=EXP right=expression        # exponentiationOp
            | left=expression operator=(DIVISION|ASTERISK|MOD) right=expression # productOp
            | left=expression operator=(PLUS|MINUS) right=expression            # sumOp

            | left=expression operator=(EQ|LT|LE|GT|GE|NE) right=expression     # comparisonOp
            | ID                                                                # varReference
            | INTLIT                                                            # intLiteral
            | RREF                                                              # rightRef
            | LREF                                                              # rightRef
            | LPAREN expression RPAREN                                          # parenExpression
            ;

/* expr: ID '(' exprList? ')' # Call
  | expr '[' expr ']' # Index
  | '-' expr # Negate
  | '!' expr # Not
  | expr '*' expr # Mult
  | expr ('+'|'-') expr # AddSub
  | expr '==' expr # Equal
  | ID # Var
  | INT # Int
  | '(' expr ')' # Parens
  ;
  */
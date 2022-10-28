lexer grammar LexerXP;

// Whitespace
NEWLINE            : '\r\n' | '\r' | '\n' ;
WS                 : [\r\n\t ]+ -> skip ;
COMMENT            : '#' [.]*? NEWLINE -> skip  ;

// Keywords
THIS                : 'this' ;
TRUE                : 'true' ;
FALSE               : 'false';
NULL                : 'null' ;

// Literals
INTLIT             : '0'|[1-9][0-9]* ;
DECLIT             : '0.'[0]+ | [1-9][0-9]* '.' [0-9]+ ;

// Operators
HEAD               : '<<';
TAIL               : '>>';
SEPARATOR          : ',' ;
ASSIGN             : ':' ;
LPAREN             : '(' ;
RPAREN             : ')' ;
LBRACK             : '[' ;
RBRACK             : ']' ;
ELIPSIS            :'...';
RANGE              : '..';
DEREF              : '.' ;
REDIRECT           : '@' ;
// Arithmetic
PLUS               : '+' ;
MINUS              : '-' ;
ASTERISK           : '*' ;
DIVISION           : '/' ;
EXP                : '^' ;
MOD                : '%' ;
// Logical
NOT                : '!' ;
AND                : '&' ;
OR                 : '|' ;
AND_SHORT          : '&&';
OR_SHORT           : '||';
// Comparison
EQ                 : '=' ;
LE                 : '<=';
LT                 : '<' ;
GE                 : '>=';
GT                 : '>' ;
NE                 : '!=';
// Function
LREF               : '$' ;
RREF               : '?' ;
SEMICOLON          : ';' ;
// Identifiers
ID                 : [_]+[A-Za-z0-9_]* | [A-Za-z]+[A-Za-z0-9_]*;
// Should not be used
// ANY                : . ;
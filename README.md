# xplang

A fully turing complete expression language

## Operations

### Unary

Acts at the right operand with the lowest precedence.

```
-(3 + 1)
> -4

!true
> false

fact 4
> 12
```

### Binary

Acts in both left and right operand

```
result : 1 + 1
> 2

[1, 2, 3] . 1
> 2
```

### Defining Operations

Using the left ($) and right (?) references.

```
fact : [0: 1, 1: 1, ?: ? * this (? - 1)] . ?
<UnaryOperation>

fact 2
[0: 1, 1: 1, 2: 2 * this (2 - 1)] . 2
[0: 1, 1: 1, 2: 2 * [0: 1, 1: 1, 1: 1 * this (1 - 1)] . 1] . 2
[0: 1, 1: 1, 2: 2 * 1] . 2
[0: 1, 1: 1, 2: 2] . 2
2
```
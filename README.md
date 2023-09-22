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

Using the left and right references.

```
fact: [true: 1, false: right * (this (right - 1))] | right <= 1
<UnaryOperation>

succ: right + 1
succ 1
2
```

## Basic Operands

```
Arithm: + - * / ^ % ( ) 
Comp: < > <= >= = <> # lt gt le ge eq ne
Logic: | || & && ~ # or or! and and! not
List: [ ] , : "

[0, 1] + 1 = [1, 2]
[0, 1] + [1] = [1, 1]
[0, 1] + [1, 2] = [1, 3]

[0, 1] < [5] = true
[0, 1] < 5 = true

[1, 2] & 3 = [1, 2, 3]
3 & [1, 2] = [1, 2, 3]
[1, 2] | 0 = [1]
[1, 2] & [3] = [1, 2, [3]]
[1, 2] | [3] = []
~[1, 2] = false
~[] = true

"string" = ['s', 't', 'r', 'i', 'n', 'g']
```

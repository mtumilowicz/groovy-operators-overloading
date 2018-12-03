# groovy-operators-overloading
Easy example of operators overloading in groovy.

_Reference_: http://groovy-lang.org/operators.html#Operator-Overloading

# preface
Groovy allows you to overload the various operators so 
that they can be used with your own classes.

All (non-comparator) Groovy operators have a corresponding 
method that you can implement in your own classes. 
The only requirements are that your method is:
* public, 
* has the correct name, 
* and has the correct number of arguments. 
The argument types depend on what types you want to 
support on the right hand side of the operator.

|Operator   |Method   |Operator   |Method   |
|---|---|---|---|
|+   |a.plus(b)   |a[b]   |a.getAt(b)   |
|-   |a.minus(b)   |a[b] = c   |a.putAt(b, c)   |
|*   |a.multiply(b)   |a in b   |b.isCase(a)   |
|/   |a.div(b)   |<<   |a.leftShift(b)   |
|%   |a.mod(b)   |\>>   |a.rightShift(b)   |
|**   |a.power(b)   |\>>>   |a.rightShiftUnsigned(b)   |
|&#124;   |a.or(b)   |++   |a.next()   |
|&   |a.and(b)   |--   |a.previous()   |
|^   |a.xor(b)   |+a   |a.positive()   |
|as   |a.asType(b)   |-a   |a.negative()   |
|a()   |a.call()   |~a   |a.bitwiseNegate()   |
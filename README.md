[![Build Status](https://travis-ci.com/mtumilowicz/groovy-operators-overloading.svg?branch=master)](https://travis-ci.com/mtumilowicz/groovy-operators-overloading)

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

# project description
We provide `ComplexNumber` (equivalent to a point) 
class with overloaded operators:
* `+`
    ```
    ComplexNumber plus(ComplexNumber other) {
        new ComplexNumber(this.x + other.x, this.y + other.y)
    }
    ```
* `-`
    ```
    ComplexNumber minus(ComplexNumber other) {
        new ComplexNumber(this.x - other.x, this.y - other.y)
    }
    ```
* `*`
    ```
    ComplexNumber multiply(ComplexNumber other) {
        new ComplexNumber(this.x * other.x - this.y * other.y, this.x * other.y + this.y * other.x)
    }
    ```
* `/`
    ```
    ComplexNumber div(ComplexNumber other) {
        this * other.reciprocal()
    }
    ```
* `a[b]`
    ```
    double getAt(int idx) {
        if (idx == 0) x
        else if (idx == 1) y
        else throw new IllegalArgumentException("Wrong coordinate index, use 0 or 1")
    }
    ```
    * `a[0] == x`
    * `a[1] == y`
    * `a[>1] -> IllegalArgumentException`
    so you could decompose `ComplexNumber` to a 
    point:
        ```
        given:
        def x = 1.55
        def y = -2.23
        ComplexNumber complexNumber = new ComplexNumber(x, y)
        
        when:
        def (xValue, yValue) = complexNumber
        
        then:
        xValue == 1.55
        yValue == -2.23
        ```
# addition
It is very useful to decompose list after splitting:
```
given:
def list = 1..10

when:
def (less, more) = list.split { it < 5 }

then:
less == 1..<5
more == 5..10
```
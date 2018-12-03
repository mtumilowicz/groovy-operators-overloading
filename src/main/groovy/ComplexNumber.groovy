import groovy.transform.Immutable

/**
 * Created by mtumilowicz on 2018-06-05.
 */
@Immutable
class ComplexNumber {
    double x
    double y

    double getAt(int idx) {
        if (idx == 0) x
        else if (idx == 1) y
        else throw new IllegalArgumentException("Wrong coordinate index, use 0 or 1")
    }

    ComplexNumber plus(ComplexNumber other) {
        new ComplexNumber(this.x + other.x, this.y + other.y)
    }

    ComplexNumber minus(ComplexNumber other) {
        new ComplexNumber(this.x - other.x, this.y - other.y)
    }

    ComplexNumber multiply(ComplexNumber other) {
        new ComplexNumber(this.x * other.x - this.y * other.y, this.x * other.y + this.y * other.x)
    }

    ComplexNumber reciprocal() {
        if (this.x == 0 && this.y == 0) {
            throw new IllegalStateException("Cannot flip 0!")
        }

        def radius = this.x**2 + this.y**2

        new ComplexNumber(this.x / radius, -this.y / radius)
    }

    @Override
    String toString() {
        return "${x} + ${y}i"
    }
}

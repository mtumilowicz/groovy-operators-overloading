import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-06-05.
 */
class ComplexNumberTest extends Specification {

    def "decomposition"() {
        given:
        def x = 1.55
        def y = -2.23
        ComplexNumber complexNumber = new ComplexNumber(x, y)

        when:
        def (xValue, yValue) = complexNumber

        then:
        xValue == 1.55
        yValue == -2.23
    }

    def "test toString"() {
        given:
        ComplexNumber complexNumber = new ComplexNumber(1.55, -2.23)

        expect:
        "1.55 + -2.23i" == complexNumber.toString()
    }

    def "test plus"() {
        given:
        double x1 = 1.55
        double y1 = -2.23

        and:
        double x2 = 5.332
        double y2 = 3.76

        and:
        ComplexNumber cn1 = new ComplexNumber(x1, y1)
        ComplexNumber cn2 = new ComplexNumber(x2, y2)

        when:
        ComplexNumber result = cn1 + cn2

        then:
        result.x == x1 + x2
        result.y == y1 + y2

    }
}

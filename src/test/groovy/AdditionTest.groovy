import spock.lang.Specification


/**
 * Created by mtumilowicz on 2018-12-03.
 */
class AdditionTest extends Specification {

    def "decompose after splitting"() {
        given:
        def list = 1..10

        when:
        def (less, more) = list.split { it < 5 }
        
        then:
        less == 1..<5
        more == 5..10
    }
}
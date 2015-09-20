import groovy.util.GroovyTestCase

class StaleTest extends GroovyTestCase {

    def desiredDuration = 365
    def travelMultiplier = 1

    void testWhetherDonHasBecomeStaleOnThisProject() {
        def donsProjectStartDate = '2015-06-20'

        //uses custom duration 
        Integer desiredDuration = 25
        
        def actualProjectDuration = determineProjectDuration(donsProjectStartDate) 
        
        assert(actualProjectDuration < desiredDuration)
    }

    void testWhetherOtherHasBecomeStaleOnThisProject() {
        def othersProjectStartDate = '2015-01-20'
        
        def actualProjectDuration = determineProjectDuration(othersProjectStartDate) 
        
        assert(actualProjectDuration < desiredDuration)
    }

    void testWhetherTravelHaterHasBecomeStaleOnThisProject() {
        def travelHatersProjectStartDate = '2015-02-05'
        
        //custom travel multiplier
        travelMultiplier = 2

        def actualProjectDuration = determineProjectDuration(travelHatersProjectStartDate) 
        
        assert(actualProjectDuration < desiredDuration)
    }

    private determineProjectDuration(def projectStartDate) {
        Date parsedStartDate = Date.parse('yyyy-MM-dd', projectStartDate)
        return (new Date() - parsedStartDate) * travelMultiplier

    }
    
}

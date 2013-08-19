
Scenario: A scenario with additional integers
Given calculator object
And set 'additional' action for calculator
When a equal 3 and b equal 4
Then result is 7

Scenario: A scenario with substruction integers
Given set 'subctruction' action for calculator
When a equal 4 and b equal 2
Then result is 2




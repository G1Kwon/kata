This source code follows Martin Fowler's book "Refactoring, Improving the Design of Existing Code".

When you find you have to add a feature to a program, and the program's code is not structured in a convenient way to add the feature, first refactor the program to make it easy to add the feature, then add the feature.

Whenever you do refactoring, the first step is always the same. You need to build a solid set of tests for that section of code. The tests are essential because even though you follow refactorings structured to avoid most of the opportunities for introducing bugs, you are still human and still make mistakes. Thus you need solid tests.

Actualy the statement method prints out a simple text output of a rental statement

Rental Record for martin
Ran 3.5
Trois Couleurs: Bleu 2.0
Amount owed is 5.5
You earned 2 frequent renter points
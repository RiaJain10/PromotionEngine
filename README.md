# PromotionEngine
This is a simple promotion engine for a checkout process. The Cart contains a list of single character SKU ids (A, B, C. ) over which the promotion engine will run.
The promotion engine will calculate the total order value after applying the 2 promotion types
• buy 3 A's for 130.
• buy 2 for a fixed price ( C + D = 30 )
The promotions will be mutually exclusive; in other words if one is applied the other promotions will not apply.

**Approach of the Solution**
Our solution reads the promotion rules and SKU ids with price data in the form of csv files. It takes the user input scenario in the form of csv. The engine processes the cart and returns the total order value after applying the promotion.
The solution uses PromotionEngine to run the program. It takes the promotion rules and uses Rule and RuleBank class to manage it. It also uses SKU and SKUBank class to handle SKU data. It stores user selection in the form of Cart class. Then, the solution uses PromotionCalc to apply the promotions and return the total order value. The method checks and stores all the applicable promotions product wise and then applies those promotions to calculate the final value.

**Instructions on how to Import the project if using Eclipse IDE**
When using IDE's to use the above solution please use import the code function of the IDE.

**Unit Test Coverage: JUnit test coverage for the whole project is around 89%**

**Output of the Promotion Engine Solution**
Printing Unit Prices
ID: A Price: 50.0 Quantity: 1
ID: B Price: 30.0 Quantity: 1
ID: C Price: 20.0 Quantity: 1
ID: D Price: 15.0 Quantity: 1
Printing Active Rules
Rule [id=1, promotionType=Single, skuid=A, quantity=3, promotionPrice=130.0]
Rule [id=2, promotionType=Single, skuid=B, quantity=2, promotionPrice=45.0]
Rule [id=3, promotionType=Combo, skuid=C, quantity=1, promotionPrice=30.0]
Rule [id=3, promotionType=Combo, skuid=D, quantity=1, promotionPrice=30.0]
Printing resources/scenarioA.csv cart
ID: A Price: 50.0 Quantity: 1
ID: B Price: 30.0 Quantity: 1
ID: C Price: 20.0 Quantity: 1
Printing Order Value Total from resources/scenarioA.csv after Applying Promotion
Cart Total: 100.0
Printing resources/scenarioB.csv cart
ID: A Price: 50.0 Quantity: 5
ID: B Price: 30.0 Quantity: 5
ID: C Price: 20.0 Quantity: 1
Printing Order Value Total from resources/scenarioB.csv after Applying Promotion
Cart Total: 370.0
Printing resources/scenarioC.csv cart
ID: A Price: 50.0 Quantity: 3
ID: B Price: 30.0 Quantity: 5
ID: C Price: 20.0 Quantity: 1
ID: D Price: 15.0 Quantity: 1
Printing Order Value Total from resources/scenarioC.csv after Applying Promotion
Cart Total: 280.0
Printing resources/scenarioD.csv cart
ID: A Price: 50.0 Quantity: 3
ID: B Price: 30.0 Quantity: 2
ID: C Price: 20.0 Quantity: 1
ID: D Price: 15.0 Quantity: 1
Printing Order Value Total from resources/scenarioD.csv after Applying Promotion
Cart Total: 205.0

**IDE used to develop the solution is Eclipse**

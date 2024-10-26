Feature: Sauce Labs Sample App Testing

 
@apk
  Scenario: Successful login
    When the user enters username "standard_user"
    And the user enters password "secret_sauce"
    And the user taps the LOGIN button
    Then the user should see the products page

  Scenario: Failed login with locked out user
    When the user enters username "locked_out_user"
    And the user enters password "secret_sauce"
    And the user taps the LOGIN button
    Then the user should see an error message "Sorry, this user has been locked out."

  Scenario: Navigate and select a product
    Given the user has logged in successfully
    When the user taps on the product "Sauce Labs Backpack"
    Then the user should see the product details page for "Sauce Labs Backpack"

  Scenario: Add a product to the cart
    Given the user is on the product details page for "Sauce Labs Bike Light"
    When the user taps the ADD TO CART button
    Then the cart badge should display "1"

  Scenario: Remove a product from the cart
    Given the user has added "Sauce Labs Onesie" to the cart
    When the user taps the REMOVE button for "Sauce Labs Onesie"
    Then the product should be removed from the cart

  Scenario: Proceed to checkout
    Given the user has items in the cart
    When the user taps the cart icon
    And the user taps the CHECKOUT button
    Then the user should see the checkout information page

  Scenario: Complete a purchase
    Given the user is on the checkout information page
    When the user enters first name "John"
    And the user enters last name "Doe"
    And the user enters zip code "12345"
    And the user taps the CONTINUE button
    And the user taps the FINISH button on the checkout overview page
    Then the user should see the order confirmation page

  Scenario: Sort products
    Given the user is on the products page
    When the user taps the sort button
    And the user selects "Price (high to low)"
    Then the products should be displayed in descending order of price

  Scenario: Logout
    Given the user is logged in
    When the user taps the menu button
    And the user taps the LOGOUT option
    Then the user should be returned to the login page

  Scenario: Reset app state
    Given the user is logged in
    When the user taps the menu button
    And the user taps the RESET APP STATE option
    Then the cart should be empty
    And all items should be available to add to cart    
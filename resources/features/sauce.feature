Feature: Sauce Labs Sample App Testing

Background:
  Given the user is on the login page


Scenario Outline: Login attempts
  When the user logs in with username "<username>" and password "<password>"
  Then the user should see <outcome>

  Examples:
    | username      | password     | outcome                                           |
    | standard_user | secret_sauce | the products page                                 |
    | locked_out_user | secret_sauce | an error message "Sorry, this user has been locked out." |
@apk
Scenario: Product interaction
  Given the user has logged in successfully
  When the user selects the product "Sauce Labs Backpack"
  When the user adds the product to the cart
  Then the cart badge should display "1"
  When the user removes the product from the cart
  Then the cart should be empty

Scenario: Checkout process
  Given the user has items in the cart
  When the user proceeds to checkout
  And completes the purchase with:
    | First Name | Last Name | Zip Code |
    | John       | Doe       | 12345    |
  Then the user should see the order confirmation page

Scenario: Product sorting
  Given the user is on the products page
  When the user sorts products by "Price (high to low)"
  Then the products should be displayed in descending order of price

Scenario: App management
  Given the user is logged in
  When the user logs out
  Then the user should be on the login page
  When the user logs in again and resets the app state
  Then the cart should be empty
  And all items should be available to add to cart
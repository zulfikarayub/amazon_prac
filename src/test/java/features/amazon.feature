Feature: Book Appointment for haircut

  @addProduct
  Scenario Outline: add product and delete in cart page

    Given User is in Amazon page
    And Search for '<product>'
    And Verify Item is displayed on the screen and locate the first one, then store the price
    When Click on the First Result
    And  Once in the details page compare this price vs the first stored price
    When user click on Add to Cart.
    And Go to Cart and verify again the price of the phone
    Then  Delete Item



    Examples:
      | product                |
      | Samsung Galaxy Note 20 |

  @APIValidateElement
  Scenario Outline: add product and delete in cart page

    Given User is in Amazon page
    And User locate at the upper right corner the button: Hello, Sign In Account & lists and click on it
    And user  Click on New customer? Start right here
    And Fill Name field with the response of this API '<URI>' '<Email ID>'
    And Click on Condition of Use link and Locate the search bar and Search for "Echo" and click on "Echo support"
    Then Following elements should be displayed: Getting Started, Wi-Fi and Bluetooth, Device Software and Hardware, TroubleShooting

    Examples:
      | Email ID                    | URI     |
      | Firstname.Lastname@fake.com | baseURI |


  @hextexh
  Scenario Outline: to search text in the page

    Given User login the hexatech page
    And Click en el menú superior derecho search. Un campo de búsqueda se mostrará en pantalla
    And Tipear el texto '<TextToValidate>'. Un conjunto de resultados de búsqueda se mostrarán en pantalla.
    Then Ver que en alguno de los resultados se encuentre el texto '<AssertText>'




    Examples:
      | TextToValidate | AssertText                  |
      | Outsource      | Why outsource in Argentina? |









# Car Dealership Program

This application provides a user-friendly interface for exploring and buying exotic cars. 
Users can filter and sort cars, view detailed information, make secure payments, and receive purchase receipts. 
Here's a short description of all the components:

  J2fp (Main Application):
   Serves as the entry point for the JavaFX application.
   Loads the main user interface (UI) for the Exotic Car Dealership.
  
  DealershipController:
   Manages the primary UI for users.
   Provides features for filtering and sorting exotic cars based on various criteria, such as brand, color, and price.
   Allows users to view detailed car information and initiate the purchase process.
  
  CarInfoController:
   Displays comprehensive information about a selected car.
   Offers users the option to purchase a car, which opens the payment process.
  
  PaymentController:
   Manages the payment process.
   Validates user payment details.
   Proceeds to the receipt stage upon successful validation.
  
  ReceiptController:
   Generates a purchase receipt with details of the car, buyer's name, price, tax, and total amount.

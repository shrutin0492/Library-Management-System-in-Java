# Library-Management-System-in-Java
Mini project completed as part of the OOPS with Java course in the 3rd year of my undergrad.

# Library Management System in Java

This is a simple Library Management System implemented in Java, incorporating object-oriented programming concepts. The system allows users to manage books, patrons, and transactions in a library.

## Project Structure

- [Book.class](https://github.com/shrutin567/Library-Management-System-Java/blob/main/Book.java): Defines the `Book` class with properties and methods.
- [Library.class](https://github.com/shrutin567/Library-Management-System-Java/blob/main/Library.java): Implements the `Library` class with methods for managing books, patrons, and transactions.
- [LibraryManagementSystem.class](https://github.com/shrutin567/Library-Management-System-Java/blob/main/LibraryManagementSystem.java): Contains the main class with a menu-driven interface for user interaction.
- [Patron.class](https://github.com/shrutin567/Library-Management-System-Java/blob/main/Patron.java): Defines the `Patron` class with properties and methods.
- [Transaction.class](https://github.com/shrutin567/Library-Management-System-Java/blob/main/Transaction.java): Implements the `Transaction` class for recording book transactions.
- [LibraryManagementSystem.java](LibraryManagementSystem.java): Public class (driver class)

  
## Object-Oriented Programming (OOP) Concepts Utilized

### 1. Encapsulation
- Each class (`Book`, `Patron`, `Transaction`, `Library`) encapsulates its properties and provides methods to interact with them.

### 2. Inheritance
- No explicit inheritance is used in this project, as the focus is on composition and simplicity.

### 3. Polymorphism
- The `toString()` method is overridden in each class, providing a polymorphic behavior for displaying object information.

## Description

The Library Management System includes classes for `Book`, `Patron`, `Transaction`, and `Library`. The main class, `LibraryManagementSystem`, provides a menu-driven interface for users to interact with the library system. Users can display available books, patrons, transaction history, lend books, return books, add new books, and add new patrons.

The system initializes with some sample books and patrons. Books can be lent to patrons, and returned books are recorded in the transaction history.

## How to Run

### Prerequisites

- Java Development Kit (JDK) installed
- Java IDE (optional, but recommended)

### Steps (Command Line - Windows)

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/shrutin567/Library-Management-System-Java.git
   ```

2. **Navigate to the Project Directory:**
   ```bash
   cd Library-Management-System-Java
   ```

3. **Compile the Java Files:**
   ```bash
   javac LibraryManagementSystem.java
   ```

4. **Run the Program:**
   ```bash
   java LibraryManagementSystem
   ```

### Steps (Eclipse - Windows)

1. **Open Eclipse:**
   - Launch Eclipse IDE.

2. **Import Project:**
   - Click on `File` -> `Import`.
   - Select `General` -> `Existing Projects into Workspace`.
   - Choose the root directory as the cloned project.

3. **Run the Program:**
   - Right-click on `LibraryManagementSystem.java`.
   - Select `Run As` -> `Java Application`.

4. **Interact with the Program:**
   - The program's menu-driven interface will be displayed in the Eclipse Console.

## Usage

- Upon running the program, a menu will be displayed with various options.
- Enter the corresponding number to perform the desired action.
- Follow the prompts to input necessary information (e.g., Patron ID, Book ISBN, Date) for lending, returning, adding books, or adding patrons.
- View available books, patrons, and transaction history through the menu options.
- Exit the system by choosing the "8. Exit" option in the menu.

## Note

This is a console-based application designed for educational purposes, demonstrating basic OOP concepts in Java. It can be extended for more features and enhanced functionality.

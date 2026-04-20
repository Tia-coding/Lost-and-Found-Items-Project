# Lost & Found Management System

Ever lost something on campus and had no idea where it went?  
This project is a simple console-based system that helps manage lost and found items efficiently.
Built using Java and MySQL, it allows users to register, log in, report items, and browse existing records — all through a clean, menu-driven interface.

# Features of this project:

1. Create an account and log in securely.
2. Report a lost or found item.
3. View all reported items.
4. Sort items based on when they were reported.
5. Take backups of item data/ store in Database.
6. Explore Java reflection (for learning advanced concepts)

# Skills/Languages used:
1. Java.
2. JDBC (for database connectivity).
3. MySQL.
4. File Handling & Serialization.
5. Comparator (for sorting).
6. Reflection API (bonus feature)

# Project Structure
1. **Main**
The entry point of the application. It starts the program by initiating the login process.
Acts as the bridge between the user and the system flow.

2. **Login_Page**
Handles user authentication by verifying credentials using a MySQL database.
If login is successful, it redirects to the main menu; otherwise, it guides the user to register.

3. **Registration_Page**
Allows new users to create an account by storing their details in the database.
Ensures users are registered before accessing the system.

4. **Lost_Found_menu**
Provides a menu-driven interface for users to interact with the system.
Lets users choose actions like adding items, viewing records, sorting, and logout.

5. **Lost_Found_service**
Contains the core functionality of the application, including adding, viewing, sorting, and backing up items.
Handles database operations, file serialization, and even uses reflection for class inspection.

6. **Describe_Item_Comparator**
Defines the structure of a lost/found item with all its attributes.
Implements a comparator to sort items based on report time in descending order.

 **Database**
This project includes a SQL file to help you quickly set up the database.

Use the database in MySQL
Add the correct userid and password to help build connection after downloading the sql file in the server.

**Working of this application:**
1. The application starts with the login page.
2. Existing users enter credentials, which are verified using MySQL via JDBC.
3. New users are redirected to the registration page to create an account.
4. After successful login, the user accesses a menu-driven interface.
5. Users can:
   - Add lost/found items (stored in database)
   - View all items
   - Sort items based on report time
   - Take backup using serialization
6. All data is managed through MySQL and accessed using JDBC.

**Tables made for this project:**
1. Users
2. UserLogin
3. LostItem

**Learnings through this project:**
1. Gained hands-on experience in Java and Object-Oriented Programming (OOP) concepts by building a complete application.
2. Learned how to connect Java applications to a database using JDBC and MySQL.
3. Understood how to perform database operations like inserting and retrieving data using SQL  queries.
4. Explored file handling and serialization to store and back up data.
5. Got exposure to advanced concepts like the Java Reflection API.
6. Improved understanding of structuring a real-world application with multiple classes and modules.

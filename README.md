# Login User System

A simple Java console application for user registration and login. I built this project to practice Java OOP, encapsulation, validation, exceptions, and custom exceptions.

## Features

- Register a new user
- Login with username and password
- Prevent duplicate usernames
- Prevent duplicate emails
- Validate user input
- Logout
- View the current user's profile
- Handle invalid login attempts using custom exceptions

## How It Works

The program provides a menu with several options:

1. Register
2. Login
3. Logout
4. View Profile
5. Exit

When registering, the program checks that the username, password, and email are not empty. It also checks that the username and email are not already registered.

When logging in, the program checks the entered username and password. Invalid login attempts are handled using a custom `InvalidLoginException`.

## Technologies

- Java
- ArrayList
- OOP
- Encapsulation
- Getters and Setters
- Exception Handling
- Custom Exceptions

## Custom Exceptions

- `UserAlreadyExistsException` — used when a username or email is already registered.
- `InvalidLoginException` — used when the username does not exist or the password is incorrect.

## What I Practiced

- Creating and using classes and objects
- Encapsulation with private fields
- Getters and setters
- Working with `ArrayList`
- Input validation
- `try` / `catch`
- `throw`
- Creating custom exceptions
- Basic user authentication logic
- Managing the currently logged-in user

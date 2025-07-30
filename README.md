# Simple Calculator - Android App

A functional and user-friendly calculator application for Android, built with Kotlin. It supports basic arithmetic operations, parentheses for order of operations, percentage calculations, and maintains a history of recent calculations.

## Table of Contents
* [Features](#features)
* [Screenshots](#screenshots)
* [Technologies Used](#technologies-used)
* [Setup & Installation](#setup--installation)
* [How to Use](#how-to-use)
* [License](#license)

## Features
*   **Basic Arithmetic Operations:** Addition (+), Subtraction (-), Multiplication (×), Division (÷).
*   **Percentage Calculation:** (%)
*   **Parentheses Support:** For managing the order of operations.
*   **Decimal Input:** Allows for calculations with decimal numbers.
*   **Calculation History:** View a list of your previous calculations and their results.
*   **Clear & Backspace:** Easily clear the entire input or remove the last character.
*   **Responsive UI:** Designed with Material Components and supports edge-to-edge display.

## Screenshots
*(It's highly recommended to add 1-3 screenshots of your app here. Replace the paths below with your actual screenshot files.)*

![Calculator Main Screen](path/to/your/screenshot_main.png)
*Caption: Main calculator interface.*

![Calculation History](path/to/your/screenshot_history.png)
*Caption: Calculation history view.*

## Technologies Used
*   **Language:** Kotlin
*   **Platform:** Android SDK (e.g., Min API 24, Target API 33 - *Adjust as needed*)
*   **UI:**
    *   XML for layouts
    *   Material Design Components (`Button`, `TextView`, `ScrollView`)
    *   Data Binding
    *   Edge-to-edge display handling (`ViewCompat.setOnApplyWindowInsetsListener`)
*   **Core Logic:**
    *   **Expression Evaluation:** `EvalEx` library (com.udojava:EvalEx) for robust parsing and calculation of mathematical strings.
*   **Build Tool:** Gradle
*   **IDE:** Android Studio

## Setup & Installation

To get a local copy up and running, follow these simple steps:

1.  **Clone the repository:**
    

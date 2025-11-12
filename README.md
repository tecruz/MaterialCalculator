# Material Calculator

[![CI](https://github.com/tecruz/MaterialCalculator/actions/workflows/ci.yml/badge.svg?branch=master)](https://github.com/tecruz/MaterialCalculator/actions/workflows/ci.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=tecruz_MaterialCalculator&metric=alert_status&token=8e1f3693f25860b1579dadf2e409e50d9b92333b)](https://sonarcloud.io/summary/new_code?id=tecruz_MaterialCalculator)
[![codecov](https://codecov.io/gh/tecruz/MaterialCalculator/graph/badge.svg?token=YL60LTZ66L)](https://codecov.io/gh/tecruz/MaterialCalculator)

A simple calculator app built with Jetpack Compose and Material Design.

## Features

*   Basic arithmetic operations: addition, subtraction, multiplication, and division.
*   Clean and intuitive user interface following Material Design guidelines.
*   Responsive layout for different screen sizes.

## Screenshots

<p align="center">
  <img src="screenshots/screenshot_phone.png" width="250" />
  <img src="screenshots/screenshot_tablet.png" width="500" />
</p>

## Architecture

The app follows a simple MVI-like architecture with two main layers:

*   **Domain**: Contains the business logic for parsing and evaluating mathematical expressions. This layer is independent of the Android framework.
*   **Presentation**: Contains the UI components built with Jetpack Compose. The UI observes the state from the domain layer and displays it to the user.

## Quality Assurance

This project is configured with a comprehensive suite of tools to ensure code quality, consistency, and stability.

- **CI/CD**: A [GitHub Actions](https://github.com/tecruz/MaterialCalculator/actions/workflows/ci.yml) workflow runs on every push and pull request. It includes:
    - **Build & Test**: Assembles the debug build and runs unit tests.
    - **Static Analysis**: Uses [Detekt](https://detekt.dev/) for static code analysis and [ktlint](https://ktlint.github.io/) for code style checking.
    - **Instrumented Tests**: Runs instrumented tests on an Android emulator using a matrix strategy. It also caches the emulator state to speed up test runs.
    - **Test Coverage**: Generates a combined test coverage report for both unit and instrumented tests using [JaCoCo](https://www.eclemma.org/jacoco/) and uploads it to [Codecov](https://codecov.io/).

- **Automated Dependency Updates**: [Dependabot](https://docs.github.com/en/code-security/dependabot) is configured to automatically create pull requests for outdated dependencies, helping to keep the project secure and up-to-date.

## Built with

*   [Kotlin](https://kotlinlang.org/)
*   [Jetpack Compose](https://developer.android.com/jetpack/compose)
*   [Material Design](https://material.io/)

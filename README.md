# Material Calculator

[![CI](https://github.com/tecruz/MaterialCalculator/actions/workflows/ci.yml/badge.svg?branch=master)](https://github.com/tecruz/MaterialCalculator/actions/workflows/ci.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=tecruz_MaterialCalculator&metric=alert_status&token=8e1f3693f25860b1579dadf2e409e50d9b92333b)](https://sonarcloud.io/summary/new_code?id=tecruz_MaterialCalculator)
[![codecov](https://codecov.io/gh/tecruz/MaterialCalculator/graph/badge.svg?token=YL60LTZ66L)](https://codecov.io/gh/tecruz/MaterialCalculator)

A simple calculator app built with Jetpack Compose and Material Design.

## Features

* Basic arithmetic operations: addition, subtraction, multiplication, and division.
* Clean and intuitive user interface following Material Design guidelines.
* Responsive layout for different screen sizes.

## Screenshots

<p align="center">
  <img src="screenshots/screenshot_phone.png" width="250" />
  <img src="screenshots/screenshot_tablet.png" width="500" />
</p>

## Architecture

The app follows a simple MVI-like architecture with two main layers:

* **Domain**: Contains the business logic for parsing and evaluating mathematical expressions. This layer is independent of the Android framework.
* **Presentation**: Contains the UI components built with Jetpack Compose. The UI observes the state from the domain layer and displays it to the user.

## Built with

* [Kotlin](https://kotlinlang.org/)
* [Jetpack Compose](https://developer.android.com/jetpack/compose)
* [Material Design](https://material.io/)

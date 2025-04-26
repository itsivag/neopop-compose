# NeoPop Compose

An UI library based on [CRED's NeoPop design framework](https://cred.club/neopop), reimagined for Jetpack Compose. This library brings the edgy and pop aesthetics of NeoPop design to modern Android applications using Compose UI.

[![Maven Central](https://img.shields.io/maven-central/v/io.github.itsivag/neopop-compose.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/io.github.itsivag/neopop-compose)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

> **Note:** This README was generated with the assistance of AI and may contain errors or inaccuracies. Please refer to the actual source code and documentation for the most accurate information.

## Features

* 🎨 Vibrant NeoPop design elements
* 🔳 Multiple button variants with distinctive 3D effects
* 🎛️ Tilt and floating animations for interactive elements
* 🌓 Support for light and dark themes
* 🧩 Easy integration with existing Compose apps
* ⚡ Built for performance

## Installation

Add the dependency to your module's `build.gradle` file:

```gradle
dependencies {
    implementation("io.github.itsivag:neopop-compose:0.0.1")
}
```

## Components

<table>
<tr>
<td align="center">
  <img src="https://raw.githubusercontent.com/itsivag/neopop-compose/main/screenshots/floating_tilt.gif" width="200px" alt="Floating Tilt Button"><br>
  <b>Floating Tilt Button</b>
</td>
<td align="center">
  <img src="https://raw.githubusercontent.com/itsivag/neopop-compose/main/screenshots/non_floating_tilt.gif" width="200px" alt="Non-Floating Tilt Button"><br>
  <b>Non-Floating Tilt Button</b>
</td>
<td align="center">
  <img src="https://raw.githubusercontent.com/itsivag/neopop-compose/main/screenshots/floating_stroke.gif" width="200px" alt="Floating Stroke Button"><br>
  <b>Floating Stroke Button</b>
</td>
</tr>

<tr>
<td align="center">
  <img src="https://raw.githubusercontent.com/itsivag/neopop-compose/main/screenshots/elevated_button.gif" width="200px" alt="Elevated Button"><br>
  <b>Elevated Button</b>
</td>
<td align="center">
  <img src="https://raw.githubusercontent.com/itsivag/neopop-compose/main/screenshots/flat_button.gif" width="200px" alt="Flat Button"><br>
  <b>Flat Button</b>
</td>
<td align="center">
  <img src="https://raw.githubusercontent.com/itsivag/neopop-compose/main/screenshots/elevated_stroke.gif" width="200px" alt="Elevated Stroke Button"><br>
  <b>Elevated Stroke Button</b>
</td>
</tr>
</table>

## Usage

### Setting up the theme

Wrap your UI with `NeoPopTheme` to ensure consistent styling:

```kotlin
import com.itsivag.neopop_compose.theme.NeoPopTheme

@Composable
fun MyApp() {
    NeoPopTheme {
        // Your app content
    }
}
```

### Using Tilt Buttons

#### Floating Tilt Button

```kotlin
import com.itsivag.neopop_compose.tilt_button.NeopopFloatingTiltButton

NeopopFloatingTiltButton(
    text = "Play now",
    onClick = { /* Handle click */ },
    modifier = Modifier.padding(vertical = 32.dp)
)
```

#### Non-Floating Tilt Button

```kotlin
import com.itsivag.neopop_compose.tilt_button.NeopopNonFloatingTiltButton

NeopopNonFloatingTiltButton(
    text = "Play now",
    onClick = { /* Handle click */ },
    modifier = Modifier.padding(vertical = 32.dp)
)
```

#### Floating Stroke Tilt Button

```kotlin
import com.itsivag.neopop_compose.tilt_button.NeopopFloatingStrokeTiltButton

NeopopFloatingStrokeTiltButton(
    text = "Play now",
    onClick = { /* Handle click */ },
    modifier = Modifier.padding(vertical = 32.dp)
)
```

### Using Regular Buttons

#### Elevated Button

```kotlin
import com.itsivag.neopop_compose.pop_button.NeoPopElevatedButton

NeoPopElevatedButton(
    text = "Pay me",
    onClick = { /* Handle click */ },
    modifier = Modifier.padding(vertical = 32.dp)
)
```

#### Flat Button

```kotlin
import com.itsivag.neopop_compose.pop_button.NeopopFlatButton

NeopopFlatButton(
    text = "Pay now",
    onClick = { /* Handle click */ },
    modifier = Modifier.padding(vertical = 32.dp)
)
```

#### Elevated Stroke Button

```kotlin
import com.itsivag.neopop_compose.pop_button.NeopopElevatedStrokeButton

NeopopElevatedStrokeButton(
    text = "Pay me",
    onClick = { /* Handle click */ },
    modifier = Modifier.padding(vertical = 32.dp)
)
```

#### Flat Stroke Button

```kotlin
import com.itsivag.neopop_compose.pop_button.NeopopFlatStrokeButton

NeopopFlatStrokeButton(
    text = "Pay now",
    onClick = { /* Handle click */ },
    modifier = Modifier.padding(vertical = 32.dp)
)
```

## Example

For a complete example of how to use all components, please refer to the sample composable provided in the library:

[View Sample Code](https://github.com/itsivag/neopop-compose/blob/main/neopop-compose/src/main/java/com/itsivag/neopop_compose/Sample.kt)

The sample demonstrates how to create a showcase of all available components with proper styling and layout.

## Requirements

* Android API Level 24+
* Jetpack Compose
* Kotlin 1.7.20+

## Credits

This library is inspired by [CRED's NeoPop design framework](https://cred.club/neopop) and was created as part of a personal exploration into Jetpack Compose UI development.

## License

```
Copyright 2025 Siva G

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

---

Made with ❤️ by [Siva G](https://github.com/itsivag)

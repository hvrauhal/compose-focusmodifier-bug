# Reproduce Jetpack Compose issue on onFocusChanged and focusModifier order

The following are different:

            .onFocusChanged {
                color = if (it.isFocused) Color.Red else Color.Blue
            }
            .focusModifier()

            .focusModifier()
            .onFocusChanged {
                color = if (it.isFocused) Color.Red else Color.Blue
            }

See [MainActivity.kt](app/src/main/java/com/example/MainActivity.kt)
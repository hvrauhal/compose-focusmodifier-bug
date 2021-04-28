# Reproduce Jetpack Compose issue on onFocusChanged and focusModifier order


            .onFocusChanged {
                color = if (it.isFocused) Color.Red else Color.Blue
            }
            .focusModifier()

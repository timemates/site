package io.timemates.site.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.rememberColorMode
import io.timemates.site.components.style.boxShadow
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun Footer() {
    val colorMode by rememberColorMode()
    Box(
        Modifier.fillMaxWidth().minHeight(100.px).boxShadow(colorMode),
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier.fillMaxWidth(70.percent).margin(1.em),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpanText(
                "Copyright © 2023 TimeMates. All rights reserved.",
                Modifier.fontSize(0.75.em).opacity(70.percent).textAlign(TextAlign.Center)
            )
        }
    }
}
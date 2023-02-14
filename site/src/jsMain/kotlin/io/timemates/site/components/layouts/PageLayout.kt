package io.timemates.site.components.layouts

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import kotlinx.browser.document
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import io.timemates.site.components.sections.Footer
import io.timemates.site.components.sections.NavHeader

@Composable
fun PageLayout(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    LaunchedEffect(title) {
        document.title = title
    }

    Box(Modifier
        .fillMaxWidth()
        .minHeight(100.percent)
        .gridTemplateRows("1fr auto")
        .then(modifier)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().textAlign(TextAlign.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavHeader()
            content()
        }
        // Associate the footer with the row that will get pushed off the bottom of the page if it can't fit.
        //Footer(Modifier.align(Alignment.Center).gridRowStart(2).gridRowEnd(3))
    }
}
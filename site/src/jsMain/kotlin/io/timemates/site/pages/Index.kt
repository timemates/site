package io.timemates.site.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaTelegram
import com.varabyte.kobweb.silk.components.text.SpanText
import io.timemates.site.components.layouts.PageLayout
import io.timemates.site.components.widgets.LinkButton
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1

@Page
@Composable
fun HomePage() {
    PageLayout(
        title = "TimeMates",
    ) {

        Image(
            "icon.gif",
            modifier = Modifier.borderRadius(10.percent)
                .margin(top = 64.px)
                .maxHeight(200.px)
        )

        H1 {
            SpanText(
                "TimeMates",
                modifier = Modifier.fontSize(72.px)
            )
        }

        SpanText(
            "The ultimate tool for organizing time and tasks, " +
                "collaborating with team members, and tracking progress.",
            modifier = Modifier.color(Color.gray).fontSize(24.px)
        )

        Row(modifier = Modifier.margin(32.px)) {

            LinkButton(
                text = "Check our GitHub",
                path = "https://github.com/timemates",
                primary = true
            ) {
                FaGithub(Modifier.margin(right = 8.px))
            }

            LinkButton(
                text = "Join Community",
                path = "https://t.me/timemates",
                modifier = Modifier.margin(left = 16.px)
            ) {
                FaTelegram(Modifier.margin(right = 8.px))
            }
        }
    }
}
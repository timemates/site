package io.timemates.site.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowDown
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaTelegram
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIf
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.getColorMode
import io.timemates.site.components.layouts.PageLayout
import io.timemates.site.components.style.boxShadow
import io.timemates.site.components.widgets.LinkButton
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Page
@Composable
fun HomePage() {
    PageLayout(
        title = "TimeMates",
    ) {
        Image(
            "icon.gif",
            modifier = Modifier.borderRadius(10.percent)
                .margin(top = 6.em)
                .maxHeight(200.px)
        )

        H1 {
            SpanText(
                "TimeMates",
                modifier = Modifier.fontSize(50.px)
                    .margin(leftRight = 16.px)
            )
        }

        SpanText(
            "The ultimate tool for organizing time and tasks, " +
                "collaborating with team members, and tracking progress inspired by Pomodoro technique.",
            modifier = Modifier
                .color(Color.gray)
                .fontSize(20.px)
                .margin(leftRight = 16.px)
        )

        SimpleGrid(
            modifier = Modifier.margin(2.em).columnGap(16.px).rowGap(16.px),
            numColumns = numColumns(1, md = 2)
        ) {

            LinkButton(
                text = "Try TimeMates",
                path = "#download",
                primary = true
            ) {
                FaArrowRight(modifier = Modifier.margin(right = 16.px))
            }

            LinkButton(
                text = "Join Community",
                path = "https://t.me/timemates"
            ) {
                FaTelegram(Modifier.margin(right = 16.px))
            }
        }

        FaArrowDown(
            modifier = Modifier.margin(top = 3.em, bottom = 2.em)
                .fillMaxWidth(15.percent)
        )

        Row(
            modifier = Modifier.fillMaxWidth(70.percent)
                .borderRadius(16.px)
                .boxShadow(getColorMode())
                .padding(1.em)
                .margin(topBottom = 4.em),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
                Image(
                    modifier = Modifier.height(12.em)
                        .displayUntil(Breakpoint.MD)
                        .margin(left = 16.px),
                    src = "app-preview.png",
                )
                H2(Modifier.id("download").toAttrs()) {
                    Text("Try TimeMates")
                }
                SpanText(
                    "We're currently in the process of creating the first version of the TimeMates application, " +
                        "which unfortunately means it's not ready for testing just yet. However, we're excited to let" +
                        " you know that it will be available on Web, Desktop, and Android platforms once it's " +
                        "launched. Stay tuned for updates on its availability!",
                    modifier = Modifier.color(Color.gray).fontSize(16.px).textAlign(TextAlign.Start),
                )
                LinkButton(
                    modifier = Modifier.margin(top = 16.px).displayIf(Breakpoint.MD),
                    text = "Check progress",
                    path = "https://github.com/timemates/app",
                ) {
                    FaGithub(modifier = Modifier.margin(right = 16.px))
                }

                LinkButton(
                    modifier = Modifier.margin(top = 16.px)
                        .displayUntil(Breakpoint.MD)
                        .fillMaxWidth(),
                    text = "Check progress",
                    path = "https://github.com/timemates/app",
                ) {
                    FaGithub(modifier = Modifier.margin(right = 16.px))
                }
            }
            Image(
                modifier = Modifier.height(12.em)
                    .align(Alignment.CenterVertically)
                    .displayIf(Breakpoint.MD)
                    .margin(left = 16.px),
                src = "app-preview.png",
            )
        }

    }
}

@Composable
private fun FeatureItem(
    imageName: String,
    title: String,
    description: String
) {
    Column(
        modifier = Modifier.padding(12.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(150.px),
            src = imageName
        )
        H3 { Text(title) }
        SpanText(
            modifier = Modifier.color(Color.gray),
            text = description
        )
    }
}
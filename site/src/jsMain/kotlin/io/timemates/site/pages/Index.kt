package io.timemates.site.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.FaTelegram
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.getColorMode
import com.varabyte.kobweb.silk.theme.colors.rememberColorMode
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
                "collaborating with team members, and tracking progress.",
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


        Hr(
            Modifier.borderTop(
                1.px, LineStyle.Dashed, Color.gray
            )
                .margin(topBottom = 6.em)
                .fillMaxWidth(15.percent).toAttrs()
        )

        H1 {
            SpanText(
                "Why TimeMates?",
                modifier = Modifier.margin(top = 9.em)
            )
        }

        SimpleGrid(
            modifier = Modifier
                .id("why-timemates")
                .margin(leftRight = 4.em, topBottom = 1.em),
            numColumns = numColumns(1, md = 4)
        ) {
            FeatureItem(
                imageName = "illustrations/being-creative.svg",
                title = "Be creative",
                "Focus on your ideas, don't think about" +
                    " appropriate time",
            )

            FeatureItem(
                imageName = "illustrations/charts-pie-and-bars.svg",
                title = "Be better",
                "Improve processes with our" +
                    " integrations system",
            )

            FeatureItem(
                imageName = "illustrations/social-media-discussion.svg",
                title = "Better way of communication",
                "Synchronize" +
                    " people together and optimize their time and" +
                    " efforts",
            )

            FeatureItem(
                imageName = "illustrations/charts-pie-and-bars.svg",
                title = "Achieve high performance",
                "Setup everything for your needs," +
                    " get results immediately",
            )
        }

        Hr(
            Modifier.borderTop(
                1.px, LineStyle.Dashed, Color.gray
            )
                .margin(topBottom = 6.em)
                .fillMaxWidth(15.percent).toAttrs()
        )

        H1(Modifier.id("download").toAttrs()) {
            Text("Try it out!")
        }

        Column(
            modifier = Modifier
                .padding(3.em)
                .textAlign(TextAlign.Center)
                .margin(bottom = 6.em, left = 3.em, right = 3.em)
                .maxWidth(500.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                "illustrations/coding.svg",
                modifier = Modifier.size(120.px)
            )
            H2 { Text("We're still in developing") }
            SpanText("Currently, we're working on the first version of TimeMates application." +
                " So, you can't try it at the moment, unfortunately.")
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
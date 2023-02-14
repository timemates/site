package io.timemates.site.components.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgba
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaMoon
import com.varabyte.kobweb.silk.components.icons.fa.FaSun
import com.varabyte.kobweb.silk.components.icons.fa.FaTelegram
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.components.style.*
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.rememberColorMode
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import com.varabyte.kobweb.silk.theme.toSilkPalette
import io.timemates.site.components.style.boxShadow
import io.timemates.site.components.widgets.ButtonShape
import io.timemates.site.components.widgets.LinkButton
import io.timemates.site.components.widgets.ThemedButton
import org.jetbrains.compose.web.css.*

val NavHeaderStyle by ComponentStyle.base {
    Modifier
        .fillMaxWidth()
        .height(50.px)
        // Intentionally invert the header colors from the rest of the page
        .backgroundColor(colorMode.toSilkPalette().color)
        .zIndex(1)
        .fillMaxWidth()
        .backgroundColor(getNavBackgroundColor(colorMode))
        .position(Position.Sticky)
        .top(0.percent)
        .backdropFilter(saturate(180.percent), blur(5.px))
        .boxShadow(colorMode)
}

val NavItemStyle by ComponentStyle {
    // Intentionally invert the header colors from the rest of the page
    val linkColor = colorMode.toSilkPalette().background.inverted()

    base { Modifier.margin(leftRight = 15.px) }

    link { Modifier.color(linkColor) }
    visited { Modifier.color(linkColor) }
}

val NavButtonVariant by NavItemStyle.addVariant {
    base { Modifier.padding(0.px).clip(Circle()) }
}

private fun getNavBackgroundColor(colorMode: ColorMode): CSSColorValue {
    return when (colorMode) {
        ColorMode.DARK -> rgba(0.0, 0.0, 0.0, 0.65)
        ColorMode.LIGHT -> rgba(255, 255, 255, 0.65)
    }
}

@Composable
private fun NavLink(path: String, text: String) {
    Link(path, text, NavItemStyle.toModifier(), UndecoratedLinkVariant)
}

@Composable
fun NavHeader() {
    var colorMode by rememberColorMode()
    Box(NavHeaderStyle.toModifier()) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer()
            LinkButton(
                path = "https://t.me/timemates",
                BUTTON_MARGIN,
                shape = ButtonShape.CIRCLE,
            ) {
                FaTelegram()
            }
            LinkButton(
                "https://github.com/timemates",
                BUTTON_MARGIN,
                shape = ButtonShape.CIRCLE,
            ) {
                FaGithub()
            }
            ThemedButton(
                onClick = { colorMode = colorMode.opposite() },
                BUTTON_MARGIN,
                shape = ButtonShape.CIRCLE,
            ) {
                when (colorMode) {
                    ColorMode.DARK -> FaSun()
                    ColorMode.LIGHT -> FaMoon()
                }
            }
        }
    }
}

private val BUTTON_MARGIN = Modifier.margin(0.px, 10.px)
package com.example.cc17_3f_perezj_act5

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SpaceArtDisplay() {
    val config = LocalConfiguration.current
    when (config.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            ArtSpaceDisplayLandscape()
        }
        else -> {
            ArtSpaceDisplayPortrait()
        }
    }
}

@Composable
fun ArtSpaceDisplayLandscape()
{
    var displayImage by remember {
        mutableStateOf(0)
    }
    val imageResource = when(displayImage) {
        0 -> R.drawable.mona_lisa
        1 -> R.drawable.starry_night
        2 -> R.drawable.the_kiss
        3 -> R.drawable.composition_with_red_blue_and_yellow
        4 -> R.drawable.les_demoiselles_d_avignon


        else -> {R.drawable.mona_lisa}
    }
    var displayDescription by remember {
        mutableStateOf(0)
    }
    val stringResource = when(displayDescription) {
        0 -> R.string.first_image
        1 -> R.string.second_image
        2 -> R.string.third_image
        3 -> R.string.forth_image
        4 -> R.string.fifth_image

        else -> {R.string.first_image}
    }
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
    )
    {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(0.35f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Surface(
                modifier=Modifier
                    .fillMaxHeight(0.65f)
                    .fillMaxWidth(1f)
                    .border(BorderStroke(3.dp,SolidColor(Color.White)), RectangleShape)
                    .shadow(15.dp, RectangleShape)
                    .align(alignment = Alignment.CenterHorizontally),
                shape= RoundedCornerShape(5.dp),
                shadowElevation=10.dp
            )
            {
                ArtworkImageFun(imageResource = imageResource,stringResource=stringResource)

            }
            Spacer(modifier = Modifier.height(20.dp))
            ArtworkContentFun(stringResource=stringResource)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
    ArtworkButtonsFun(displayImage = displayImage,
        displayDescription=displayDescription,
        displayMinus1={
            displayImage -= 1
            displayDescription -=1

        },
        displayEq3={
            displayImage = 3
            displayDescription =3

        },
        displayPlus1={
            displayImage += 1
            displayDescription +=1

        },
        displayEq0={
            displayImage = 0
            displayDescription =0

        },
    )
}
@Composable
fun ArtSpaceDisplayPortrait() {
    var displayImage by remember {
        mutableStateOf(0)
    }
    val imageResource = when(displayImage) {
        0 -> R.drawable.mona_lisa
        1 -> R.drawable.starry_night
        2 -> R.drawable.the_kiss
        3 -> R.drawable.composition_with_red_blue_and_yellow
        4 -> R.drawable.les_demoiselles_d_avignon

        else -> {R.drawable.mona_lisa}
    }
    var displayDescription by remember {
        mutableStateOf(0)
    }
    val stringResource = when(displayDescription) {
        0 -> R.string.first_image
        1 -> R.string.second_image
        2 -> R.string.third_image
        3 -> R.string.forth_image
        4 -> R.string.fifth_image

        else -> {R.string.first_image}
    }
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.65f)
                .fillMaxWidth(1f)
                .border(BorderStroke(3.dp, SolidColor(Color.White)), RectangleShape)
                .shadow(15.dp, RectangleShape)

                .align(alignment = Alignment.CenterHorizontally),
            shape = RoundedCornerShape(5.dp),
            shadowElevation = 10.dp
        ) {
            ArtworkImageFun(imageResource = imageResource,stringResource=stringResource)

        }
        Spacer(modifier = Modifier.height(60.dp))
        ArtworkContentFun(stringResource=stringResource)
        Spacer(modifier = Modifier.height(20.dp))
    }
    ArtworkButtonsFun(displayImage = displayImage,
        displayDescription=displayDescription,
        displayMinus1={
            displayImage -= 1
            displayDescription -=1

        },
        displayEq3={
            displayImage = 3
            displayDescription =3

        },
        displayPlus1={
            displayImage += 1
            displayDescription +=1

        },
        displayEq0={
            displayImage = 0
            displayDescription =0

        },
    )
}
@Composable
fun ArtworkImageFun(
    modifier:  Modifier = Modifier,
    @DrawableRes imageResource: Int,
    @StringRes stringResource: Int
)
{
    Image(
        painter = painterResource(
            imageResource,
        ),
        contentDescription = stringResource(
            stringResource,
        ),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(35.dp)
    )

}
@Composable
fun ArtworkContentFun(
    modifier: Modifier = Modifier,
    @StringRes stringResource: Int
)
{

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color(0xFFECEBF4)
    ) {

        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = stringResource(
                    stringResource,
                ),
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,

                )
            Row()
            {
                Text(
                    text = stringResource(
                        R.string.author,
                    ),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text =
                    "("
                        .plus(
                            stringResource(R.string.year)
                                .plus(")")
                        ),
                    fontSize = 14.sp,
                )
            }
        }
    }
}
@SuppressLint("ResourceType")
@Composable
fun ArtworkButtonsFun(
    modifier: Modifier = Modifier,
    @DrawableRes  displayImage: Int,
    @StringRes  displayDescription: Int,
    displayMinus1: (Int) -> Unit,
    displayEq3: (Int) ->Unit,
    displayPlus1: (Int) ->Unit,
    displayEq0: (Int) ->Unit,

    )

{
    Row(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom

    ) {
        Button(
            onClick = {
                if (displayImage != 0 && displayDescription != 0) {
                    displayMinus1(displayImage)

                } else if (displayImage == 0 && displayDescription == 0) {
                    displayEq3(displayImage)
                }
            },
            colors=ButtonDefaults.buttonColors(containerColor=Color(73, 93, 146)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.width(150.dp),
        ) {
            Text(
                text = "Previous",
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                if (displayImage <3 && displayDescription<3) {
                    displayPlus1(displayImage)

                } else if (displayImage == 3 && displayDescription == 3) {
                    displayEq0(displayImage)

                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(73, 93, 146)),

            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.width(150.dp)
        )
        {
            Text(
                text = "Next",
                color = Color.White
            )
        }

    }
}


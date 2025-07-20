package com.example.ladakh.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ladakh.DataSources.DataSources.extendedScreenItem
import com.example.ladakh.model.ExtendedScreenDatas
import com.example.ladakh.ui.theme.TopAppBar


data class ExtendedScreenItemWithHeight(
    val data: ExtendedScreenDatas,
    val height: Dp
)

@Composable
fun ExtendedScreen(
    modifier: Modifier,
    extendedScreenDatas: List<ExtendedScreenDatas>,
    onCardCliked: (Int) -> Unit
){
    val itemsWithHeights = mutableListOf<ExtendedScreenItemWithHeight>()
    var oddCount = 0
    var evenCount = 0

    for (item in extendedScreenDatas) {
        val isOdd = item.id % 2 != 0
        val height = if (isOdd) {
            if (oddCount % 2 == 0) 200.dp else 300.dp
        } else {
            if (evenCount % 2 == 0) 300.dp else 200.dp
        }

        if (isOdd) oddCount++ else evenCount++

        itemsWithHeights.add(
            ExtendedScreenItemWithHeight(data = item, height = height)
        )
    }

    //TopAppBar()
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        contentPadding = PaddingValues(24.dp),
        horizontalArrangement = Arrangement.spacedBy(25.dp),
        verticalItemSpacing = 20.dp
    ) {
        items(itemsWithHeights){ item ->

            extendedScreenCards(
                cardImageId = item.data.ImageId,
                height = item.height,
                cardText = item.data.name,
                cardDetials = item.data,
                onCardCliked = {onCardCliked(item.data.id)}
            )

        }
    }
}


@Composable
fun extendedScreenCards(
    cardImageId: Int,
    height: Dp,
    cardText: String,
    cardDetials:ExtendedScreenDatas,
    onCardCliked: (Int) -> Unit
){
    Box(
        modifier = Modifier
            .height(height)
            .fillMaxSize()
//            .border(
//                width = 0.dp,
//                color = Color.Black,
//                shape = RoundedCornerShape(16.dp)
//            )
            .clip(RoundedCornerShape(16.dp))
            .clickable { onCardCliked(cardDetials.id) }
    ) {
        Image(
            painter = painterResource(cardImageId),
            contentDescription = "Extended Box Image",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxHeight()
        )
        Text(
            text = cardText,
            color = Color.White,
            fontSize  = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}



@Preview
@Composable
fun EXtendedScreenPreview(){

    ExtendedScreen(
        modifier = Modifier,
        extendedScreenDatas = extendedScreenItem.values.flatten(),
        onCardCliked = {}
    )
}
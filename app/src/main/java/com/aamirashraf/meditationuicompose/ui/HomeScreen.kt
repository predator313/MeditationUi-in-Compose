package com.aamirashraf.meditationuicompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*  //or to set value or get value
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aamirashraf.meditationuicompose.R
import com.aamirashraf.meditationuicompose.ui.theme.ButtonBlue
import com.aamirashraf.meditationuicompose.ui.theme.DarkerButtonBlue
import com.aamirashraf.meditationuicompose.ui.theme.DeepBlue
import com.aamirashraf.meditationuicompose.ui.theme.TextWhite

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
    ){
        GreetingSection()
        ChipSection(chips = listOf("Sweet Sleep","Insomnia","Depression"))
        CurrentMeditation()
    }
}

@Composable
fun GreetingSection(
    name:String="James"
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween   //means one element is at left and one at right,
    ,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Good Morning $name",
            style = MaterialTheme.typography.headlineMedium)
            Text(text = "Wish you have a good day",
                style = MaterialTheme.typography.bodyLarge)
        }
        Icon(painter = painterResource(id = R.drawable.ic_search),
            contentDescription ="search",
            tint= Color.White,
            modifier=Modifier.size(24.dp)


        )
    }

}

@Composable
fun ChipSection(
    chips:List<String>
){
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow{
        items(chips.size){
            Box(
                contentAlignment=Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}
@Composable
fun CurrentMeditation(
    color: Color= Color.Red
){
    Row(
        verticalAlignment=Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()

    ){
        Column {
            Text(text = "Daily Thought",
                style = MaterialTheme.typography.headlineMedium)
            Text(text = "Wish you have a good day",
                style = MaterialTheme.typography.bodyLarge,
            color = TextWhite)
        }
        Box(
            contentAlignment=Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ){
            Icon(painter = painterResource(id = R.drawable.ic_play), contentDescription = "play",
            tint = Color.White,
            modifier = Modifier
                .size(16.dp)
            )
        }
    }
}
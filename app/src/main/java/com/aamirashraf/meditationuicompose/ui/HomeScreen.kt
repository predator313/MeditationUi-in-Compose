package com.aamirashraf.meditationuicompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
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

@Composable
fun HomeScreen(){

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
                modifier = Modifier
                    .padding(start = 15.dp,top=15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex=it
                    }
                    .clip(RoundedCornerShape(10.dp))
            ) {

            }
        }
    }
}
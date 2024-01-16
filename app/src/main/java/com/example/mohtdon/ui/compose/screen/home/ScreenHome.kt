package com.example.mohtdon.ui.compose.screen.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mohtdon.R
import com.example.mohtdon.navigation.NavigationHandler
import com.example.mohtdon.ui.compose.composable.MohtdonScaffold
import com.example.mohtdon.ui.compose.theme.Tajawal
import com.example.mohtdon.ui.compose.theme.color_GreenText
import com.example.mohtdon.ui.compose.theme.color_HomeRvItemColor1
import com.example.mohtdon.ui.compose.theme.color_HomeRvItemColor2
import com.example.mohtdon.ui.compose.theme.color_HomeRvItemColor3
import com.example.mohtdon.ui.compose.theme.color_HomeRvItemColor4
import com.example.mohtdon.ui.compose.theme.color_HomeRvItemColor5
import com.example.mohtdon.ui.compose.theme.color_HomeRvItemColor6
import com.example.mohtdon.ui.compose.theme.color_MainColor
import com.example.mohtdon.ui.compose.theme.color_OrangeText
import com.example.mohtdon.ui.compose.theme.color_White


@Composable
fun ScreenHome(
    screenHomeViewModel: ScreenHomeViewModel = hiltViewModel()
) {
    val state = screenHomeViewModel.state.collectAsState().value
    ScreenHomeContent(state = state, interaction = screenHomeViewModel)
    NavigationHandler(effects = screenHomeViewModel.effect) { effect, controller ->
        when (effect) {
            is HomeScreenUiEffect.NavigateUp -> {
                controller.popBackStack()
            }

            is HomeScreenUiEffect.NavigateToAzkar -> {

            }

            is HomeScreenUiEffect.NavigateToDuaa -> {

            }

            is HomeScreenUiEffect.NavigateToHadith -> {

            }

            is HomeScreenUiEffect.NavigateToMenu -> {

            }

            is HomeScreenUiEffect.NavigateToMore -> {

            }

            is HomeScreenUiEffect.NavigateToMoreAya -> {

            }

            is HomeScreenUiEffect.NavigateToMoreAzkar -> {

            }

            is HomeScreenUiEffect.NavigateToMoreDuaa -> {

            }

            is HomeScreenUiEffect.NavigateToMoshaf -> {

            }

            is HomeScreenUiEffect.NavigateToPrayerFollowing -> {

            }

            is HomeScreenUiEffect.NavigateToTafseer -> {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHomeContent(
    state: HomeUiState,
    interaction: HomeScreenInteraction
) {
    MohtdonScaffold(
        isLoading = false, isError = false,
        topAppbar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color_MainColor)
                    .height(72.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.logo),
                    fontFamily = Tajawal,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center),
                    color = color_White
                )
                Icon(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .rotate(90f)
                        .align(Alignment.CenterStart)
                        .clickable { interaction.onClickMenu() },
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = "",
                    tint = color_White
                )
            }
        }
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 72.dp, bottom = 64.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.welcome),
                    fontFamily = Tajawal,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    color = color_OrangeText,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Text(
                    text = state.todayDate,
                    fontFamily = Tajawal,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start,
                    color = color_GreenText,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(state.homeItems) {
                        Column(
                            verticalArrangement = Arrangement.SpaceAround,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier.size(75.dp),
                                onClick = { interaction.onClickHomeRowItem(it.id) },
                                colors = CardDefaults.cardColors(
                                    containerColor = it.cardColor,
                                    contentColor = color_White
                                )
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        modifier = Modifier.size(36.dp),
                                        painter = painterResource(id = it.icon),
                                        contentDescription = "",
                                        tint = color_White
                                    )
                                }
                            }
                            Text(
                                modifier = Modifier.padding(top = 8.dp),
                                text = stringResource(id = it.label),
                                fontFamily = Tajawal,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start,
                                color = color_GreenText
                            )
                        }
                    }
                }
            }
        }
    }
}

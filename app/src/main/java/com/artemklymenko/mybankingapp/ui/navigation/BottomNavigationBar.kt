package com.artemklymenko.mybankingapp.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.artemklymenko.mybankingapp.data.BottomNavigation
import com.artemklymenko.mybankingapp.ui.screens.analytics.FinanceAnalyticsScreen
import com.artemklymenko.mybankingapp.ui.screens.charity.CharityScreen
import com.artemklymenko.mybankingapp.ui.screens.home.HomeScreen
import com.artemklymenko.mybankingapp.ui.screens.notifications.NotificationScreen
import com.artemklymenko.mybankingapp.ui.screens.phone.MobileTopUpScreen
import com.artemklymenko.mybankingapp.ui.screens.profile.ProfileScreen
import com.artemklymenko.mybankingapp.ui.screens.transactions.MyTransactionsScreen
import com.artemklymenko.mybankingapp.ui.screens.wallet.WalletScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<BottomNavigation>
) {
    var showNotificationBadge by remember { mutableStateOf(items[2].hasNews) }
    var showProfileBadge by remember { mutableStateOf(items[2].hasNews) }
    Scaffold(bottomBar = { TabView(items, navController, showNotificationBadge, showProfileBadge) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            NavHost(navController = navController, startDestination = items[0].title) {
                composable(items[0].title) {
                    HomeScreen(navController)
                }
                composable(items[1].title) {
                    WalletScreen()
                }
                composable(items[2].title) {
                    NotificationScreen()
                    showNotificationBadge = false
                }
                composable(items[3].title) {
                    ProfileScreen()
                    showProfileBadge = false
                }
                composable("financeAnalyticsScreen") {
                    FinanceAnalyticsScreen()
                }
                composable("charityScreen") {
                    CharityScreen()
                }
                composable("mobileTopUp") {
                    MobileTopUpScreen()
                }
                composable("myTransactions") {
                    MyTransactionsScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabView(
    tabBarItems: List<BottomNavigation>,
    navController: NavHostController,
    showNotificationBadge: Boolean,
    showProfileBadge: Boolean
) {
    var selectedTabIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar {
        tabBarItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    navController.navigate(item.title)
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if(item.badgeCount != null && showNotificationBadge && item.hasNews){
                                Badge(
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .offset(x = 18.dp, y = (-1).dp),
                                ){
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if(item.hasNews && showProfileBadge && item.badgeCount == null){
                                Badge(
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .offset(x = 18.dp, y = (-1).dp),
                                )
                            }
                        }
                    ) {

                    }
                    Icon(
                        imageVector = if (selectedTabIndex == index) {
                            item.icon
                        } else item.unselected, contentDescription = item.title
                    ) },
                label = { Text(text = item.title)}
            )
        }
    }
}


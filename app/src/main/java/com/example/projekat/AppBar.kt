package com.example.projekat



import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share

@Composable
    fun AppBar(
        onNavigationIconClick: () -> Unit,
        onShareClicked: () -> Unit
    ) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },

            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary,
            navigationIcon = {
                IconButton(onClick = onNavigationIconClick) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Toggle drawer"
                    )
                }

                    IconButton(
                        onClick = { onShareClicked.invoke() },
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share"
                        )
                    }
                }


        )

    }




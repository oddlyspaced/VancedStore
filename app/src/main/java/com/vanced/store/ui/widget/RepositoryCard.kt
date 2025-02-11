package com.vanced.store.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vanced.store.R
import com.vanced.store.ui.component.VSElevatedCard
import com.vanced.store.ui.theme.VSTheme

@Composable
fun RepositoryCardLoaded(
    onRemove: () -> Unit,
    name: String,
    modifier: Modifier = Modifier,
) {
    RepositoryCard(
        modifier = modifier,
        title = { Text(name) },
        trailing = {
            IconButton(onClick = onRemove) {
                Icon(
                    painter = painterResource(R.drawable.ic_remove_circle),
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun RepositoryCardLoading(
    modifier: Modifier = Modifier,
) {
    RepositoryCard(
        modifier = modifier,
        title = {
            PlaceholderBox(
                modifier = Modifier
                    .height(24.dp)
                    .fillMaxWidth(0.6f)
            )
        },
        trailing = {
            PlaceholderBox(
                modifier = Modifier.size(24.dp)
            )
        }
    )
}

@Composable
private fun RepositoryCard(
    title: @Composable () -> Unit,
    trailing: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    VSElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(VSTheme.spacing.innerLarge),
            horizontalArrangement = Arrangement.spacedBy(VSTheme.spacing.innerLarge)
        ) {
            Box(modifier = Modifier.weight(1f)) {
                ProvideTextStyle(VSTheme.typography.titleMedium) {
                    title()
                }
            }
            trailing()
        }
    }
}
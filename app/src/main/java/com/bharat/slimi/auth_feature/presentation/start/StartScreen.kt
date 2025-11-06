package com.bharat.slimi.auth_feature.presentation.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import com.bharat.slimi.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun StartScreen(
    onRegisterClick : () -> Unit,
) {

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(horizontal = 24.dp),
             verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically)
        ) {

            Button(
                onClick = onRegisterClick,
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text("Register")
            }

            //AuthButton
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .border(1.dp, Color.LightGray, RoundedCornerShape(24.dp))
                    .background(Color.White)
                    .clickable{}
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ){

                Image(
                    painterResource(R.drawable.google_icon_button),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterStart).fillMaxHeight().aspectRatio(1f)
                )

                Text("Login With Google")
            }


        }

    }

}
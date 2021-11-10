package com.devcrew.jetpackcompose.presentation.ui.myplant

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.devcrew.jetpackcompose.R

@ExperimentalComposeUiApi
@Composable
fun AddPlantDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    name: String,
    onNameChange: (String) -> Unit,
    desc: String,
    onDescChange: (String) -> Unit,
    onValidate: () -> Unit
) {
    if (showDialog) {
        val context = LocalContext.current
        AlertDialog(
            properties = DialogProperties(usePlatformDefaultWidth = true),
            text = {
                Column(modifier = Modifier.wrapContentHeight()) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        text = stringResource(id = R.string.str_add_plant),
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .background(color = Color.White)
                            .padding(top = 8.dp)
                            .height(60.dp),
                        value = name,
                        onValueChange = onNameChange,
                        label = { Text("Name") }
                    )

                    OutlinedTextField(
                        modifier = Modifier
                            .background(color = Color.White)
                            .padding(top = 8.dp)
                            .height(60.dp),
                        value = desc,
                        onValueChange = onDescChange,
                        label = { Text("Description") }
                    )
                }
            },
            onDismissRequest = onDismiss,
            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.color_primary),
                        contentColor = Color.White
                    ),
                    onClick = {
                        if (name.isBlank()) {
                            Toast.makeText(context, "Empty Name Not Allowed", Toast.LENGTH_SHORT)
                                .show()
                            return@Button
                        }

                        if (desc.isBlank()) {
                            Toast.makeText(
                                context,
                                "Empty Description Not Allowed",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            return@Button
                        }

                        onValidate()
                        onDismiss()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
                ) {
                    Text(stringResource(id = R.string.str_save))
                }
            },
            dismissButton = {}
        )
    }
}

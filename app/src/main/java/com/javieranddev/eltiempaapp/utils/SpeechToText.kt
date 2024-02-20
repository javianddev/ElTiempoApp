package com.javieranddev.eltiempaapp.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.ui.platform.LocalContext
import java.util.Locale

class SpeechToText(private val context: Context): ActivityResultContract<Unit, ArrayList<String>?>(){

    override fun createIntent(context: Context, input: Unit): Intent {

        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, Constants.SPEECH_TEXT_SEARCHBAR)

        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): ArrayList<String>? {

        if (resultCode != Activity.RESULT_OK){
            Toast.makeText(context, Constants.SPEECH_TEXT_NO_AVAILABLE, Toast.LENGTH_SHORT).show()
        }

        return intent?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
    }




}


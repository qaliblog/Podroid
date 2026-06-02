package com.excp.podroid.util

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns

object UriUtils {
    fun getDisplayName(context: Context, uri: Uri): String? {
        return runCatching {
            context.contentResolver.query(
                uri, arrayOf(OpenableColumns.DISPLAY_NAME), null, null, null
            )?.use { cursor ->
                if (cursor.moveToFirst()) cursor.getString(0) else null
            }
        }.getOrNull() ?: uri.path?.substringAfterLast('/')
    }
}

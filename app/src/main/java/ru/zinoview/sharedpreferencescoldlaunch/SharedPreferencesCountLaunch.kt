package ru.zinoview.sharedpreferencescoldlaunch

import android.content.Context

interface SharedPreferencesCountLaunch {

    fun launched()

    fun read() : Int

    fun isShow() : Boolean

    class Base(
        context: Context
    ) : SharedPreferencesCountLaunch {
        private val preferences = context.getSharedPreferences(LAUNCH_COUNT_NAME,Context.MODE_PRIVATE)

        override fun launched() {
            val newLaunchedCount =  read() + 1
            preferences.edit().putInt(LAUNCH_COUNT_KEY,newLaunchedCount).apply()
        }

        override fun read() = preferences.getInt(LAUNCH_COUNT_KEY,DEFAULT)

        override fun isShow() = read() == MAX_LAUNCH

        private companion object {
            private const val LAUNCH_COUNT_NAME = "launchCountPrefs"
            private const val LAUNCH_COUNT_KEY = "launchCountKey"

            private const val MAX_LAUNCH = 2

            private const val DEFAULT = 0
        }
    }
}
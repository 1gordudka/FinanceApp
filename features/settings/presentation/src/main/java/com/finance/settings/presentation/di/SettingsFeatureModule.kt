package com.finance.settings.presentation.di

import com.finance.settings.data.di.SettingsDataModule
import dagger.Module

@Module(includes = [SettingsDataModule::class])
class SettingsFeatureModule

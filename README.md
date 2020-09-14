# Stootie App
> This is an android application for evaluation purpose only! It is mainly about displaying the whole world countries with search feature and showing each country's details and information.

## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#Technologies)
* [Setup](#Setup)
* [Features](#features)
* [Status](#Status)
* [Inspiration](#Inspiration)
* [Contact](#Contact)

## General info
This is an Android app that works on most of Android OS running terminals. It allows user to display the countries details and general information.

## Screenshots
![Example screenshot](./screenshots/countriesList.png)(./screenshots/countryDetail.png)

## Technologies
* KOTLIN - version 1.0
* RxJava 2 - version 2.0
* Dagger2 - version 2.21
* GlideToVectorYou - version 2.0
* Retrofit - version 2.6.0
* JUnit - version 4.12
* Powermock - version 1.7.1
* Mockito - version 2.8.9
* Dagger2 - version 3.0
* Espresso - version 3.1.0-alpha4


## Setup
* Install Android Studio version 3+
* Install JDK and necessary SDKs versions
* Get project from version Control Github


## Code Examples
` override fun getFilter(): Filter {
         return object : Filter() {
             override fun performFiltering(p0: CharSequence?): FilterResults {
                 filtredListofCountries = if (p0.isNullOrEmpty())
                     countries
                 else {
                     resultListOfSearch.clear()
                     countries.forEach {
                         if (it.name.toString().toLowerCase().contains(p0.toString()))
                             resultListOfSearch.add(it)
                     }
                     resultListOfSearch
                 }
                 var filtredResult = FilterResults()
                 filtredResult.values = filtredListofCountries
                 return filtredResult
             }

             override fun publishResults(p0: CharSequence?, filtredResult: FilterResults?) {
                 filtredListofCountries = listOf()
                 filtredListofCountries = filtredResult!!.values as List<Country>
                 notifyDataSetChanged()
             }
         }`


To-do list:
* improve Search feature
* implement paging feature when scrolling the countries list

## Status
Project is: Finished

## Inspiration
This app is inspired by the new Google UI/UX recommendations and best practices

## Contact
Created by Iheb SAHLOUL
           ihebsahloul@hotmail.fr/isahloul@gmail.com
           (Tunisia): (+216) 28 796 295
           (France):  (+33) 977 215 250
           https://www.linkedin.com/in/iheb-sahloul-6b2b41aa/
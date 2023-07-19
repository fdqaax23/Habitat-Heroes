// Package declaration
package com.example.habitat_heroes

// Basic Imports
import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

// Class Definition
class HabitatHeroes : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.habitat_heroes_layout)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.habitat_heroes, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

// Methods 
    private fun createHero(){
        // Code for creating a new hero
    }

    private fun deleteHero(){
        // Code for deleting a hero
    }

    private fun updateHero(){
        // Code for updating a hero
    }

    private fun displayHero(){
        // code for displaying a hero
    }

    private fun saveHeroes(){
        // code for saving the heroes
    }

    private fun loadHeroes(){
        // code for loading the heroes
    }

    private fun createMission(){
        // code for creating a new mission
    }

    private fun deleteMission(){
        // code for deleting a mission
    }

    private fun updateMission(){
        // code for updating a mission
    }

    private fun displayMission(){
        // code for displaying a mission 
    }

    private fun saveMissions(){
        // code for saving the missions
    }

    private fun loadMissions(){
        // code for loading the missions
    }

    private fun createPowerUp(){
        // code for creating a new power up
    }

    private fun deletePowerUp(){
        // code for deleting a power up
    }

    private fun updatePowerUp(){
        // code for updating a power up
    }

    private fun displayPowerUp(){
        // code for displaying a power up
    }

    private fun savePowerUps(){
        // code for saving the power ups
    }

    private fun loadPowerUps(){
        // code for loading the power ups
    }

    private fun startMission(){
        // code for starting a mission
    }

    private fun completeMission(){
        // code for completing a mission
    }

    private function usePowerUp(){
        // code for using a power up
    }

    private function getReward(){
        // code for getting a reward
    }

    private function checkAchievement(){
        // code for checking an achievement
    }

}
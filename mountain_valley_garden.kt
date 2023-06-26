// MainActivity.kt
package com.mycompany.habitatheroes

import android.app.Activity
import android.os.Bundle
import android.util.Log

// Main Activity of the Habitat Hero game
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "Game is starting")

        // create a new instance of the Game
        val game = Game(this)

        // load the initial level
        game.loadLevel(1)
    }
}

// Game.kt
package com.mycompany.habitatheroes

import android.content.Context
import android.util.Log

// Game class for Habitat Heroes game
class Game(context: Context) {

    private val context = context
    private var level: Level? = null

    // load the given level
    fun loadLevel(num: Int) {
        level = Level(context, num)
    }

    // start the game
    fun start() {
        Log.d("Game.start", "Starting level " + level?.levelNum)
        level?.start()
    }
}

// Level.kt
package com.mycompany.habitatheroes

import android.content.Context
import android.util.Log

// Level class for Habitat Heroes game
class Level(context: Context, var levelNum: Int) {

    private val context = context
    private var hero: Hero? = null

    // create a new hero
    fun createHero() {
        hero = Hero(context, levelNum)
    }

    // start the level
    fun start() {
        Log.d("Level.start", "Starting level " + levelNum)

        // create the hero
        createHero()

        // start the hero
        hero?.start()
    }
}

// Hero.kt
package com.mycompany.habitatheroes

import android.content.Context
import android.util.Log

// Hero class for Habitat Heroes game
class Hero(context: Context, levelNum: Int) {

    private val context = context
    private var levelNum = levelNum
    private var score = 0

    // start the hero
    fun start() {
        Log.d("Hero.start", "Starting level " + levelNum)
    }

    // move the hero
    fun move() {
        Log.d("Hero.move", "Moving hero")
    }

    // collect an item
    fun collect(item: Item) {
        Log.d("Hero.collect", "Collecting item")

        // increase the score
        score += item.value
    }

}

// Item.kt
package com.mycompany.habitatheroes

import android.util.Log

// Item class for Habitat Heroes game
class Item {

    val value = 10
    val type = "item"

    // activate the item
    fun activate() {
        Log.d("Item.activate", "Activating item")
    }
}

// Obstacle.kt
package com.mycompany.habitatheroes

import android.util.Log

// Obstacle class for Habitat Heroes game
class Obstacle {

    val type = "obstacle"

    // move the obstacle
    fun move() {
        Log.d("Obstacle.move", "Moving obstacle")
    }
}
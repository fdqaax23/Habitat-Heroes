//Imports
import java.util.*
import android.animation.*
import android.app.Activity
import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

//Main class of the game
class HabitatHeroes : Activity() {
    lateinit var gameView : GameView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameView = GameView(this)
        setContentView(gameView)
    }
    override fun onPause() {
        super.onPause()
        gameView.pause()
    }
    override fun onResume() {
        super.onResume()
        gameView.resume()
    }
    class GameView(context: Context) : SurfaceView(context), Runnable {
        private var thread : Thread? = null
        private var surfaceHolder : SurfaceHolder = holder
        private var scoreTextView : TextView? = null
        private var lifeTextView : TextView? = null
        private var levelTextView : TextView? = null
        private var playing : Boolean = false
        private var canvas : Canvas? = null
        private val paint : Paint = Paint()
        private var fps : Long = 0
        private var score : Int = 0
        private var life : Int = 10
        private var level : Int = 1
        private var background : Bitmap? = null
        private var character : Character? = null
        private var obstacles : ArrayList<Obstacle> = ArrayList()
        private var goals : ArrayList<Goal> = ArrayList()
        private var stage : Stage? = null
        private var isGameOver : Boolean = false

//Setting up of View, SurfaceHolder and scoreTextView
        init {
            scoreTextView = findViewById(R.id.scoreTextView)
            lifeTextView = findViewById(R.id.lifeTextView)
            levelTextView = findViewById(R.id.levelTextView)
        }

//Game View run Method
        override fun run() {
            while (playing) {
                val startTime = System.nanoTime()
                update()
                draw()
                control()
                val endTime = System.nanoTime()
                val deltaTime = (endTime - startTime) / 1000000
                if (deltaTime < 17) {
                    try {
                        Thread.sleep(17 - deltaTime)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
        }

//Game View pause and resume methods
        fun pause() {
            playing = false
            try {
                thread!!.join()
            } catch (e: InterruptedException) {
                e.printStackTrace()
                Log.e("Error:", "joining thread")
            }
        }
        fun resume() {
            playing = true
            thread = Thread(this)
            thread!!.start()
        }

//Game View draw and update methods
        private fun update() {
            character!!.update()
            for (obstacle in obstacles) {
                obstacle.update()
            }
            for (goal in goals) {
                goal.update()
            }
            checkCollisions()
        }
        private fun draw() {
            if (surfaceHolder.surface.isValid) {
                canvas = surfaceHolder.lockCanvas()
                canvas!!.drawColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
                canvas!!.drawBitmap(background!!, 0f, 0f, paint)
                character!!.draw(canvas!!, paint)
                for (obstacle in obstacles) {
                    obstacle.draw(canvas!!, paint)
                }
                for (goal in goals) {
                    goal.draw(canvas!!, paint)
                }
                drawText(canvas!!, paint)
                surfaceHolder.unlockCanvasAndPost(canvas!!)
            }
        }

//Game View checkCollisions methods
        private fun checkCollisions() {
            for (obstacle in obstacles) {
                if (character!!.rect.intersect(obstacle.rect)) {
                    life--
                    if (life == 0) {
                        playing = false
                        isGameOver = true
                    }
                }
            }
            for (goal in goals) {
                if (character!!.rect.intersect(goal.rect)) {
                    score += 10
                    // Check if we reached the end of the level
                    if (goals.size == 0) {
                        level++
                        loadNewLevel()
                    }
                }
            }
        }

//Game View drawText methods
        private fun drawText(canvas: Canvas, paint: Paint) {
            paint.color = ContextCompat.getColor(context, R.color.colorAccent)
            paint.textSize = 40f
            canvas.drawText("Score: " + score, 20f, 40f, paint)
            canvas.drawText("Life: " + life, 20f, 80f, paint)
            canvas.drawText("Level: " + level, 20f, 120f, paint)
        }

//Game View loadNewLevel methods
        private fun loadNewLevel() {
            goals.clear()
            obstacles.clear()
            background = BitmapFactory.decodeResource(resources, stage!!.background)
            for (goal in stage!!.goals) {
                goals.add(Goal(context, goal.x, goal.y))
            }
            for (obstacle in stage!!.obstacles) {
                obstacles.add(Obstacle(context, obstacle.x, obstacle.y))
            }
            character!!.setStartingPosition(stage!!.startingX, stage!!.startingY)
        }

//Game View control methods
        private fun control() {
            try {
                fps = (1000 / (System.nanoTime() - fps))
            } catch (e: ArithmeticException) {
                Log.e("Error:", "divide by zero")
            }
        }

//Game View onTouchEvent methods
        override fun onTouchEvent(motionEvent: MotionEvent): Boolean {
            when (motionEvent.action and MotionEvent.ACTION_MASK) {
                MotionEvent.ACTION_DOWN -> {
                    if (isGameOver) {
                        score = 0
                        life = 10
                        level = 1
                        playing = true
                        isGameOver = false
                        thread = Thread(this)
                        thread!!.start()
                    }
                    character!!.handleActionDown(motionEvent.x, motionEvent.y)
                }
                MotionEvent.ACTION_MOVE -> {
                    character!!.handleActionMove(motionEvent.x, motionEvent.y)
                }
                MotionEvent.ACTION_UP -> {
                    character!!.handleActionUp()
                }
            }
            return true
        }
    }
}
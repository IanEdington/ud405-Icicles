# Final project in the Java game dev course
https://www.udacity.com/course/2d-game-development-with-libgdx--ud405

## 1.7.01 Create the Icicles Project
LibGDX provides a super convenient project setup utility for setting up a fresh project. We actually included it at the root of the course code (and in this folder), it's called gdx-setup.jar. You can download the setup app by navigating to https://libgdx.badlogicgames.com/, clicking the download tap, and clicking "Download Setup App".

- [x] The Setup App wants a Name, we'll use "Icicles". For the package, we've used "com.udacity.gamedev.icicles". For the Game class: "IciclesGame".
- [x] Next, the app needs the location where you've installed the Android SDK, or software development kit. You installed this when you installed Android Studio. If you don't remember where it is, you can open up Android Studio's preferences, and search for "SDK". Under Appearance & Behavior > System Settings > Android SDK, you'll find the Android SDK location.
- [x] Select the version of LibGDX you want to use, which is generally the latest version. Then you need to decide what subprojects you want to include. Unless you're using an extension that is incompatible with some of the subprojects, just include them all. It's easier to remove a subproject than to add one later.
- [x] Finally, you can include various extensions. Box2d is selected by default. It's an awesome 2D physics engine that we'll be using in a later course. Uncheck it for now, though.
- [x] Finally, hit Generate!

When the project Generator is done, we can open up our newly created project in Android Studio, and run it, just like we learned back in Level 1-2. We've got a red screen, and the BadLogic logo! Awesome! Now you can create whatever new projects you want, and don't have to rely on the starter code in the course repository.

## 1.7.02 Add Stub Classes
We just used the LibGDX project setup utility to create a fresh project. Now let's start to create the classes we'll need for Icicles.

We need the following classes:

- [x] IciclesGame: Subclass of Game
- [x] IciclesScreen: Implements Screen
- [x] DifficultyScreen: Implements Screen
- [x] Player, Icicles, Icicle, and Constants: just plain old Java classes

## 1.7.03 The First Icicle
In this exercise you'll set up and draw the first icicle. There are very detailed TODOs for this segment, as there's a lot of moving parts. Later on you'll be left more to your own devices.

We recommend completing the TODOs working through the files in the following order

1. Constants
    - [x] Add a constant for the world size
    - [x] Add a constant for the background color of the world
    - [x] Add a constant for the height of the icicle
    - [x] Add a constant for the width of the icicle
    - [x] Add a constant for the color of the icicles
2. Icicle
    - [x] Add a Vector2 position
    - [x] Add a constructor that sets the position
    - [x] Add a render function that takes a ShapeRenderer
    - [x] Set the ShapeRenderer's color
    - [x] Set the ShapeType
    - [x] Draw the icicle using the size constants
3. IciclesScreen
    - definitions
        - [x] Add an ExtendViewport
        - [x] Add a ShapeRenderer
        - [x] Add an Icicle
    - show()
        - [x] Initialize the viewport using the world size constant
        - [x] Initialize the ShapeRenderer
        - [x] Set autoShapeType(true) on the ShapeRenderer
        - [x] Create a new Icicle in the middle of the world
    - resize()
        - [x] Ensure that the viewport updates correctly
    - render()
        - [x] Apply the viewport
        - [x] Clear the screen to the background color
        - [x] Set the ShapeRenderer's projection matrix
        - [x] Draw the Icicle
    - hide()
        - [x] Dispose of the ShapeRenderer
4. IciclesGame
    - create()
        - [x] call setScreen() with a new IciclesScreen()

## 1.7.04 The Player
In this exercise, you'll add the player! We recommend completing the TODOs working through the files in the following order

1. Constants
    - [x] Add constant for player head radius
    - [x] Add constant for player head height
    - [x] Add constant for player limb width
    - [x] Add constant for circle segments for the player's head
    - [x] Add constant for the player's color
2. Player
    - [x] Add a position (add constants to Constants.java first)
    - [x] Add a viewport
    - [x] Add constructor that accepts and sets the viewport, then calls init()
    - [x] Add init() function that moves the character to the bottom center of the screen
    - [x] Create a render function that accepts a ShapeRenderer and does the actual drawing
3. IciclesScreen
    - definitions
    - [x] Add a Player (complete Player.java first)
    - show()
        - [x] Initialize the player
    - resize()
        - [x] Reset the player (using init())
    - render()
        - [x] Call render() on the player

## 1.7.05 Arrow Key Controls
In this exercise, you'll add control of the player! We recommend completing the TODOs working through the files in the following order

1. Constants
    - [x] Add Constant for player movement speed
2. Player
    - update()
        - [x] Use Gdx.input.isKeyPressed() to move the player in the appropriate direction when an arrow key is pressed
    - ensureInBounds()
        - [x] Complete this function to ensure the player is within the viewport
3. IciclesScreen
    - render()
        - [x] Call update() on player

## 1.7.06 Accelerometer Controls
In this exercise, you will set up accelerometer controls!

1. Constants
    - [ ] Add constant for Accelerometer sensitivity
    - [ ] Add constant for acceleration due to gravity (9.8)
2. Player
    - update()
        - [ ] Compute accelerometer input = raw input / (gravity * sensitivity)
        - [ ] Use the accelerometer input to move the player

## 1.7.07 Add the Icicles

1. Constants
    - [x] Add constant for icicle acceleration
    - [x] Add constant for icicle spawns per second
2. Icicle
    - [x] Add Vector2 for velocity
    - Icicle()
        - [x] Initialize velocity
    - Update()
        - [x] Update velocity using icicle accelration constant
        - [x] Update position using velocity
3. Icicles
    - [x] Add an array of icicles and a viewport
    - init()
        - [x] Initialize the array of icicles
    - update()
        - [x] Replace hard-coded spawn rate with a constant
        - [x] Randomly add new icicles `if (MathUtils.random() < delta * 5) {`
        - [x] Add a new icicle at the top of the viewport at a random x position
        - [x] Update each icicle
    - render()
        - [x] Set ShapeRenderer Color
        - [x] Render each icicle
4. IciclesScreen
    - [x] Add an instance of Icicles
    - show()
        - [x] Initialize icicles
    - resize()
        - [x] Reset icicles
    - render()
        - [x] Update Icicles
        - [x] Render Icicles

## 1.7.08 Remove Stale Icicles

1. Icicles
    - [x] Use a DelayedRemovalArray to hold our icicles
    - init()
        - [x] Initialize the DelayedRemovalArray
    - update()
        - [x] begin a removal session
        - [x] Remove any icicle completely off the bottom of the screen
        - [x] End removal session

## 1.8.01 Icicle Head Collision Detection
1. Player
    - render()
        - [x] Check if the player was hit by an icicle. If so, reset the icicles.
2. IciclesScreen
    - hitByIcicle()
        - [x] Loop over icicles, checking if the point of any icicle is within the player's head

## 1.8.02 Add The HUD
1. Constants
    - [ ] Add screen reference size for scaling the HUD (480 works well)
    - [ ] Add constant for the margin between the HUD and screen edge
2. Icicles
    - [ ] Add counter for how many icicles have been dodged
    - init()
        - [ ] Set icicles dodged count to zero
    - update()
        - [ ] Increment count of icicles dodged
3. IciclesScreen
    - [ ] Add ScreenViewport for HUD
    - [ ] Add SpriteBatch
    - [ ] Add BitmapFont
    - [ ] Add int to hold the top score
    - show()
        - [ ] Initialize the HUD viewport
        - [ ] Initialize the SpriteBatch
        - [ ] Initialize the BitmapFont
        - [ ] Give the font a linear TextureFilter
        - [ ] Set top score to zero
    - resize()
        - [ ] Update HUD viewport
        - [ ] Set font scale to min(width, height) / reference screen size
    - dispose()
        - [ ] Dispose of the SpriteBatch and font
    - render()
        - [ ] Set the top score to max(topScore, iciclesDodges)
        - [ ] Apply the HUD viewport
        - [ ] Set the SpriteBatch's projection matrix
        - [ ] Begin the SpriteBatch
        - [ ] Draw the number of player deaths in the top left
        - [ ] Draw the score and top score in the top right
        - [ ] End the SpriteBatch
3. Player
    - [ ] Add counter for number of deaths
    - Player()
        - [ ] Set number of deaths to zero
    - hitByIcicle()
        - [ ] If the player was hit, increment death counter

## 1.8.03 Add Difficultly Levels
1. Constants
    - [ ] Create constants for difficulty labels ("Cold", "Colder", "Coldest")
    - [ ] Create constants for the icicle spawn rates for the various difficulties
    - [ ] Create Difficulty enum holding the spawn rate and label for each difficulty
2. Icicles
    - [ ] Add a Difficulty
    - constructor
        - [ ] Accept a difficulty in the constructor
        - [ ] Set difficulty
    - update()
        - [ ] Use the difficulty's spawn rate
3. IciclesGame
    - create()
        - [ ] Create IciclesScreen with a Difficulty
4. IciclesScreen
    - [ ] Add Difficulty
    - constructor
        - [ ] Accept a Difficulty in the constructor
        - [ ] Set Difficulty
    - show()
        - [ ] Initialize icicles with the difficulty
    - render()
        - [ ] Show Difficulty level in the top left

## 1.8.04 Add Difficulty Select Screen
1. Constants.java
    - [ ] Add constants for the color of each difficulty select circle
    - [ ] Add constant for the size of the difficulty world
    - [ ] Add constant for the radius of the difficulty select "buttons"
    - [ ] Add constant for the scale of the difficulty labels (1.5 works well)
    - [ ] Add Vector2 constants for the centers of the difficulty select buttons
2. DifficultyScreen.java
    - show()
        - [ ] Initialize a FitViewport with the difficulty world size constant
        - [ ] Set the font scale using the constant we defined
    - render()
        - [ ] Apply the viewport
        - [ ] Set the ShapeRenderer's projection matrix
        - [ ] Use ShapeRenderer to draw the buttons
        - [ ] Set the SpriteBatche's projection matrix
        - [ ] Use SpriteBatch to draw the labels on the buttons
            - HINT: Use GlyphLayout to get vertical centering
    - resize()
        - [ ] Update the viewport
    - touchDown()
        - [ ] Unproject the touch from the screen to the world
        - [ ] Check if the touch was inside a button, and launch the icicles screen with the appropriate difficulty
3. IciclesGame.java
    - showDifficultyScreen
        - [ ] Show the difficulty screen
    - showIciclesScreen()
        - [ ] Show the Icicles screen with the appropriate difficulty
4. IciclesScreen
    - [ ] Add IciclesGame member variable
    - constructor
        - [ ] Accept IciclesGame in the constructor
        - [ ] Save the IciclesGame
    - touchDown
        - [ ] Tell IciclesGame to show the difficulty screen

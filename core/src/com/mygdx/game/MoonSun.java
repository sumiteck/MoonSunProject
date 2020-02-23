package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class MoonSun extends ApplicationAdapter {
	SpriteBatch batch;
	Actions actions;
	Texture[] bg;
	Texture moon;
	Texture sun;

	int changeState = 0;
	float velocity = 0;
	int gameState = 0;
	float moonWalk =0;
	float sunWalk =0;
	float day;

	
	@Override
	public void create () {

		batch = new SpriteBatch();
		actions = new Actions();

		moon = new Texture("moon.png");
		sun = new Texture("sun.png");
		bg = new Texture[2];
		bg[0] = new Texture("nightbg.jpg");
		bg[1] =new Texture("bg.png");
		moonWalk = Gdx.graphics.getWidth() / 4 - moon.getWidth()/2;
		sunWalk = -Gdx.graphics.getWidth()- Gdx.graphics.getWidth() / 4 - sun.getWidth()/2;
		day = Gdx.graphics.getWidth()+ Gdx.graphics.getWidth() / 4 - sun.getWidth()/2;

	}

	@Override
	public void render () {

        batch.begin();

        batch.draw(bg[changeState], 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //batch.draw(nightbg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(moon, moonWalk, Gdx.graphics.getHeight() / 2 + 200);
        batch.draw(sun, sunWalk, Gdx.graphics.getHeight() / 2 + 200);

        batch.end();

        if (gameState != 0) {
            if (Gdx.input.justTouched()) {
                Gdx.app.log("Screen Touched", "Yes");
                velocity = -5;
            }
            if (sunWalk < 0 ) {
                moonWalk -= velocity;
                sunWalk -= velocity;


            }
            if(moonWalk == day ){
            	changeState = 1;
			}


        } else {
            gameState = 1;

        }

		/*if (flapstate == 0) {
			flapstate = 1;
		} else {
			flapstate = 0;
		}
	}*/
    }
	@Override
	public void dispose () {

	}
}

package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MoonSun extends ApplicationAdapter {
	SpriteBatch batch;
	Texture nightbg;
	Texture moon;
	Texture sun;
	float velocity = 0;
	int gameState = 0;
	float moonWalk =0;
	float sunWalk =0;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		nightbg = new Texture("nightbg.jpg");
		moon = new Texture("moon.png");
		sun = new Texture("sun.png");
		moonWalk = Gdx.graphics.getWidth() / 4 - moon.getWidth()/2;
		sunWalk = -Gdx.graphics.getWidth()- Gdx.graphics.getWidth() / 4 - sun.getWidth()/2;

	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(nightbg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(moon, moonWalk, Gdx.graphics.getHeight() / 2 + 200);
		batch.draw(sun, sunWalk, Gdx.graphics.getHeight() / 2 + 200);
		batch.end();

		if (gameState != 0) {
			if (Gdx.input.justTouched()) {
				Gdx.app.log("Screen Touched", "Yes");
				velocity = -5;
			}
			if (moonWalk > 0 ) {
				moonWalk -= velocity;
				sunWalk -= velocity;
			}

		} else {
			gameState = 1;
		}
	}
	@Override
	public void dispose () {

	}
}

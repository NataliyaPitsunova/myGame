package ru.geekbrains.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class startGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    float time;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void render() {

        ScreenUtils.clear(Color.YELLOW);
        float x = Gdx.input.getX();
        float y = Gdx.graphics.getHeight() - Gdx.input.getY();
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            Gdx.app.exit();
        }
        time += Gdx.graphics.getDeltaTime();

        if (time >= 5) {
            Gdx.app.exit();
        }
        
        batch.begin();
        batch.draw(img, x, y,
                0, 0,
                img.getWidth(), img.getHeight(),
                1, 1,
                0,
                0, 0, img.getWidth(), img.getHeight(),
                false, false);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}

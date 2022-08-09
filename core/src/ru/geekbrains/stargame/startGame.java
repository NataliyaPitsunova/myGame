package ru.geekbrains.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class startGame extends ApplicationAdapter {
    SpriteBatch batch;
    int x, y;
    AnimHero batman;
    Label label;
    Texture img;

    @Override
    public void create() {
        batch = new SpriteBatch();
        batman = new AnimHero("runRight.png", 8, 1, 16,  Animation.PlayMode.LOOP);
        label = new Label(36, Color.BLACK);
        img = new Texture("badlogic.jpg");
    }


    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 0, 1);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x--;
        }
        ;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x++;
        }
        ;

        batman.step(Gdx.graphics.getDeltaTime());
        batch.begin();
        batch.draw(img,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(batman.getFrame(), x, Gdx.graphics.getHeight()/2);
        label.draw(batch, "Приветики",0,0);
        batch.end();
    }

    @Override
    public void dispose() {
        batman.dispose();
        batch.dispose();
        img.dispose();
    }
}

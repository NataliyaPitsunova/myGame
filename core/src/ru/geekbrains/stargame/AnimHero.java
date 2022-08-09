package ru.geekbrains.stargame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimHero {
    Animation<TextureRegion> animation;
    Texture texture;
    private float time;
    private boolean loop;

    public AnimHero(String name, int weight, int height, float fps, Animation.PlayMode mode) {
        this.loop = loop;
        texture = new Texture(name);
        TextureRegion region = new TextureRegion(texture);

        TextureRegion[][] regions = region.split(region.getRegionWidth() / weight, region.getRegionHeight() / height);
        TextureRegion[] regions1 = new TextureRegion[region.getRegionWidth() / weight * region.getRegionHeight() / height];
        int cnt = 0;
/*
        for (int i = 0; i < regions.length; i++) {
            for (int j = 0; j < regions[i].length; j++) {
                regions1 [cnt++] = regions[i][j];

            }
        }
*/
//HomeWork
        for (TextureRegion[] i : regions
        ) {
            for (TextureRegion element : i
            ) {
                regions1[cnt++] = element;
            }
        }
        animation = new Animation(1.0f / fps, regions[0]);
        animation.setPlayMode(mode);
    }

    public void step(float time) {
        this.time += time;
    }

    public void resetTime() {
        time = 0;
    }

    public boolean isFinished() {
        return animation.isAnimationFinished(time);
    }

    public void setPlayMode(Animation.PlayMode mode) {
        animation.setPlayMode(mode);
    }

    public TextureRegion getFrame() {
        return animation.getKeyFrame(time, loop);
    }

    public void dispose() {
        texture.dispose();
    }


}

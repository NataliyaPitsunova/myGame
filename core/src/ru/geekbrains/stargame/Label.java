package ru.geekbrains.stargame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Label {
    private BitmapFont bitmapFont;

    public Label(int size, Color color) {
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("ofont.ru_Tolkien.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = size;
        fontParameter.characters = "ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮюбьтимсчяждэдлорпавыфъхзщшгнекуцйЪ!,.-";
        bitmapFont = fontGenerator.generateFont(fontParameter);
        bitmapFont.setColor(color);
    }

    public void draw(SpriteBatch batch, String text, int x, int y) {
        bitmapFont.draw(batch, text, x, y + bitmapFont.getLineHeight());
    }

}

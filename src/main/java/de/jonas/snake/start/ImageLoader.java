package de.jonas.snake.start;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;

import java.awt.Image;

public final class ImageLoader {

    static Image title;

    @SneakyThrows
    public ImageLoader() {
        title = ImageIO.read(getClass().getResource("/SnakeTitle.jpg"));
    }

}

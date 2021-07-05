package com.dandan.common.utils.files;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Description
 * @Author dandan
 * @Date 2020/12/4
 */
public class ImageUtils {

    @Test
    public void test01() throws IOException {
        File file = new File("src/main/java/com/dandan/common/img/29661.jpg");
        BufferedImage bufferedImage = ImageIO.read(file);;

        System.out.println();
    }

}

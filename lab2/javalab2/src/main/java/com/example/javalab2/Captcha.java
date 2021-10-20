package com.example.javalab2;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@WebServlet(name = "Captcha", value = "/Captcha")
public class Captcha extends HttpServlet {

    public String getCaptcha() {
        char data[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
                '7', '8', '9' };
        char index[] = new char[7];
        Random r = new Random();
        int i = 0;
        for (i = 0; i < (index.length); i++) {
            int ran = r.nextInt(data.length);
            index[i] = data[ran];
        }
        return new String(index);
    }

    public static int num(int num) {
        return (new Random()).nextInt(num);
    }

    protected static Color color(int fc, int bc) {
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + num(bc - fc);
        int g = fc + num(bc - fc);
        int b = fc + num(bc - fc);
        return new Color(r, g, b);
    }

    public static BufferedImage pngCaptcha(String randomStr, int width, int height){
        Font font = new Font("Verdana", Font.ITALIC | Font.BOLD, 30);
        char[] strs = randomStr.toCharArray();
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bi.getGraphics();
        AlphaComposite ac3;
        Color color;
        int len = strs.length;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setFont(font);
        int h = height - ((height - font.getSize()) >> 1), w = width
                / len, size = w - font.getSize() + 1;
        for (int i = 0; i < len; i++) {
            ac3 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    0.7f);
            g.setComposite(ac3);

            color = new Color(20 + num(110), 30 + num(110),
                    30 + num(110));
            g.setColor(color);
            g.drawString(strs[i] + "", (width - (len - i) * w) + size,
                    h - 4);
        }
        return bi;
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String capcha = getCaptcha();
        request.getSession().setAttribute("captcha", capcha);
        BufferedImage myCaptcha = pngCaptcha(capcha, 200, 200);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(myCaptcha, "png", out);
        out.close();
    }

}

/**
 * 
 */
package com.jhhy.road.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhhy.road.util.CryptOperator;

/**
 * @author KQ
 *
 *         2017年5月11日
 */
@Controller
public class CodeController {
	private CryptOperator crypt = new CryptOperator();

	@SuppressWarnings("static-access")
	@CrossOrigin
	@RequestMapping(value = "/getVerifyCode/{code}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<byte[]> getVerifyCode(@PathVariable("code") String code) {
		// String [] fonts = ge.getAvailableFontFamilyNames();
		String newcode = null;
		while (newcode == null || newcode.trim().length() < 1) {
			try {
				newcode = crypt.decrypt(code, "abcdefgh");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		BufferedImage image = new BufferedImage(100, 28, BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		// int index = (int)(Math.random() * fonts.length);
		Font font = new Font("Arial", 2, 24);
		// System.out.println(fonts[8]);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString(newcode, 20, 28);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "png", output);
			byte[] bytes = output.toByteArray();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
			headers.setContentLength(bytes.length);
			return new HttpEntity<byte[]>(bytes, headers);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	// 生成验证码
	@SuppressWarnings("static-access")
	@CrossOrigin
	@RequestMapping(value = "createVerifyCode", method = RequestMethod.GET)
	public @ResponseBody String createVerfyCode() {
		String newcode = null;
		try {
			while (newcode == null || newcode.indexOf("/") > -1) {
				String code = "";
				String random[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G",
						"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
				for (int i = 0; i < 4; i++) {
					double index = Math.floor(Math.random() * 36);
					code = code + random[(int) index];
				}
				newcode = crypt.encrypt(code, "abcdefgh");
			}
		} catch (Exception e) {
		}
		return newcode;
	}

}

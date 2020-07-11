package com.github.support.utils.securty;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 验证码生成器 https://www.cnblogs.com/yhtboke/p/5749126.html
 * 
 * 验证码是用来区分人机的操作。 验证码划代的标准是人机识别过程中基于对人类知识的应用。 第一代：标准验证码
 * 这一代验证码是即是我们常见的图形验证码、语音验证码，基于机器难以处理复杂的计算机视觉及语音识别问题，而人类却可以轻松的识别来区分人类及机器。这一代验证码初步利用了人类知识容易解答，而计算机难以解答的机制进行人机判断。
 * 
 * 第二代：创新验证码
 * 第二代验证码是基于第一代验证码的核心思想（通过人类知识可以解答，而计算机难以解答的问题进行人机判断）而产生的创新的交互优化型验证码。第二代验证码基于第一代验证码的核心原理－－“人机之间知识的差异”，拓展出大量创新型验证码。
 * 
 * 第三代：无知识型验证码
 * 第三代验证码最大的特点是不再基于知识进行人机判断，而是基于人类固有的生物特征以及操作的环境信息综合决策，来判断是人类还是机器。无知识型验证码最大特点即无需人类思考，从而不会打断用户操作，进而提供更好的用户体验。
 * 如Google的新版ReCaptcha、阿里巴巴的滑动验证。参考知乎 关于验证码
 * 
 */
public class ValidateCode {
	// 验证码图片Buffer
	private BufferedImage buffImg = null;
	// 验证码
	private String code = null;
	// 验证码字符个数
	private int codeCount = 4;
	private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	// 图片的高度。
	private int height = 28;
	// 验证码干扰线数
	private int lineCount = 150;

	// 图片的宽度。
	private int width = 160;

	public ValidateCode() {
		this.createCode();
	}

	/**
	 * 
	 * @param width  图片宽
	 * @param height 图片高
	 */
	public ValidateCode(int width, int height) {
		this.width = width;
		this.height = height;
		this.createCode();
	}

	/**
	 * 
	 * @param width     图片宽
	 * @param height    图片高
	 * @param codeCount 字符个数
	 * @param lineCount 干扰线条数
	 */
	public ValidateCode(int width, int height, int codeCount, int lineCount) {
		this.width = width;
		this.height = height;
		this.codeCount = codeCount;
		this.lineCount = lineCount;
		this.createCode();
	}

	public void createCode() {
		int x = 0, fontHeight = 0, codeY = 0;
		int red = 0, green = 0, blue = 0;

		x = width / (codeCount + 2);// 每个字符的宽度
		fontHeight = height - 2;// 字体的高度
		codeY = height - 4;

		// 图像buffer
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		// 生成随机数
		Random random = new Random();
		// 将图像填充为白色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 创建字体
		Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
		g.setFont(font);
		// 干扰线
		for (int i = 0; i < lineCount; i++) {
			int xs = random.nextInt(width);
			int ys = random.nextInt(height);
			int xe = xs + random.nextInt(width / 8);
			int ye = ys + random.nextInt(height / 8);
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawLine(xs, ys, xe, ye);
		}

		// randomCode记录随机产生的验证码
		StringBuffer randomCode = new StringBuffer();
		// 随机产生codeCount个字符的验证码。
		for (int i = 0; i < codeCount; i++) {
			String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
			// 产生随机的颜色值，让输出的每个字符的颜色值都将不同。
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, (i + 1) * x, codeY);
			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
		}
		// 将四位数字的验证码保存到Session中。
		code = randomCode.toString();
	}

	public BufferedImage getBuffImg() {
		return buffImg;
	}

	public String getCode() {
		return code;
	}

	public void write(OutputStream sos) throws IOException {
		ImageIO.write(buffImg, "png", sos);
		sos.close();
	}

	public void write(String path) throws IOException {
		OutputStream sos = new FileOutputStream(path);
		this.write(sos);
	}
}

//2.3 控制器使用验证码 如 CodeController
//
//@RequestMapping("/getCode.do")
//    public void getCode(HttpServletRequest reqeust, HttpServletResponse response) throws IOException {
//
//        response.setContentType("image/jpeg");
//        // 禁止图像缓存。
//        response.setHeader("Pragma", "no-cache");
//        response.setHeader("Cache-Control", "no-cache");
//        response.setDateHeader("Expires", 0);
//
//        HttpSession session = reqeust.getSession();
//
//        ValidateCode vCode = new ValidateCode(100, 28, 4, 100);
//        session.setAttribute(Helper.SESSION_CHECKCODE, vCode.getCode());
//        vCode.write(response.getOutputStream());
//    }
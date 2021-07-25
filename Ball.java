package com.javawork28;

// 绘制小球线程代码

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Ball extends Thread {
	
	private JPanel mainPanel = null;
	
	private int x = 0;           // x，y 小球坐标
	private int y = 0;
	
	Random random = new Random();
	private int dx = random.nextInt(8);  // dx，dy位移大小，通过随机数赋值，实现每个小球运动的斜率不一样
	private int dy = random.nextInt(8);
	
	private int width = 20;      // width，height是小球的长高，一样就是圆的形状了
	private int height = 20;
	
	// 重写构造方法将进行操作的页面实例化时传入
	public Ball(JPanel p) {
		this.mainPanel = p;
	}
	
	// 重写线程的run方法
	public void run() {
		init();
		while(true) {    // 写一个死循环，除了点击退出按钮不然一直执行
			try {
				Thread.sleep(30);
				
				Graphics g = this.mainPanel.getGraphics();           // 实例化Graphics画笔g
				
				g.setColor(Color.WHITE);                             // setColor设置画出来的东西颜色为白色，也就是白色的小球
				g.setXORMode(Color.BLACK);                           // setXORMode设置当有画的东西时把他颜色背景变为黑色，也就相当于擦去原来的小球
				
				g.fillOval(this.x, this.y, this.width, this.height); // fillOval画出图案
				
				// 能一直偏移的代码
				x = x + dx;
				y = y + dy;
				
				// 当小球碰到边的情况，也就是大于当前panel的边时，一定要减去小球自身的长、高，不然小球碰撞时就会嵌入一些距离才反弹
				if(x > this.mainPanel.getWidth() - this.width) {
					dx = -dx;
				}
				if(y > this.mainPanel.getHeight() - this.height) {
					dy = -dy;
				}
				if(x < 0) {
					x = 0;
					dx = -dx;
				}
				if(y < 0) {
					y = 0;
					dy = -dy;
				}
				
				g.fillOval(x, y, this.width, this.height);
				
				g.dispose();                         // dispose释放绘画所占的资源
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 这是调用画笔方法，在run方法最开始就调用把画笔graphics实例化出来
	private void init(){
		Graphics graphics = this.mainPanel.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillOval(x, y, this.width, this.height);
		graphics.dispose();
	}
}
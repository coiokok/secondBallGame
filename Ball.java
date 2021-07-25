package com.javawork28;

// ����С���̴߳���

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Ball extends Thread {
	
	private JPanel mainPanel = null;
	
	private int x = 0;           // x��y С������
	private int y = 0;
	
	Random random = new Random();
	private int dx = random.nextInt(8);  // dx��dyλ�ƴ�С��ͨ���������ֵ��ʵ��ÿ��С���˶���б�ʲ�һ��
	private int dy = random.nextInt(8);
	
	private int width = 20;      // width��height��С��ĳ��ߣ�һ������Բ����״��
	private int height = 20;
	
	// ��д���췽�������в�����ҳ��ʵ����ʱ����
	public Ball(JPanel p) {
		this.mainPanel = p;
	}
	
	// ��д�̵߳�run����
	public void run() {
		init();
		while(true) {    // дһ����ѭ�������˵���˳���ť��Ȼһֱִ��
			try {
				Thread.sleep(30);
				
				Graphics g = this.mainPanel.getGraphics();           // ʵ����Graphics����g
				
				g.setColor(Color.WHITE);                             // setColor���û������Ķ�����ɫΪ��ɫ��Ҳ���ǰ�ɫ��С��
				g.setXORMode(Color.BLACK);                           // setXORMode���õ��л��Ķ���ʱ������ɫ������Ϊ��ɫ��Ҳ���൱�ڲ�ȥԭ����С��
				
				g.fillOval(this.x, this.y, this.width, this.height); // fillOval����ͼ��
				
				// ��һֱƫ�ƵĴ���
				x = x + dx;
				y = y + dy;
				
				// ��С�������ߵ������Ҳ���Ǵ��ڵ�ǰpanel�ı�ʱ��һ��Ҫ��ȥС������ĳ����ߣ���ȻС����ײʱ�ͻ�Ƕ��һЩ����ŷ���
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
				
				g.dispose();                         // dispose�ͷŻ滭��ռ����Դ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// ���ǵ��û��ʷ�������run�����ʼ�͵��ðѻ���graphicsʵ��������
	private void init(){
		Graphics graphics = this.mainPanel.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillOval(x, y, this.width, this.height);
		graphics.dispose();
	}
}
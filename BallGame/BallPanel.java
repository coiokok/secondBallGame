package com.javawork28;

// 这是小球弹跳的窗体

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BallPanel extends JFrame {
	
	private JPanel mainPanel = new JPanel();        // 小球弹跳的panel
	private JPanel operatePanel = new JPanel();     // 下方按钮的panel
	
	public BallPanel() {
		
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		this.mainPanel.setBackground(Color.BLACK);     // 将mainPanel的背景颜色设为黑色
		c.add(this.mainPanel, BorderLayout.CENTER);    // 将mainPanel添加进ContentPane实例化c
		
		
		JButton b1 = new JButton("开始");
		// 给开始按钮设置监听器直接在addActionListener()方法中实例化ActionListener添加方法，实例化小球Ball，执行线程的start方法
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ball b = new Ball(mainPanel);
				b.start();
			}	
		});
		
		
		JButton b2 = new JButton("退出");
		// 给开始按钮设置监听器直接在addActionListener()方法中实例化ActionListener添加方法
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// 将两个按钮添加进底部按钮panel
		this.operatePanel.add(b1);
		this.operatePanel.add(b2);
		c.add(this.operatePanel, BorderLayout.SOUTH);
		
		this.setBounds(650, 200, 600, 600);
		this.setTitle("小球游戏  by wyh");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

